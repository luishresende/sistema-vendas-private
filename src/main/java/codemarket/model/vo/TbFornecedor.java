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
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author kauan
 */
@Entity
@Table(name = "tb_fornecedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbFornecedor.findAll", query = "SELECT t FROM TbFornecedor t"),
    @NamedQuery(name = "TbFornecedor.findByForId", query = "SELECT t FROM TbFornecedor t WHERE t.forId = :forId")})
public class TbFornecedor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "for_id")
    private Integer forId;
    @JoinColumn(name = "for_cpfCnpj", referencedColumnName = "ent_cpfCnpj")
    @OneToOne(optional = false)
    private TbEntidade forcpfCnpj;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entreForId")
    private Collection<TbEntradaEstoque> tbEntradaEstoqueCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbFornecedor")
    private Collection<TbFornecedorHasProduto> tbFornecedorHasProdutoCollection;

    public TbFornecedor() {
    }

    public TbFornecedor(TbEntidade forcpfCnpj) {
        this.forcpfCnpj = forcpfCnpj;
    }

    public Integer getForId() {
        return forId;
    }

    public void setForId(Integer forId) {
        this.forId = forId;
    }

    public TbEntidade getForcpfCnpj() {
        return forcpfCnpj;
    }

    public void setForcpfCnpj(TbEntidade forcpfCnpj) {
        this.forcpfCnpj = forcpfCnpj;
    }

    @XmlTransient
    public Collection<TbEntradaEstoque> getTbEntradaEstoqueCollection() {
        return tbEntradaEstoqueCollection;
    }

    public void setTbEntradaEstoqueCollection(Collection<TbEntradaEstoque> tbEntradaEstoqueCollection) {
        this.tbEntradaEstoqueCollection = tbEntradaEstoqueCollection;
    }

    @XmlTransient
    public Collection<TbFornecedorHasProduto> getTbFornecedorHasProdutoCollection() {
        return tbFornecedorHasProdutoCollection;
    }

    public void setTbFornecedorHasProdutoCollection(Collection<TbFornecedorHasProduto> tbFornecedorHasProdutoCollection) {
        this.tbFornecedorHasProdutoCollection = tbFornecedorHasProdutoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (forId != null ? forId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbFornecedor)) {
            return false;
        }
        TbFornecedor other = (TbFornecedor) object;
        if ((this.forId == null && other.forId != null) || (this.forId != null && !this.forId.equals(other.forId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "codemarket.model.vo.TbFornecedor[ forId=" + forId + " ]";
    }
    
}
