package com.uniacademia.enade.model;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TipoQuestao")
@NamedQueries({
    @NamedQuery(name = "TipoQuestao.buscarTodas", query = "SELECT t FROM TipoQuestao t"),
    @NamedQuery(name = "TipoQuestao.findByIdTipoQuestao", query = "SELECT t FROM TipoQuestao t WHERE t.idTipoQuestao = :idTipoQuestao"),
    @NamedQuery(name = "TipoQuestao.findByNomeTipoQuestao", query = "SELECT t FROM TipoQuestao t WHERE t.nomeTipoQuestao = :nomeTipoQuestao")})
public class TipoQuestao implements EntidadeBase {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTipoQuestao")
    private Integer idTipoQuestao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nomeTipoQuestao")
    private String nomeTipoQuestao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoQuestaoidTipoQuestao")
    private List<Questao> questaoList;

    public TipoQuestao() {
    }

    public TipoQuestao(Integer idTipoQuestao) {
        this.idTipoQuestao = idTipoQuestao;
    }

    public TipoQuestao(Integer idTipoQuestao, String nomeTipoQuestao) {
        this.idTipoQuestao = idTipoQuestao;
        this.nomeTipoQuestao = nomeTipoQuestao;
    }

    @Override
    public Integer getId() {
        return idTipoQuestao;
    }

    public void setIdTipoQuestao(Integer idTipoQuestao) {
        this.idTipoQuestao = idTipoQuestao;
    }

    public String getNomeTipoQuestao() {
        return nomeTipoQuestao;
    }

    public void setNomeTipoQuestao(String nomeTipoQuestao) {
        this.nomeTipoQuestao = nomeTipoQuestao;
    }

    public List<Questao> getQuestaoList() {
        return questaoList;
    }

    public void setQuestaoList(List<Questao> questaoList) {
        this.questaoList = questaoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoQuestao != null ? idTipoQuestao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
    	TipoQuestao other = (TipoQuestao) object;
    	return object == null || ( !object.getClass().equals(this.getClass()) && !other.getId().equals(this.getId()));
    }

    @Override
    public String toString() {
    	return getClass().getName();
    }
}
