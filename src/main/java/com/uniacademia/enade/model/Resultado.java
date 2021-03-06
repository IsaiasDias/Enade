package com.uniacademia.enade.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Resultado")
@NamedQueries({
    @NamedQuery(name = "Resultado.buscarTodas", query = "SELECT r FROM Resultado r"),
    @NamedQuery(name = "Resultado.findByIdResultado", query = "SELECT r FROM Resultado r WHERE r.idResultado = :idResultado"),
    @NamedQuery(name = "Resultado.findByValorObtido", query = "SELECT r FROM Resultado r WHERE r.valorObtido = :valorObtido"),
    @NamedQuery(name = "Resultado.findByIdUsuario", query = "SELECT r FROM Resultado r WHERE r.usuarioidUsuario.idUsuario = :idUsuario ORDER BY r.provaidProva.dataProva DESC")})
public class Resultado implements EntidadeBase {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idResultado")
    private Integer idResultado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valorObtido")
    private double valorObtido;
    @JoinColumn(name = "Prova_idProva", referencedColumnName = "idProva")
    @ManyToOne(optional = false)
    private Prova provaidProva;
    @JoinColumn(name = "Usuario_idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuario usuarioidUsuario;

    public Resultado() {
    }

    public Resultado(Integer idResultado) {
        this.idResultado = idResultado;
    }

    public Resultado(Integer idResultado, double valorObtido) {
        this.idResultado = idResultado;
        this.valorObtido = valorObtido;
    }
    
    @Override
    public Integer getId() {
        return idResultado;
    }

    public void setIdResultado(Integer idResultado) {
        this.idResultado = idResultado;
    }

    public double getValorObtido() {
        return valorObtido;
    }

    public void setValorObtido(double valorObtido) {
        this.valorObtido = valorObtido;
    }

    public Prova getProvaidProva() {
        return provaidProva;
    }

    public void setProvaidProva(Prova provaidProva) {
        this.provaidProva = provaidProva;
    }

    public Usuario getUsuarioidUsuario() {
        return usuarioidUsuario;
    }

    public void setUsuarioidUsuario(Usuario usuarioidUsuario) {
        this.usuarioidUsuario = usuarioidUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idResultado != null ? idResultado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
    	Resultado other = (Resultado) object;
    	return object == null || ( !object.getClass().equals(this.getClass()) && !other.getId().equals(this.getId()));
    }
    
    @Override
    public String toString() {
    	return getClass().getName();
    }
}
