/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codemarket.model.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Luis Resende
 */
@Entity
@Table(name = "tb_fornecedor_has_produto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbFornecedorHasProduto.findAll", query = "SELECT t FROM TbFornecedorHasProduto t"),
    @NamedQuery(name = "TbFornecedorHasProduto.findByFhpId", query = "SELECT t FROM TbFornecedorHasProduto t WHERE t.tbFornecedorHasProdutoPK.fhpId = :fhpId"),
    @NamedQuery(name = "TbFornecedorHasProduto.findByFhpPdt", query = "SELECT t FROM TbFornecedorHasProduto t WHERE t.tbFornecedorHasProdutoPK.fhpPdt = :fhpPdt"),
    @NamedQuery(name = "TbFornecedorHasProduto.findByFhpValorCompra", query = "SELECT t FROM TbFornecedorHasProduto t WHERE t.fhpValorCompra = :fhpValorCompra")})
public class TbFornecedorHasProduto implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TbFornecedorHasProdutoPK tbFornecedorHasProdutoPK;
    @Basic(optional = false)
    @Column(name = "fhp_valor_compra")
    private float fhpValorCompra;
    @JoinColumn(name = "fhp_id", referencedColumnName = "for_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TbFornecedor tbFornecedor;
    @JoinColumn(name = "fhp_pdt", referencedColumnName = "pdt_codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TbProduto tbProduto;

    public TbFornecedorHasProduto() {
    }

    public TbFornecedorHasProduto(TbFornecedorHasProdutoPK tbFornecedorHasProdutoPK) {
        this.tbFornecedorHasProdutoPK = tbFornecedorHasProdutoPK;
    }

    public TbFornecedorHasProduto(TbFornecedorHasProdutoPK tbFornecedorHasProdutoPK, float fhpValorCompra) {
        this.tbFornecedorHasProdutoPK = tbFornecedorHasProdutoPK;
        this.fhpValorCompra = fhpValorCompra;
    }

    public TbFornecedorHasProduto(int fhpId, String fhpPdt) {
        this.tbFornecedorHasProdutoPK = new TbFornecedorHasProdutoPK(fhpId, fhpPdt);
    }

    public TbFornecedorHasProdutoPK getTbFornecedorHasProdutoPK() {
        return tbFornecedorHasProdutoPK;
    }

    public void setTbFornecedorHasProdutoPK(TbFornecedorHasProdutoPK tbFornecedorHasProdutoPK) {
        this.tbFornecedorHasProdutoPK = tbFornecedorHasProdutoPK;
    }

    public float getFhpValorCompra() {
        return fhpValorCompra;
    }

    public void setFhpValorCompra(float fhpValorCompra) {
        this.fhpValorCompra = fhpValorCompra;
    }

    public TbFornecedor getTbFornecedor() {
        return tbFornecedor;
    }

    public void setTbFornecedor(TbFornecedor tbFornecedor) {
        this.tbFornecedor = tbFornecedor;
    }

    public TbProduto getTbProduto() {
        return tbProduto;
    }

    public void setTbProduto(TbProduto tbProduto) {
        this.tbProduto = tbProduto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tbFornecedorHasProdutoPK != null ? tbFornecedorHasProdutoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbFornecedorHasProduto)) {
            return false;
        }
        TbFornecedorHasProduto other = (TbFornecedorHasProduto) object;
        if ((this.tbFornecedorHasProdutoPK == null && other.tbFornecedorHasProdutoPK != null) || (this.tbFornecedorHasProdutoPK != null && !this.tbFornecedorHasProdutoPK.equals(other.tbFornecedorHasProdutoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "codemarket.model.pojo.TbFornecedorHasProduto[ tbFornecedorHasProdutoPK=" + tbFornecedorHasProdutoPK + " ]";
    }
    
}
