
package com.uniacademia.enade.resources;

import com.uniacademia.enade.dao.QuestaoDAO;
import com.uniacademia.enade.model.Questao;
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

@Path("questao")
public class QuestaoResource {

    @GET
    @Produces("application/json; charset=UTF-8")
    @Path("/todasQuestoes")
    public List<Questao> todasQuestoes() {
        return QuestaoDAO.getInstance().buscarTodas(Questao.class);
    }

    @GET
    @Produces("application/json; charset=UTF-8")
    @Path("/getQuestao/{idQuestao}")
    public Questao getQuestao(@PathParam("idQuestao") Integer idQuestao) {
        return QuestaoDAO.getInstance().buscar(Questao.class, idQuestao);
    }

    @DELETE
    @Produces("application/json; charset=UTF-8")
    @Path("/excluir/{idQuestao}")
    public String Excluir(@PathParam("idQuestao") Integer idQuestao) {
        try {
            Questao questao = new Questao(idQuestao, null);
            QuestaoDAO.getInstance().remover(questao);
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
            QuestaoDAO.getInstance().removeAll(Questao.class);
            return "Todos os registros excluídos com sucesso!";
        } catch (Exception e) {
            return "Erro ao excluir o registro! " + e.getMessage();
        }
    }

    @POST
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    @Path("/cadastrar")
    public String Cadastrar(Questao questao) {
        try {
        	Questao q = novaQuestao(questao);
            QuestaoDAO.getInstance().atualizar(q);
            return "Registro cadastrado com sucesso!";
        } catch (Exception e) {
            return "Erro ao cadastrar um registro! " + e.getMessage();
        }
    }

    @PUT
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    @Path("/alterar")
    public String Alterar(Questao questao) {
        try {
            Questao q = novaQuestao(questao);
            return QuestaoDAO.getInstance().atualizar(q).toString();
        } catch (Exception e) {
            return "Erro ao atualizar um registro! " + e.getMessage();
        }
    }
    
    private Questao novaQuestao(Questao questao) {
    	Questao q = new Questao();
    	q.setIdQuestao(questao.getId());
        q.setAlternativaA(questao.getAlternativaA());
        q.setAlternativaB(questao.getAlternativaB());
        q.setAlternativaC(questao.getAlternativaC());
        q.setAlternativaD(questao.getAlternativaD());
        q.setAlternativaE(questao.getAlternativaE());
        q.setDescricaoQuestao(questao.getDescricaoQuestao());
        q.setQuestaoCorreta(questao.getQuestaoCorreta());
        q.setEstadoQuestao(questao.getEstadoQuestao());
        q.setTipoQuestaoidTipoQuestao(questao.getTipoQuestaoidTipoQuestao());
        q.setProvaList(questao.getProvaList());
        return q;
    }

    @GET
    public Response ping() {
        return Response
                .ok("ping")
                .build();
    }
}
