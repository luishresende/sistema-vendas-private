/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codemarket.model.vo;

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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author kauan
 */
@Entity
@Table(name = "tb_fornecedor")
@NamedQueries({
    @NamedQuery(name = "TbFornecedor.findAll", query = "SELECT t FROM TbFornecedor t")})
public class TbFornecedor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "for_id")
    private Integer forId;
    @JoinColumn(name = "for_cpfCnpj", referencedColumnName = "ent_cpfCnpj")
    @OneToOne(cascade = CascadeType.PERSIST, optional = false)
    private TbEntidade forcpfCnpj;
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "entreForId")
    private List<TbEntradaEstoque> tbEntradaEstoqueList;
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "tbFornecedor")
    private List<TbFornecedorHasProduto> tbFornecedorHasProdutoList;

    public TbFornecedor() {
    }

    public TbFornecedor(TbEntidade ent) {
        this.forcpfCnpj = ent;
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

    public List<TbEntradaEstoque> getTbEntradaEstoqueList() {
        return tbEntradaEstoqueList;
    }

    public void setTbEntradaEstoqueList(List<TbEntradaEstoque> tbEntradaEstoqueList) {
        this.tbEntradaEstoqueList = tbEntradaEstoqueList;
    }

    public List<TbFornecedorHasProduto> getTbFornecedorHasProdutoList() {
        return tbFornecedorHasProdutoList;
    }

    public void setTbFornecedorHasProdutoList(List<TbFornecedorHasProduto> tbFornecedorHasProdutoList) {
        this.tbFornecedorHasProdutoList = tbFornecedorHasProdutoList;
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
