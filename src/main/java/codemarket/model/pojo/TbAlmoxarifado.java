/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codemarket.model.pojo;

import java.io.Serializable;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Luis Resende
 */
@Entity
@Table(name = "tb_almoxarifado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbAlmoxarifado.findAll", query = "SELECT t FROM TbAlmoxarifado t"),
    @NamedQuery(name = "TbAlmoxarifado.findByAlmoId", query = "SELECT t FROM TbAlmoxarifado t WHERE t.almoId = :almoId")})
public class TbAlmoxarifado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "almo_id")
    private Integer almoId;
    @JoinTable(name = "tb_funcionario_has_almoxarifado", joinColumns = {
        @JoinColumn(name = "almo_id", referencedColumnName = "almo_id")}, inverseJoinColumns = {
        @JoinColumn(name = "func_id", referencedColumnName = "func_id")})
    @ManyToMany
    private List<TbFuncionario> tbFuncionarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbAlmoxarifado")
    private List<TbEstoque> tbEstoqueList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "funcStatus")
    private List<TbFuncionario> tbFuncionarioList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "traAlmoxarifadoOrigem")
    private List<TbTransferenciasAlmoxarifado> tbTransferenciasAlmoxarifadoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "traAlmoxarifadoDestino")
    private List<TbTransferenciasAlmoxarifado> tbTransferenciasAlmoxarifadoList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entrAlmoId")
    private List<TbEntrada> tbEntradaList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "tbAlmoxarifado")
    private TbAlmoxarifadoHasEstoque tbAlmoxarifadoHasEstoque;

    public TbAlmoxarifado() {
    }

    public Integer getAlmoId() {
        return almoId;
    }

    public void setAlmoId(Integer almoId) {
        this.almoId = almoId;
    }

    @XmlTransient
    public List<TbFuncionario> getTbFuncionarioList() {
        return tbFuncionarioList;
    }

    public void setTbFuncionarioList(List<TbFuncionario> tbFuncionarioList) {
        this.tbFuncionarioList = tbFuncionarioList;
    }

    @XmlTransient
    public List<TbEstoque> getTbEstoqueList() {
        return tbEstoqueList;
    }

    public void setTbEstoqueList(List<TbEstoque> tbEstoqueList) {
        this.tbEstoqueList = tbEstoqueList;
    }

    @XmlTransient
    public List<TbFuncionario> getTbFuncionarioList1() {
        return tbFuncionarioList1;
    }

    public void setTbFuncionarioList1(List<TbFuncionario> tbFuncionarioList1) {
        this.tbFuncionarioList1 = tbFuncionarioList1;
    }

    @XmlTransient
    public List<TbTransferenciasAlmoxarifado> getTbTransferenciasAlmoxarifadoList() {
        return tbTransferenciasAlmoxarifadoList;
    }

    public void setTbTransferenciasAlmoxarifadoList(List<TbTransferenciasAlmoxarifado> tbTransferenciasAlmoxarifadoList) {
        this.tbTransferenciasAlmoxarifadoList = tbTransferenciasAlmoxarifadoList;
    }

    @XmlTransient
    public List<TbTransferenciasAlmoxarifado> getTbTransferenciasAlmoxarifadoList1() {
        return tbTransferenciasAlmoxarifadoList1;
    }

    public void setTbTransferenciasAlmoxarifadoList1(List<TbTransferenciasAlmoxarifado> tbTransferenciasAlmoxarifadoList1) {
        this.tbTransferenciasAlmoxarifadoList1 = tbTransferenciasAlmoxarifadoList1;
    }

    @XmlTransient
    public List<TbEntrada> getTbEntradaList() {
        return tbEntradaList;
    }

    public void setTbEntradaList(List<TbEntrada> tbEntradaList) {
        this.tbEntradaList = tbEntradaList;
    }

    public TbAlmoxarifadoHasEstoque getTbAlmoxarifadoHasEstoque() {
        return tbAlmoxarifadoHasEstoque;
    }

    public void setTbAlmoxarifadoHasEstoque(TbAlmoxarifadoHasEstoque tbAlmoxarifadoHasEstoque) {
        this.tbAlmoxarifadoHasEstoque = tbAlmoxarifadoHasEstoque;
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
        return "codemarket.model.pojo.TbAlmoxarifado[ almoId=" + almoId + " ]";
    }
    
}