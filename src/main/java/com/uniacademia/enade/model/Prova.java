/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniacademia.enade.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "Prova")
@NamedQueries({
    @NamedQuery(name = "Prova.buscarTodas", query = "SELECT p FROM Prova p"),
    @NamedQuery(name = "Prova.findByIdProva", query = "SELECT p FROM Prova p WHERE p.idProva = :idProva"),
    @NamedQuery(name = "Prova.findByDataProva", query = "SELECT p FROM Prova p WHERE p.dataProva = :dataProva")})
public class Prova  implements EntidadeBase {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProva")
    private Integer idProva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dataProva")
    @Temporal(TemporalType.DATE)
    private Date dataProva;
    @JoinTable(name = "Prova_has_Questao", joinColumns = {
        @JoinColumn(name = "Prova_idProva", referencedColumnName = "idProva")}, inverseJoinColumns = {
        @JoinColumn(name = "Questao_idQuestao", referencedColumnName = "idQuestao")})
    @ManyToMany
    private List<Questao> questaoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "provaidProva")
    private List<Resultado> resultadoList;

    public Prova() {
    }

    public Prova(Integer idProva) {
        this.idProva = idProva;
    }

    public Prova(Integer idProva, Date dataProva) {
        this.idProva = idProva;
        this.dataProva = dataProva;
    }
    
    @Override
    public Integer getId() {
        return idProva;
    }

    public void setIdProva(Integer idProva) {
        this.idProva = idProva;
    }

    public Date getDataProva() {
        return dataProva;
    }

    public void setDataProva(Date dataProva) {
        this.dataProva = dataProva;
    }

    public List<Questao> getQuestaoList() {
        return questaoList;
    }

    public void setQuestaoList(List<Questao> questaoList) {
        this.questaoList = questaoList;
    }

    public List<Resultado> getResultadoList() {
        return resultadoList;
    }

    public void setResultadoList(List<Resultado> resultadoList) {
        this.resultadoList = resultadoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProva != null ? idProva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Prova)) {
            return false;
        }
        Prova other = (Prova) object;
        if ((this.idProva == null && other.idProva != null) || (this.idProva != null && !this.idProva.equals(other.idProva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
    	return getClass().getName();
    }
    
}
