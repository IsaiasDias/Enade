package com.uniacademia.enade.resources;

import com.uniacademia.enade.dao.UsuarioDAO;
import com.uniacademia.enade.model.TipoUsuario;
import com.uniacademia.enade.model.Usuario;
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

@Path("usuario")
public class UsuarioResource {

    @GET
    @Produces("application/json; charset=UTF-8")
    @Path("/todosUsuarios")
    public List<Usuario> todosUsuarios() {
        List<Usuario> usuarios = UsuarioDAO.getInstance().buscarTodas(Usuario.class);
        return usuarios;
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
    public String Excluir(@PathParam("idUsuario") Integer idUsuario) {
        try {
            Usuario usuario = new Usuario(idUsuario, "", "", "");
            usuario.setTipoUsuarioidTipoUsuario(new TipoUsuario(1));
            UsuarioDAO.getInstance().remover(usuario);
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
            return "Todos os registros excluídos com sucesso!";
        } catch (Exception e) {
            return "Erro ao excluir o registro! " + e.getMessage();
        }
    }

    @POST
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    @Path("/cadastrar")
    public String Cadastrar(Usuario usuario) {
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
    public String Alterar(Usuario usuario) {
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

    @GET
    public Response ping() {
        return Response
                .ok("ping")
                .build();
    }
}
