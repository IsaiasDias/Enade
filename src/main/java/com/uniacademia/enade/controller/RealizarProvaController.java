package com.uniacademia.enade.controller;

import com.uniacademia.enade.dao.ProvaDAO;
import com.uniacademia.enade.model.Prova;
import com.uniacademia.enade.model.Questao;
import com.uniacademia.enade.model.Resultado;
import com.uniacademia.enade.model.Usuario;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

@Named
@ViewScoped
public class RealizarProvaController implements Serializable {

    private final ResultadoController resultadoController;

    HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
    Prova prova = new Prova();

    public RealizarProvaController() {
        resultadoController = new ResultadoController();
        prova = ProvaDAO.getInstance().findUltimaProvaAtiva(getUsuarioLogado().getId());
    }

    public String finalizarProva() {
        double valorObtido = 0;
        double valorPorQuestao = 10.0 / prova.getQuestaoList().size();
        for (Questao questao : prova.getQuestaoList()) {
            String tipoQuestao = questao.getTipoQuestaoidTipoQuestao().getNomeTipoQuestao();
            if (tipoQuestao.equals("Discursiva") && !questao.getResposta().trim().equals("")) {
                valorObtido += valorPorQuestao;
            } else if (tipoQuestao.equals("Múltipla escolha") && questao.getQuestaoCorreta().toString().equals(questao.getResposta())) {
                valorObtido += valorPorQuestao;
            }
        }

        Resultado resultado = new Resultado();
        resultado.setProvaidProva(prova);
        resultado.setUsuarioidUsuario(getUsuarioLogado());
        resultado.setValorObtido(Math.round(valorObtido * 10.0) / 10.0);
        resultadoController.setResultado(resultado);
        resultadoController.gravar();
        return "/resultados?faces-redirect=true";
    }

    private Usuario getUsuarioLogado() {
        return (Usuario) session.getAttribute("usuario");
    }

    public Prova getProva() {
        return prova;
    }

    public void setProva(Prova prova) {
        this.prova = prova;
    }

}
