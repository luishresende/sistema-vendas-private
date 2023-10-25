/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codemarket.model.vo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kauan
 */
@Entity
@Table(name = "tb_entrada_estoque")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbEntradaEstoque.findAll", query = "SELECT t FROM TbEntradaEstoque t"),
    @NamedQuery(name = "TbEntradaEstoque.findByEntreId", query = "SELECT t FROM TbEntradaEstoque t WHERE t.entreId = :entreId")})
public class TbEntradaEstoque implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "entre_id")
    private Integer entreId;
    @JoinColumn(name = "entre_entrada_id", referencedColumnName = "entr_id")
    @ManyToOne(optional = false)
    private TbEntrada entreEntradaId;
    @JoinColumns({
        @JoinColumn(name = "entre_pdt_codigo", referencedColumnName = "esto_produto_codigo"),
        @JoinColumn(name = "entre_almo_id", referencedColumnName = "esto_almoxarifado")})
    @ManyToOne(optional = false)
    private TbEstoque tbEstoque;
    @JoinColumn(name = "entre_for_id", referencedColumnName = "for_id")
    @ManyToOne(optional = false)
    private TbFornecedor entreForId;

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

    public TbEstoque getTbEstoque() {
        return tbEstoque;
    }

    public void setTbEstoque(TbEstoque tbEstoque) {
        this.tbEstoque = tbEstoque;
    }

    public TbFornecedor getEntreForId() {
        return entreForId;
    }

    public void setEntreForId(TbFornecedor entreForId) {
        this.entreForId = entreForId;
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
        return "codemarket.model.vo.TbEntradaEstoque[ entreId=" + entreId + " ]";
    }
    
}
