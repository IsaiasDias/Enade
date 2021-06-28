package com.uniacademia.enade.controller;

import com.google.common.hash.Hashing;
import com.uniacademia.enade.dao.UsuarioDAO;
import com.uniacademia.enade.model.TipoUsuario;
import com.uniacademia.enade.model.Usuario;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.event.RowEditEvent;

@Named
@ViewScoped
public class UsuarioController implements Serializable{
    
    private Usuario usuario;
    private List<Usuario> usuarios;
    
    String senha1;
    String senha2;
    
    public UsuarioController(){
        usuarios = UsuarioDAO.getInstance().buscarTodas(Usuario.class);
        usuario = new Usuario();
    }
    
    public void gravar(){
        salvarUsuario(usuario, true);
    }
    
    public void remover(){
        UsuarioDAO.getInstance().remover(Usuario.class, usuario.getId());
        usuarios = UsuarioDAO.getInstance().buscarTodas(Usuario.class);
        usuario = new Usuario();
    }
    
    public void atualizarSenha() {
        if (senha1 != null && senha2 != null && senha1.equals(senha2)) {
            usuario = UsuarioDAO.getInstance().find(usuario.getId());
            usuario.setSenha(senha1);
            gravar();
            FacesMessage msg = new FacesMessage("Editado", "Senha alterada com sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
            FacesMessage msg = new FacesMessage("Cancelado", "Senhas não conferem!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
    
    public Usuario salvarUsuario(Usuario u, boolean buscarUsuarios) {
        u.setSenha(Hashing.sha256().hashString(u.getSenha(), StandardCharsets.UTF_8).toString());
        if (u.getTipoUsuarioidTipoUsuario() == null) {
            TipoUsuario tipoUsuario = new TipoUsuario();
            tipoUsuario.setIdTipoUsuario(1);
            tipoUsuario.setNomeTipoUsuario("Aluno");
            u.setTipoUsuarioidTipoUsuario(tipoUsuario);
        }
        Usuario usuarioPersisted = UsuarioDAO.getInstance().atualizar(u);
        if (buscarUsuarios) {
            usuarios = UsuarioDAO.getInstance().buscarTodas(Usuario.class);
            usuario = new Usuario();
        }
        return usuarioPersisted;
    }
    
    public void onRowEdit(RowEditEvent event) {
        Usuario obj = (Usuario) event.getObject();
        setUsuario(obj);
        gravar();
        FacesMessage msg = new FacesMessage("Editado", obj.toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent<Usuario> event) {
        FacesMessage msg = new FacesMessage("Cancelado", event.getObject().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public String getSenha1() {
        return senha1;
    }

    public String getSenha2() {
        return senha2;
    }
        
}
