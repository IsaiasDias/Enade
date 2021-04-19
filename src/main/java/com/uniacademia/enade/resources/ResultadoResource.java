
package com.uniacademia.enade.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.uniacademia.enade.dao.ResultadoDAO;
import com.uniacademia.enade.model.Resultado;

@Path("resultado")
public class ResultadoResource {

    @GET
    @Produces("application/json; charset=UTF-8")
    @Path("/todosResultados")
    public List<Resultado> todosResultados() {
        return ResultadoDAO.getInstance().buscarTodas(Resultado.class);
    }

    @GET
    @Produces("application/json; charset=UTF-8")
    @Path("/getResultado/{idResultado}")
    public Resultado getResultado(@PathParam("idResultado") Integer idResultado) {
        return idResultado == null ? null : ResultadoDAO.getInstance().buscar(Resultado.class, idResultado);
    }

    @DELETE
    @Produces("application/json; charset=UTF-8")
    @Path("/excluir/{idResultado}")
    public String excluir(@PathParam("idResultado") Integer idResultado) {
        try {
            ResultadoDAO.getInstance().remover(Resultado.class, idResultado);
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
            ResultadoDAO.getInstance().removeAll(Resultado.class);
            return "Todos registros excluidos!";
        } catch (Exception e) {
            return "Erro ao excluir o registro! " + e.getMessage();
        }
    }

    @POST
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    @Path("/cadastrar")
    public String cadastrar(Resultado resultado) {
        try {
        	Resultado r = novoResultado(resultado);
            ResultadoDAO.getInstance().persistir(r);
            return "Registro cadastrado com sucesso!";
        } catch (Exception e) {
            return "Erro ao cadastrar um registro! " + e.getMessage();
        }
    }

    @PUT
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    @Path("/alterar")
    public String alterar(Resultado resultado) {
        Resultado r;
        try {
            if(resultado.getId() == null){
                r = novoResultado(resultado);
            } else {
                r = getResultado(resultado.getId());
                r.setValorObtido(resultado.getValorObtido());
                r.setProvaidProva(resultado.getProvaidProva());
                r.setUsuarioidUsuario(resultado.getUsuarioidUsuario());
            }        	
            return ResultadoDAO.getInstance().atualizar(r).toString();
        } catch (Exception e) {
            return "Erro ao atualizar um registro! " + e.getMessage();
        }
    }
    
    private Resultado novoResultado(Resultado resultado) {
    	Resultado r = new Resultado();
    	r.setIdResultado(resultado.getId());
        r.setValorObtido(resultado.getValorObtido());
        r.setProvaidProva(resultado.getProvaidProva());
        r.setUsuarioidUsuario(resultado.getUsuarioidUsuario());
        return r;
    }
}
