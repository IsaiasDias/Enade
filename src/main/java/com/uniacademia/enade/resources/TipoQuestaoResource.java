package com.uniacademia.enade.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.uniacademia.enade.dao.TipoQuestaoDAO;
import com.uniacademia.enade.model.TipoQuestao;

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
    @Path("/buscar/{idTipoQuestao}")
    public TipoQuestao getTipoQuestao(@PathParam("idTipoQuestao") Integer idTipoQuestao) {
        return idTipoQuestao == null ? null : TipoQuestaoDAO.getInstance().buscar(TipoQuestao.class, idTipoQuestao);
    }

    @DELETE
    @Produces("application/json; charset=UTF-8")
    @Path("/excluir/{codigo}")
    public String excluir(@PathParam("codigo") Integer id) {
        try {
            TipoQuestaoDAO.getInstance().remover(TipoQuestao.class, id);
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
            return "Todos registros excluidos!";
        } catch (Exception e) {
            return "Erro ao excluir o registro! " + e.getMessage();
        }
    }

    @POST
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    @Path("/cadastrar")
    public String cadastrar(TipoQuestao tipoQuestao) {
        try {
            TipoQuestao tp = novoTipoQuestao(tipoQuestao);
            TipoQuestaoDAO.getInstance().atualizar(tp);
            return "Registro cadastrado com sucesso!";
        } catch (Exception e) {
            return "Erro ao cadastrar um registro! " + e.getMessage();
        }
    }

    @POST
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    @Path("/alterar")
    public String alterar(TipoQuestao tipoQuestao) {
        TipoQuestao tp;
        try {
            if(tipoQuestao.getId() == null){
                tp = novoTipoQuestao(tipoQuestao);
            } else {
                tp = getTipoQuestao(tipoQuestao.getId());
                tp.setNomeTipoQuestao(tipoQuestao.getNomeTipoQuestao());
            }            
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
}
