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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tb_produto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbProduto.findAll", query = "SELECT t FROM TbProduto t"),
    @NamedQuery(name = "TbProduto.findByPdtCodigo", query = "SELECT t FROM TbProduto t WHERE t.pdtCodigo = :pdtCodigo"),
    @NamedQuery(name = "TbProduto.findByPdtNome", query = "SELECT t FROM TbProduto t WHERE t.pdtNome = :pdtNome")})
public class TbProduto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pdt_codigo")
    private String pdtCodigo;
    @Basic(optional = false)
    @Column(name = "pdt_nome")
    private String pdtNome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbProduto")
    private Collection<TbEstoque> tbEstoqueCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbProduto")
    private Collection<TbFornecedorHasProduto> tbFornecedorHasProdutoCollection;
    @JoinColumn(name = "pdt_categoria", referencedColumnName = "catp_id")
    @ManyToOne(optional = false)
    private TbCategoriaProduto pdtCategoria;
    @JoinColumn(name = "pdt_um_sigla", referencedColumnName = "um_sigla")
    @ManyToOne(optional = false)
    private TbUnidadeMedida pdtUmSigla;

    public TbProduto() {
    }

    public TbProduto(String pdtNome, TbCategoriaProduto pdtCategoria, TbUnidadeMedida pdtUmSigla) {
        this.pdtNome = pdtNome;
        this.pdtCategoria = pdtCategoria;
        this.pdtUmSigla = pdtUmSigla;
    }

    public String getPdtCodigo() {
        return pdtCodigo;
    }

    public void setPdtCodigo(String pdtCodigo) {
        this.pdtCodigo = pdtCodigo;
    }

    public String getPdtNome() {
        return pdtNome;
    }

    public void setPdtNome(String pdtNome) {
        this.pdtNome = pdtNome;
    }

    @XmlTransient
    public Collection<TbEstoque> getTbEstoqueCollection() {
        return tbEstoqueCollection;
    }

    public void setTbEstoqueCollection(Collection<TbEstoque> tbEstoqueCollection) {
        this.tbEstoqueCollection = tbEstoqueCollection;
    }

    @XmlTransient
    public Collection<TbFornecedorHasProduto> getTbFornecedorHasProdutoCollection() {
        return tbFornecedorHasProdutoCollection;
    }

    public void setTbFornecedorHasProdutoCollection(Collection<TbFornecedorHasProduto> tbFornecedorHasProdutoCollection) {
        this.tbFornecedorHasProdutoCollection = tbFornecedorHasProdutoCollection;
    }

    public TbCategoriaProduto getPdtCategoria() {
        return pdtCategoria;
    }

    public void setPdtCategoria(TbCategoriaProduto pdtCategoria) {
        this.pdtCategoria = pdtCategoria;
    }

    public TbUnidadeMedida getPdtUmSigla() {
        return pdtUmSigla;
    }

    public void setPdtUmSigla(TbUnidadeMedida pdtUmSigla) {
        this.pdtUmSigla = pdtUmSigla;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pdtCodigo != null ? pdtCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbProduto)) {
            return false;
        }
        TbProduto other = (TbProduto) object;
        if ((this.pdtCodigo == null && other.pdtCodigo != null) || (this.pdtCodigo != null && !this.pdtCodigo.equals(other.pdtCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "codemarket.model.vo.TbProduto[ pdtCodigo=" + pdtCodigo + " ]";
    }
    
}
