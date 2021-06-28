package com.uniacademia.enade.dao;

import com.uniacademia.enade.model.Usuario;
import java.util.List;

public class UsuarioDAO extends GenericDAO<Usuario>{
    
    public static UsuarioDAO usuarioDAO;
    
    public static UsuarioDAO getInstance(){
        if(usuarioDAO == null){
            usuarioDAO = new UsuarioDAO();
        }
        return usuarioDAO;
    } 
    
    private UsuarioDAO() {
        
    }
    
    public Usuario findByEmail(Usuario usuario) {
        return (Usuario) findSingleResult(em.createNamedQuery("Usuario.findByEmail")
                .setParameter("email", usuario.getEmail()));
    }

    public Usuario logIn(Usuario usuario) {
        return (Usuario) findSingleResult(em.createNamedQuery("Usuario.findByEmailAndSenha")
                .setParameter("email", usuario.getEmail())
                .setParameter("senha", usuario.getSenha()));
    }
    
    public List<Usuario> findAllAlunos() {
        return em.createNamedQuery("Usuario.findAllAlunos").getResultList();
    }
    
    public Usuario find (Integer id) {
        return (Usuario) findSingleResult(em.createNamedQuery("Usuario.findByIdUsuario")
                .setParameter("idUsuario", id));
    }
}
