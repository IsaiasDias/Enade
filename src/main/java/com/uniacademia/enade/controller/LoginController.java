package com.uniacademia.enade.controller;

import com.google.common.hash.Hashing;
import com.uniacademia.enade.dao.UsuarioDAO;
import com.uniacademia.enade.model.Usuario;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

@Named
@SessionScoped
public class LoginController implements Serializable {

    private final UsuarioController usuarioController;
    private Usuario usuarioLogin;
    private Usuario usuarioCadastro;

    public LoginController() {
        usuarioController = new UsuarioController();
        usuarioLogin = new Usuario();
        usuarioCadastro = new Usuario();
    }

    public String cadastrar() {
        Usuario usuarioFind = UsuarioDAO.getInstance().findByEmail(usuarioCadastro);
        if (usuarioFind == null) {
            Usuario usuarioPersisted = usuarioController.salvarUsuario(usuarioCadastro, false);
            setUsuarioLogin(usuarioPersisted);

            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            session.setAttribute("usuario", usuarioLogin);
            return "/index?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "E-mail já cadastrado. Por favor faça o login!", null));
            return null;
        }
    }

    public String login() {
        usuarioLogin.setSenha(Hashing.sha256().hashString(usuarioLogin.getSenha(), StandardCharsets.UTF_8).toString());
        Usuario usuarioFind = UsuarioDAO.getInstance().logIn(usuarioLogin);
        if (usuarioFind == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "E-mail ou senha inválidos!", null));
            return null;
        } else {
            setUsuarioLogin(usuarioFind);
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            session.setAttribute("usuario", usuarioLogin);
            return "/index?faces-redirect=true";
        }
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/login?faces-redirect=true";
    }

    public String goHome() {
        return "/login?faces-redirect=true";
    }

    public boolean isProfessor() {
        return usuarioLogin.getTipoUsuarioidTipoUsuario().getNomeTipoUsuario().equals("Professor");
    }

    public Usuario getUsuarioLogin() {
        return usuarioLogin;
    }

    public void setUsuarioLogin(Usuario usuarioLogin) {
        this.usuarioLogin = usuarioLogin;
    }

    public Usuario getUsuarioCadastro() {
        return usuarioCadastro;
    }

    public void setUsuarioCadastro(Usuario usuarioCadastro) {
        this.usuarioCadastro = usuarioCadastro;
    }

}
