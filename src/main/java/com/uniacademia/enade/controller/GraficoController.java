package com.uniacademia.enade.controller;

import com.uniacademia.enade.dao.ResultadoDAO;
import com.uniacademia.enade.dao.UsuarioDAO;
import com.uniacademia.enade.model.Resultado;
import com.uniacademia.enade.model.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.PieChartModel;

@Named
@SessionScoped
public class GraficoController implements Serializable {

    List<Resultado> ultimosDezResultados = new ArrayList<>();
    List<Resultado> totalResultados = new ArrayList<>();
    List<Usuario> totalAlunos = new ArrayList<>();

    private PieChartModel pieModel;
    private BarChartModel barModel;

    public GraficoController() {
        ultimosDezResultados = ResultadoDAO.getInstance().findUltimosDezResultados();
        totalResultados = ResultadoDAO.getInstance().buscarTodas(Resultado.class);
        totalAlunos = UsuarioDAO.getInstance().findAllAlunos();
    }

    @PostConstruct
    public void init() {
        createPieModel();
        createBarModel();
    }

    private void createPieModel() {
        pieModel = new PieChartModel();

        double qtdAlunosFizeram = (double) totalResultados.size() / (double) totalAlunos.size() * 100;
        pieModel.set("Fizeram", qtdAlunosFizeram);
        pieModel.set("Não fizeram", 100 - qtdAlunosFizeram);

        pieModel.setTitle("Alunos que fizeram e não fizeram a prova (%)");
        pieModel.setLegendPosition("w");
        pieModel.setShadow(false);
    }

    private void createBarModel() {
        ChartSeries notas = new ChartSeries();
        notas.setLabel("Notas");

        ultimosDezResultados.stream().forEach(it -> notas.set(it.getUsuarioidUsuario().getNome(), it.getValorObtido()));

        BarChartModel model = new BarChartModel();
        model.addSeries(notas);
        barModel = model;

        barModel.setTitle("Notas dos últimos 10 alunos que fizeram a prova");
        barModel.setLegendPosition("ne");

        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Alunos");

        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Notas");
        yAxis.setMin(0);
        yAxis.setMax(10);
    }

    public PieChartModel getPieModel() {
        return pieModel;
    }

    public void setPieModel(PieChartModel pieModel) {
        this.pieModel = pieModel;
    }

    public BarChartModel getBarModel() {
        return barModel;
    }

    public void setBarModel(BarChartModel barModel) {
        this.barModel = barModel;
    }

    public List<Resultado> getUltimosDezResultados() {
        return ultimosDezResultados;
    }

    public void setUltimosDezResultados(List<Resultado> ultimosDezResultados) {
        this.ultimosDezResultados = ultimosDezResultados;
    }

    public List<Resultado> getTotalResultados() {
        return totalResultados;
    }

    public void setTotalResultados(List<Resultado> totalResultados) {
        this.totalResultados = totalResultados;
    }

    public List<Usuario> getTotalAlunos() {
        return totalAlunos;
    }

    public void setTotalAlunos(List<Usuario> totalAlunos) {
        this.totalAlunos = totalAlunos;
    }

}
