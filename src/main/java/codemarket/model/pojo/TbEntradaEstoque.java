/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codemarket.model.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "tb_entrada_estoque")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbEntradaEstoque.findAll", query = "SELECT t FROM TbEntradaEstoque t")})
public class TbEntradaEstoque implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "entre_id")
    private Integer entreId;
    @JoinColumn(name = "entre_entrada_id", referencedColumnName = "entr_id")
    @ManyToOne(optional = false)
    private TbEntrada entreEntradaId;
    @JoinColumn(name = "entre_for_id", referencedColumnName = "for_id")
    @ManyToOne(optional = false)
    private TbFornecedor entreForId;
    @JoinColumn(name = "entre_pdt_codigo", referencedColumnName = "pdt_codigo")
    @ManyToOne(optional = false)
    private TbProduto entrePdtCodigo;

    public TbEntradaEstoque() {
    }

    public TbEntradaEstoque(Integer entreId) {
        this.entreId = entreId;
    }

    public Integer getEntreId() {
        return entreId;
    }

    public void setEntreId(Integer entreId) {
        this.entreId = entreId;
    }

    public TbEntrada getEntreEntradaId() {
        return entreEntradaId;
    }

    public void setEntreEntradaId(TbEntrada entreEntradaId) {
        this.entreEntradaId = entreEntradaId;
    }

    public TbFornecedor getEntreForId() {
        return entreForId;
    }

    public void setEntreForId(TbFornecedor entreForId) {
        this.entreForId = entreForId;
    }

    public TbProduto getEntrePdtCodigo() {
        return entrePdtCodigo;
    }

    public void setEntrePdtCodigo(TbProduto entrePdtCodigo) {
        this.entrePdtCodigo = entrePdtCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (entreId != null ? entreId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbEntradaEstoque)) {
            return false;
        }
        TbEntradaEstoque other = (TbEntradaEstoque) object;
        if ((this.entreId == null && other.entreId != null) || (this.entreId != null && !this.entreId.equals(other.entreId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "codemarket.model.pojo.TbEntradaEstoque[ entreId=" + entreId + " ]";
    }
    
}
