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
@Table(name = "tb_cidade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbCidade.findAll", query = "SELECT t FROM TbCidade t"),
    @NamedQuery(name = "TbCidade.findByCidId", query = "SELECT t FROM TbCidade t WHERE t.cidId = :cidId"),
    @NamedQuery(name = "TbCidade.findByCidDescricao", query = "SELECT t FROM TbCidade t WHERE t.cidDescricao = :cidDescricao")})
public class TbCidade implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cid_id")
    private Integer cidId;
    @Basic(optional = false)
    @Column(name = "cid_descricao")
    private String cidDescricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbCidade")
    private Collection<TbCidEstPai> tbCidEstPaiCollection;

    public TbCidade() {
    }

    public TbCidade(String cidDescricao) {
        this.cidDescricao = cidDescricao;
    }

    public Integer getCidId() {
        return cidId;
    }

    public void setCidId(Integer cidId) {
        this.cidId = cidId;
    }

    public String getCidDescricao() {
        return cidDescricao;
    }

    public void setCidDescricao(String cidDescricao) {
        this.cidDescricao = cidDescricao;
    }

    @XmlTransient
    public Collection<TbCidEstPai> getTbCidEstPaiCollection() {
        return tbCidEstPaiCollection;
    }

    public void setTbCidEstPaiCollection(Collection<TbCidEstPai> tbCidEstPaiCollection) {
        this.tbCidEstPaiCollection = tbCidEstPaiCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cidId != null ? cidId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbCidade)) {
            return false;
        }
        TbCidade other = (TbCidade) object;
        if ((this.cidId == null && other.cidId != null) || (this.cidId != null && !this.cidId.equals(other.cidId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "codemarket.model.vo.TbCidade[ cidId=" + cidId + " ]";
    }
    
}
