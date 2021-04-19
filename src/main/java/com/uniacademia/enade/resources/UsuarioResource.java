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

import com.uniacademia.enade.dao.UsuarioDAO;
import com.uniacademia.enade.model.Usuario;

@Path("usuario")
public class UsuarioResource {

    @GET
    @Produces("application/json; charset=UTF-8")
    @Path("/todosUsuarios")
    public List<Usuario> todosUsuarios() {
        return UsuarioDAO.getInstance().buscarTodas(Usuario.class);
    }

    @GET
    @Produces("application/json; charset=UTF-8")
    @Path("/getUsuario/{nome}")
    public Usuario getUsuario(@PathParam("nome") Integer id) {
        return UsuarioDAO.getInstance().buscar(Usuario.class, id);
    }

    @DELETE
    @Produces("application/json; charset=UTF-8")
    @Path("/excluir/{idUsuario}")
    public String excluir(@PathParam("idUsuario") Integer idUsuario) {
        try {
            UsuarioDAO.getInstance().remover(Usuario.class, idUsuario);
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
            UsuarioDAO.getInstance().removeAll(Usuario.class);
            return "Todos registros excluidos!";
        } catch (Exception e) {
            return "Erro ao excluir o registro! " + e.getMessage();
        }
    }

    @POST
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    @Path("/cadastrar")
    public String cadastrar(Usuario usuario) {
        try {
        	Usuario u = novoUsuario(usuario);
            UsuarioDAO.getInstance().persistir(u);
            return "Registro cadastrado com sucesso!";
        } catch (Exception e) {
            return "Erro ao cadastrar um registro! " + e.getMessage();
        }
    }

    @PUT
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    @Path("/alterar")
    public String alterar(Usuario usuario) {
        try {
            Usuario u = novoUsuario(usuario);
            return UsuarioDAO.getInstance().atualizar(u).toString();
        } catch (Exception e) {
            return "Erro ao atualizar um registro! " + e.getMessage();
        }
    }
    
    private Usuario novoUsuario(Usuario usuario) {
    	Usuario u = new Usuario();
    	u.setIdUsuario(usuario.getId());
        u.setNome(usuario.getNome());
        u.setEmail(usuario.getNome());
        u.setSenha(usuario.getSenha());
        u.setTipoUsuarioidTipoUsuario(usuario.getTipoUsuarioidTipoUsuario());
        return u;
    }
}
