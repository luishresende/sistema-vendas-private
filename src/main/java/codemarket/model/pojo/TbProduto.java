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
 * @author Luis Resende
 */
@Entity
@Table(name = "tb_produto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbProduto.findAll", query = "SELECT t FROM TbProduto t")})
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
    private List<TbEstoque> tbEstoqueList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entrePdtCodigo")
    private List<TbEntradaEstoque> tbEntradaEstoqueList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbProduto")
    private List<TbFornecedorHasProduto> tbFornecedorHasProdutoList;
    @JoinColumn(name = "pdt_categoria", referencedColumnName = "catp_id")
    @ManyToOne(optional = false)
    private TbCategoriaProduto pdtCategoria;
    @JoinColumn(name = "pdt_um_sigla", referencedColumnName = "um_sigla")
    @ManyToOne(optional = false)
    private TbUnidadeMedida pdtUmSigla;

    public TbProduto() {
    }

    public TbProduto(String pdtCodigo) {
        this.pdtCodigo = pdtCodigo;
    }

    public TbProduto(String pdtCodigo, String pdtNome) {
        this.pdtCodigo = pdtCodigo;
        this.pdtNome = pdtNome;
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
    public List<TbEstoque> getTbEstoqueList() {
        return tbEstoqueList;
    }

    public void setTbEstoqueList(List<TbEstoque> tbEstoqueList) {
        this.tbEstoqueList = tbEstoqueList;
    }

    @XmlTransient
    public List<TbEntradaEstoque> getTbEntradaEstoqueList() {
        return tbEntradaEstoqueList;
    }

    public void setTbEntradaEstoqueList(List<TbEntradaEstoque> tbEntradaEstoqueList) {
        this.tbEntradaEstoqueList = tbEntradaEstoqueList;
    }

    @XmlTransient
    public List<TbFornecedorHasProduto> getTbFornecedorHasProdutoList() {
        return tbFornecedorHasProdutoList;
    }

    public void setTbFornecedorHasProdutoList(List<TbFornecedorHasProduto> tbFornecedorHasProdutoList) {
        this.tbFornecedorHasProdutoList = tbFornecedorHasProdutoList;
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
        return "codemarket.model.pojo.TbProduto[ pdtCodigo=" + pdtCodigo + " ]";
    }
    
}
