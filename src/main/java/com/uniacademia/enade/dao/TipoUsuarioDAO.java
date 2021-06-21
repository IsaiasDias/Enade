package com.uniacademia.enade.dao;

import com.uniacademia.enade.model.TipoUsuario;

public class TipoUsuarioDAO extends GenericDAO<TipoUsuario> {
     
    public static TipoUsuarioDAO tipoUsuarioDAO;
    
    public static TipoUsuarioDAO getInstance(){
        if(tipoUsuarioDAO == null){
            tipoUsuarioDAO = new TipoUsuarioDAO();
        }
        return tipoUsuarioDAO;
    }
    
    private TipoUsuarioDAO() {
        
    }
}
