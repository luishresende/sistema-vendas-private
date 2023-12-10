/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codemarket.model.vo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

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
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "estoProdutoCodigo")
    private TbEstoque tbEstoque;
    @JoinColumn(name = "pdt_categoria", referencedColumnName = "catp_id")
    @ManyToOne(optional = false)
    private TbCategoriaProduto pdtCategoria;
    @JoinColumn(name = "pdt_for_if", referencedColumnName = "for_id")
    @ManyToOne(optional = false)
    private TbFornecedor pdtForIf;
    @JoinColumn(name = "pdt_um_sigla", referencedColumnName = "um_sigla")
    @ManyToOne(optional = false)
    private TbUnidadeMedida pdtUmSigla;

    public TbProduto() {
    }

    public TbProduto(String pdtCodigo) {
        this.pdtCodigo = pdtCodigo;
    }

    public TbProduto(String pdtCodigo, String pdtNome, TbUnidadeMedida unidade, TbCategoriaProduto categoria, TbFornecedor pdtForIf) {
        this.pdtCodigo = pdtCodigo;
        this.pdtNome = pdtNome;
        this.pdtUmSigla = unidade;
        this.pdtCategoria = categoria;
        this.pdtForIf = pdtForIf;
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

    public TbEstoque getTbEstoque() {
        return tbEstoque;
    }

    public void setTbEstoque(TbEstoque tbEstoque) {
        this.tbEstoque = tbEstoque;
    }

    public TbCategoriaProduto getPdtCategoria() {
        return pdtCategoria;
    }

    public void setPdtCategoria(TbCategoriaProduto pdtCategoria) {
        this.pdtCategoria = pdtCategoria;
    }

    public TbFornecedor getPdtForIf() {
        return pdtForIf;
    }

    public void setPdtForIf(TbFornecedor pdtForIf) {
        this.pdtForIf = pdtForIf;
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
    public String toString() {
        return "teste.TbProduto[ pdtCodigo=" + pdtCodigo + " ]";
    }
    
}
