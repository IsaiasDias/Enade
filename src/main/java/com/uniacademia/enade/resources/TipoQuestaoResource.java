package com.uniacademia.enade.resources;

import com.uniacademia.enade.dao.TipoQuestaoDAO;
import com.uniacademia.enade.model.TipoQuestao;
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

@Path("tipoquestao")
public class TipoQuestaoResource {

    @GET
    @Produces("application/json; charset=UTF-8")
    @Path("/todosTipoQuestao")
    public List<TipoQuestao> todosTipoQuestao() {
        return TipoQuestaoDAO.getInstance().buscarTodas(TipoQuestao.class);
    }

    @GET
    @Produces("application/json; charset=UTF-8")
    @Path("/getTipoQuestao/{idTipoQuestao}")
    public TipoQuestao getTipoQuestao(@PathParam("idTipoQuestao") Integer idTipoQuestao) {
        return TipoQuestaoDAO.getInstance().buscar(TipoQuestao.class, idTipoQuestao);
    }

    @DELETE
    @Produces("application/json; charset=UTF-8")
    @Path("/excluir/{codigo}")
    public String Excluir(@PathParam("codigo") Integer codigo) {
        try {
            TipoQuestao tipoQuestao = new TipoQuestao(codigo);
            TipoQuestaoDAO.getInstance().remover(tipoQuestao);
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
            TipoQuestaoDAO.getInstance().removeAll(TipoQuestao.class);
            return "Todos os registros excluídos com sucesso!";
        } catch (Exception e) {
            return "Erro ao excluir o registro! " + e.getMessage();
        }
    }

    @POST
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    @Path("/cadastrar")
    public String Cadastrar(TipoQuestao tipoQuestao) {
        try {
        	TipoQuestao tp = novoTipoQuestao(tipoQuestao);
            TipoQuestaoDAO.getInstance().atualizar(tp);
            return "Registro cadastrado com sucesso!";
        } catch (Exception e) {
            return "Erro ao cadastrar um registro! " + e.getMessage();
        }
    }

    @PUT
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    @Path("/alterar")
    public String Alterar(TipoQuestao tipoQuestao) {
        try {
        	TipoQuestao tp = novoTipoQuestao(tipoQuestao);
            return TipoQuestaoDAO.getInstance().atualizar(tp).toString();
        } catch (Exception e) {
            return "Erro ao atualizar um registro! " + e.getMessage();
        }
    }
    
    private TipoQuestao novoTipoQuestao(TipoQuestao tipoQuestao) {
    	TipoQuestao tp = new TipoQuestao();
    	tp.setIdTipoQuestao(tipoQuestao.getId());
        tp.setNomeTipoQuestao(tipoQuestao.getNomeTipoQuestao());
        return tp;
    }

    @GET
    public Response ping() {
        return Response
                .ok("ping")
                .build();
    }
}
