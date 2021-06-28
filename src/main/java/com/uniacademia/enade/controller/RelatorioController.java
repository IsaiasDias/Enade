/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniacademia.enade.controller;

import com.uniacademia.enade.reports.Relatorio;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class RelatorioController implements Serializable {

    public RelatorioController() {
    }

    public void gerarRelatorioAlunosPendentesProva() {
        Relatorio relatorio = new Relatorio();
        relatorio.getRelatorio("alunosPendentesProva");
    }

    public void gerarRelatorioAlunosFizeramProva() {
        Relatorio relatorio = new Relatorio();
        relatorio.getRelatorio("resultadoAlunosProva");
    }

    public void gerarRelatorioAlunosCadastrados() {
        Relatorio relatorio = new Relatorio();
        relatorio.getRelatorio("usuario");
    }

}
