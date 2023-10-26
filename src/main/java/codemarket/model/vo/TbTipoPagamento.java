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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "tb_tipo_pagamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbTipoPagamento.findAll", query = "SELECT t FROM TbTipoPagamento t"),
    @NamedQuery(name = "TbTipoPagamento.findByTpId", query = "SELECT t FROM TbTipoPagamento t WHERE t.tpId = :tpId"),
    @NamedQuery(name = "TbTipoPagamento.findByTpDescricao", query = "SELECT t FROM TbTipoPagamento t WHERE t.tpDescricao = :tpDescricao")})
public class TbTipoPagamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tp_id")
    private Integer tpId;
    @Basic(optional = false)
    @Column(name = "tp_descricao")
    private String tpDescricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "venTpId")
    private Collection<TbVenda> tbVendaCollection;

    public TbTipoPagamento() {
    }

    public TbTipoPagamento(String tpDescricao) {
        this.tpDescricao = tpDescricao;
    }

    public Integer getTpId() {
        return tpId;
    }

    public void setTpId(Integer tpId) {
        this.tpId = tpId;
    }

    public String getTpDescricao() {
        return tpDescricao;
    }

    public void setTpDescricao(String tpDescricao) {
        this.tpDescricao = tpDescricao;
    }

    @XmlTransient
    public Collection<TbVenda> getTbVendaCollection() {
        return tbVendaCollection;
    }

    public void setTbVendaCollection(Collection<TbVenda> tbVendaCollection) {
        this.tbVendaCollection = tbVendaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tpId != null ? tpId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbTipoPagamento)) {
            return false;
        }
        TbTipoPagamento other = (TbTipoPagamento) object;
        if ((this.tpId == null && other.tpId != null) || (this.tpId != null && !this.tpId.equals(other.tpId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "codemarket.model.vo.TbTipoPagamento[ tpId=" + tpId + " ]";
    }
    
}
