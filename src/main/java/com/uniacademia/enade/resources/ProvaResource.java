package com.uniacademia.enade.resources;

import com.uniacademia.enade.dao.ProvaDAO;
import com.uniacademia.enade.model.Prova;
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
    public String Excluir(@PathParam("idProva") Integer idProva) {
        try {
            Prova prova = new Prova(idProva, null);
            ProvaDAO.getInstance().remover(prova);
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
            return "Todos os registros excluídos com sucesso!";
        } catch (Exception e) {
            return "Erro ao excluir o registro! " + e.getMessage();
        }
    }

    @POST
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    @Path("/cadastrar")
    public String Cadastrar(Prova prova) {
        try {
        	Prova p = novaProva(prova);
            ProvaDAO.getInstance().atualizar(p);
            return "Registro cadastrado com sucesso!";
        } catch (Exception e) {
            return "Erro ao cadastrar um registro! " + e.getMessage();
        }
    }

    @PUT
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    @Path("/alterar")
    public String Alterar(Prova prova) {
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

    @GET
    public Response ping() {
        return Response
                .ok("ping")
                .build();
    }
}
