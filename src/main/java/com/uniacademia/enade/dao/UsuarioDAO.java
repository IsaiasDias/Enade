package com.uniacademia.enade.dao;

import com.uniacademia.enade.model.Usuario;

public class UsuarioDAO extends GenericoDAO<Usuario> {
    
	private static UsuarioDAO usuarioDAO;

    public static UsuarioDAO getInstance() {
        if (usuarioDAO == null) {
            usuarioDAO = new UsuarioDAO();
        }
        return usuarioDAO;
    }
    
    private UsuarioDAO () {
        
    }

}
