package com.uniacademia.enade.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.uniacademia.enade.dao.ProvaDAO;
import com.uniacademia.enade.model.Prova;

@Path("prova")
public class ProvaResource {

    @GET
    @Produces("application/json; charset=UTF-8")
    @Path("/todasProvas")
    public List<Prova> todasProvas() {
    	return ProvaDAO.getInstance().buscarTodas(Prova.class);
    }

    @GET
    @Produces("application/json; charset=UTF-8")
    @Path("/getProva/{idProva}")
    public Prova getProva(@PathParam("idProva") Integer idProva) {
        return ProvaDAO.getInstance().buscar(Prova.class, idProva);
    }

    @DELETE
    @Produces("application/json; charset=UTF-8")
    @Path("/excluir/{idProva}")
    public String excluir(@PathParam("idProva") Integer idProva) {
        try {
            ProvaDAO.getInstance().remover(Prova.class, idProva);
            return "Registro excluído com sucesso!";
        } catch (Exception e) {
            return "Erro ao excluir o registro! " + e.getMessage();
        }
    }

    @DELETE
    @Produces("application/json; charset=UTF-8")
    @Path("/excluirTodas")
    public String excluirTodas() {
        try {
            ProvaDAO.getInstance().removeAll(Prova.class);
            return "Todos registros excluidos!";
        } catch (Exception e) {
            return "Erro ao excluir o registro! " + e.getMessage();
        }
    }

    @POST
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    @Path("/cadastrar")
    public String cadastrar(Prova prova) {
        try {
        	Prova p = novaProva(prova);
            ProvaDAO.getInstance().atualizar(p);
            return "Registro cadastrado com sucesso!";
        } catch (Exception e) {
            return "Erro ao cadastrar um registro! " + e.getMessage();
        }
    }

    @POST
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    @Path("/alterar")
    public String alterar(Prova prova) {
        try {
            Prova p = novaProva(prova);
            return ProvaDAO.getInstance().atualizar(p).toString();
        } catch (Exception e) {
            return "Erro ao atualizar um registro! " + e.getMessage();
        }
    }
    
    private Prova novaProva(Prova prova) {
    	Prova p = new Prova();
    	p.setIdProva(prova.getId());
        p.setDataProva(prova.getDataProva());
        p.setQuestaoList(prova.getQuestaoList());
        p.setResultadoList(prova.getResultadoList());
        return p;
    }
}
