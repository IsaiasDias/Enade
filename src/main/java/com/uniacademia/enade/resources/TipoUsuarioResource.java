package com.uniacademia.enade.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.uniacademia.enade.dao.TipoUsuarioDAO;
import com.uniacademia.enade.model.TipoUsuario;

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
    @Path("/getTipoUsuario/{id}")
    public TipoUsuario getTipoUsuario(@PathParam("id") Integer id) {
        return TipoUsuarioDAO.getInstance().buscar(TipoUsuario.class, id);
    }

    @DELETE
    @Produces("application/json; charset=UTF-8")
    @Path("/excluir/{codigo}")
    public String excluir(@PathParam("codigo") Integer id) {
        try {
            TipoUsuarioDAO.getInstance().remover(TipoUsuario.class, id);
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
            return "Todos registros excluidos!";
        } catch (Exception e) {
            return "Erro ao excluir o registro! " + e.getMessage();
        }
    }

    @POST
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    @Path("/cadastrar")
    public String cadastrar(TipoUsuario tipoUsuario) {
        try {
        	TipoUsuario tu = novoTipoUsuario(tipoUsuario);
            TipoUsuarioDAO.getInstance().persistir(tu);
            return "Registro cadastrado com sucesso!";
        } catch (Exception e) {
            return "Erro ao cadastrar um registro! " + e.getMessage();
        }
    }

    @POST
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    @Path("/alterar")
    public String alterar(TipoUsuario tipoUsuario) {
        TipoUsuario tu;
        try {
            if(tipoUsuario.getId() == null){
                tu = novoTipoUsuario(tipoUsuario);
            } else {
                tu = getTipoUsuario(tipoUsuario.getId());
                tu.setNomeTipoUsuario(tipoUsuario.getNomeTipoUsuario());
            }        	 
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
}
