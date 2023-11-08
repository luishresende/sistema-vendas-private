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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author kauan
 */
@Entity
@Table(name = "tb_entrada")
@NamedQueries({
    @NamedQuery(name = "TbEntrada.findAll", query = "SELECT t FROM TbEntrada t")})
public class TbEntrada implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "entr_id")
    private Integer entrId;
    @Basic(optional = false)
    @Column(name = "entr_almo_id")
    private int entrAlmoId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entreEntradaId")
    private List<TbEntradaEstoque> tbEntradaEstoqueList;
    @JoinColumn(name = "entr_status", referencedColumnName = "tes_id")
    @ManyToOne(optional = false)
    private TbEntradaStatus entrStatus;

    public TbEntrada() {
    }

    public TbEntrada(Integer entrId) {
        this.entrId = entrId;
    }

    public TbEntrada(Integer entrId, int entrAlmoId) {
        this.entrId = entrId;
        this.entrAlmoId = entrAlmoId;
    }

    public Integer getEntrId() {
        return entrId;
    }

    public void setEntrId(Integer entrId) {
        this.entrId = entrId;
    }

    public int getEntrAlmoId() {
        return entrAlmoId;
    }

    public void setEntrAlmoId(int entrAlmoId) {
        this.entrAlmoId = entrAlmoId;
    }

    public List<TbEntradaEstoque> getTbEntradaEstoqueList() {
        return tbEntradaEstoqueList;
    }

    public void setTbEntradaEstoqueList(List<TbEntradaEstoque> tbEntradaEstoqueList) {
        this.tbEntradaEstoqueList = tbEntradaEstoqueList;
    }

    public TbEntradaStatus getEntrStatus() {
        return entrStatus;
    }

    public void setEntrStatus(TbEntradaStatus entrStatus) {
        this.entrStatus = entrStatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (entrId != null ? entrId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbEntrada)) {
            return false;
        }
        TbEntrada other = (TbEntrada) object;
        if ((this.entrId == null && other.entrId != null) || (this.entrId != null && !this.entrId.equals(other.entrId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "codemarket.model.vo.TbEntrada[ entrId=" + entrId + " ]";
    }
    
}
