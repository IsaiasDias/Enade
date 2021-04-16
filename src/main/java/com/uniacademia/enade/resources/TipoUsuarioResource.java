package com.uniacademia.enade.resources;

import com.uniacademia.enade.dao.TipoUsuarioDAO;
import com.uniacademia.enade.model.TipoUsuario;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("tipousuario")
public class TipoUsuarioResource {

    @GET
    @Produces("application/json; charset=UTF-8")
    @Path("/todosTipoUsuario")
    public List<TipoUsuario> todosTipoUsuario() {
        return TipoUsuarioDAO.getInstance().buscarTodas(TipoUsuario.class);
    }

    @GET
    @Produces("application/json; charset=UTF-8")
    @Path("/getTipoUsuario/{nome}")
    public TipoUsuario getTipoUsuario(@PathParam("nome") Integer id) {
        return TipoUsuarioDAO.getInstance().buscar(TipoUsuario.class, id);
    }

    @DELETE
    @Produces("application/json; charset=UTF-8")
    @Path("/excluir/{codigo}")
    public String Excluir(@PathParam("codigo") Integer codigo) {
        try {
            TipoUsuario tipoUsuario = new TipoUsuario(codigo, "");
            TipoUsuarioDAO.getInstance().remover(tipoUsuario);
            return "Registro excluído com sucesso!";
        } catch (Exception e) {
            return "Erro ao excluir o registro! " + e.getMessage();
        }
    }

    @DELETE
    @Produces("application/json; charset=UTF-8")
    @Path("/excluirTodos")
    public String excluirTodos() {
        try {
            TipoUsuarioDAO.getInstance().removeAll(TipoUsuario.class);
            return "Todos os registros excluídos com sucesso!";
        } catch (Exception e) {
            return "Erro ao excluir o registro! " + e.getMessage();
        }
    }

    @POST
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    @Path("/cadastrar")
    public String Cadastrar(TipoUsuario tipoUsuario) {
        try {
        	TipoUsuario tu = novoTipoUsuario(tipoUsuario);
            TipoUsuarioDAO.getInstance().persistir(tu);
            return "Registro cadastrado com sucesso!";
        } catch (Exception e) {
            return "Erro ao cadastrar um registro! " + e.getMessage();
        }
    }

    @PUT
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    @Path("/alterar")
    public String Alterar(TipoUsuario tipoUsuario) {
        try {
        	TipoUsuario tu = novoTipoUsuario(tipoUsuario);
            return TipoUsuarioDAO.getInstance().atualizar(tu).toString();
        } catch (Exception e) {
            return "Erro ao atualizar um registro! " + e.getMessage();
        }
    }
    
    private TipoUsuario novoTipoUsuario(TipoUsuario tipoUsuario) {
    	TipoUsuario tu = new TipoUsuario();
    	tu.setIdTipoUsuario(tipoUsuario.getId());
        tu.setNomeTipoUsuario(tipoUsuario.getNomeTipoUsuario());
        return tu;
    }

    @GET
    public Response ping() {
        return Response
                .ok("ping")
                .build();
    }
}
