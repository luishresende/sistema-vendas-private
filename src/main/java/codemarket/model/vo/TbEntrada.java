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
@Table(name = "tb_entrada")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbEntrada.findAll", query = "SELECT t FROM TbEntrada t")})
public class TbEntrada implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "entr_id")
    private Integer entrId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entreEntradaId")
    private List<TbEntradaEstoque> tbEntradaEstoqueList;
    @JoinColumn(name = "entr_almo_id", referencedColumnName = "almo_id")
    @ManyToOne(optional = false)
    private TbAlmoxarifado entrAlmoId;
    @JoinColumn(name = "entr_status", referencedColumnName = "trs_id")
    @ManyToOne(optional = false)
    private TbTransferenciaStatus entrStatus;

    public TbEntrada() {
    }

    public TbEntrada(Integer entrId) {
        this.entrId = entrId;
    }

    public Integer getEntrId() {
        return entrId;
    }

    public void setEntrId(Integer entrId) {
        this.entrId = entrId;
    }

    @XmlTransient
    public List<TbEntradaEstoque> getTbEntradaEstoqueList() {
        return tbEntradaEstoqueList;
    }

    public void setTbEntradaEstoqueList(List<TbEntradaEstoque> tbEntradaEstoqueList) {
        this.tbEntradaEstoqueList = tbEntradaEstoqueList;
    }

    public TbAlmoxarifado getEntrAlmoId() {
        return entrAlmoId;
    }

    public void setEntrAlmoId(TbAlmoxarifado entrAlmoId) {
        this.entrAlmoId = entrAlmoId;
    }

    public TbTransferenciaStatus getEntrStatus() {
        return entrStatus;
    }

    public void setEntrStatus(TbTransferenciaStatus entrStatus) {
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
        return "codemarket.model.pojo.TbEntrada[ entrId=" + entrId + " ]";
    }
    
}
