/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codemarket.model.vo;

import java.io.Serializable;
import java.util.Collection;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author kauan
 */
@Entity
@Table(name = "tb_almoxarifado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbAlmoxarifado.findAll", query = "SELECT t FROM TbAlmoxarifado t"),
    @NamedQuery(name = "TbAlmoxarifado.findByAlmoId", query = "SELECT t FROM TbAlmoxarifado t WHERE t.almoId = :almoId"),
    @NamedQuery(name = "TbAlmoxarifado.findByAlmoNome", query = "SELECT t FROM TbAlmoxarifado t WHERE t.almoNome = :almoNome"),
    @NamedQuery(name = "TbAlmoxarifado.findByAlmoDescricao", query = "SELECT t FROM TbAlmoxarifado t WHERE t.almoDescricao = :almoDescricao")})
public class TbAlmoxarifado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "almo_id")
    private Integer almoId;
    @Basic(optional = false)
    @Column(name = "almo_nome")
    private String almoNome;
    @Basic(optional = false)
    @Column(name = "almo_descricao")
    private String almoDescricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbAlmoxarifado")
    private Collection<TbFuncionarioHasAlmoxarifado> tbFuncionarioHasAlmoxarifadoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbAlmoxarifado")
    private Collection<TbEstoque> tbEstoqueCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "traAlmoxarifadoDestino")
    private Collection<TbTransferenciasAlmoxarifado> tbTransferenciasAlmoxarifadoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "traAlmoxarifadoOrigem")
    private Collection<TbTransferenciasAlmoxarifado> tbTransferenciasAlmoxarifadoCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entrAlmoId")
    private Collection<TbEntrada> tbEntradaCollection;

    public TbAlmoxarifado() {
    }

    public TbAlmoxarifado(String almoNome, String almoDescricao) {
        this.almoNome = almoNome;
        this.almoDescricao = almoDescricao;
    }

    public Integer getAlmoId() {
        return almoId;
    }

    public void setAlmoId(Integer almoId) {
        this.almoId = almoId;
    }

    public String getAlmoNome() {
        return almoNome;
    }

    public void setAlmoNome(String almoNome) {
        this.almoNome = almoNome;
    }

    public String getAlmoDescricao() {
        return almoDescricao;
    }

    public void setAlmoDescricao(String almoDescricao) {
        this.almoDescricao = almoDescricao;
    }

    @XmlTransient
    public Collection<TbFuncionarioHasAlmoxarifado> getTbFuncionarioHasAlmoxarifadoCollection() {
        return tbFuncionarioHasAlmoxarifadoCollection;
    }

    public void setTbFuncionarioHasAlmoxarifadoCollection(Collection<TbFuncionarioHasAlmoxarifado> tbFuncionarioHasAlmoxarifadoCollection) {
        this.tbFuncionarioHasAlmoxarifadoCollection = tbFuncionarioHasAlmoxarifadoCollection;
    }

    @XmlTransient
    public Collection<TbEstoque> getTbEstoqueCollection() {
        return tbEstoqueCollection;
    }

    public void setTbEstoqueCollection(Collection<TbEstoque> tbEstoqueCollection) {
        this.tbEstoqueCollection = tbEstoqueCollection;
    }

    @XmlTransient
    public Collection<TbTransferenciasAlmoxarifado> getTbTransferenciasAlmoxarifadoCollection() {
        return tbTransferenciasAlmoxarifadoCollection;
    }

    public void setTbTransferenciasAlmoxarifadoCollection(Collection<TbTransferenciasAlmoxarifado> tbTransferenciasAlmoxarifadoCollection) {
        this.tbTransferenciasAlmoxarifadoCollection = tbTransferenciasAlmoxarifadoCollection;
    }

    @XmlTransient
    public Collection<TbTransferenciasAlmoxarifado> getTbTransferenciasAlmoxarifadoCollection1() {
        return tbTransferenciasAlmoxarifadoCollection1;
    }

    public void setTbTransferenciasAlmoxarifadoCollection1(Collection<TbTransferenciasAlmoxarifado> tbTransferenciasAlmoxarifadoCollection1) {
        this.tbTransferenciasAlmoxarifadoCollection1 = tbTransferenciasAlmoxarifadoCollection1;
    }

    @XmlTransient
    public Collection<TbEntrada> getTbEntradaCollection() {
        return tbEntradaCollection;
    }

    public void setTbEntradaCollection(Collection<TbEntrada> tbEntradaCollection) {
        this.tbEntradaCollection = tbEntradaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (almoId != null ? almoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbAlmoxarifado)) {
            return false;
        }
        TbAlmoxarifado other = (TbAlmoxarifado) object;
        if ((this.almoId == null && other.almoId != null) || (this.almoId != null && !this.almoId.equals(other.almoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "codemarket.model.vo.TbAlmoxarifado[ almoId=" + almoId + " ]";
    }
    
}
