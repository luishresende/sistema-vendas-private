/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codemarket.model.vo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author kauan
 */
@Entity
@Table(name = "tb_venda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbVenda.findAll", query = "SELECT t FROM TbVenda t"),
    @NamedQuery(name = "TbVenda.findByVenId", query = "SELECT t FROM TbVenda t WHERE t.venId = :venId"),
    @NamedQuery(name = "TbVenda.findByVenData", query = "SELECT t FROM TbVenda t WHERE t.venData = :venData")})
public class TbVenda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ven_id")
    private Integer venId;
    @Basic(optional = false)
    @Column(name = "ven_data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date venData;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "osVenda")
    private Collection<TbOrdemServico> tbOrdemServicoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbVenda")
    private Collection<TbPedido> tbPedidoCollection;
    @JoinColumn(name = "ven_cli_id", referencedColumnName = "cli_id")
    @ManyToOne
    private TbCliente venCliId;
    @JoinColumn(name = "ven_tp_id", referencedColumnName = "tp_id")
    @ManyToOne(optional = false)
    private TbTipoPagamento venTpId;

    public TbVenda() {
    }

    public TbVenda(Integer venId) {
        this.venId = venId;
    }

    public TbVenda(Integer venId, Date venData) {
        this.venId = venId;
        this.venData = venData;
    }

    public Integer getVenId() {
        return venId;
    }

    public void setVenId(Integer venId) {
        this.venId = venId;
    }

    public Date getVenData() {
        return venData;
    }

    public void setVenData(Date venData) {
        this.venData = venData;
    }

    @XmlTransient
    public Collection<TbOrdemServico> getTbOrdemServicoCollection() {
        return tbOrdemServicoCollection;
    }

    public void setTbOrdemServicoCollection(Collection<TbOrdemServico> tbOrdemServicoCollection) {
        this.tbOrdemServicoCollection = tbOrdemServicoCollection;
    }

    @XmlTransient
    public Collection<TbPedido> getTbPedidoCollection() {
        return tbPedidoCollection;
    }

    public void setTbPedidoCollection(Collection<TbPedido> tbPedidoCollection) {
        this.tbPedidoCollection = tbPedidoCollection;
    }

    public TbCliente getVenCliId() {
        return venCliId;
    }

    public void setVenCliId(TbCliente venCliId) {
        this.venCliId = venCliId;
    }

    public TbTipoPagamento getVenTpId() {
        return venTpId;
    }

    public void setVenTpId(TbTipoPagamento venTpId) {
        this.venTpId = venTpId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (venId != null ? venId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbVenda)) {
            return false;
        }
        TbVenda other = (TbVenda) object;
        if ((this.venId == null && other.venId != null) || (this.venId != null && !this.venId.equals(other.venId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "codemarket.model.vo.TbVenda[ venId=" + venId + " ]";
    }
    
}
