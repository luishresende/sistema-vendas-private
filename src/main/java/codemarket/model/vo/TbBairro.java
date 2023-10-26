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
@Table(name = "tb_bairro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbBairro.findAll", query = "SELECT t FROM TbBairro t"),
    @NamedQuery(name = "TbBairro.findByBaiId", query = "SELECT t FROM TbBairro t WHERE t.baiId = :baiId"),
    @NamedQuery(name = "TbBairro.findByBaiDescricao", query = "SELECT t FROM TbBairro t WHERE t.baiDescricao = :baiDescricao")})
public class TbBairro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bai_id")
    private Integer baiId;
    @Basic(optional = false)
    @Column(name = "bai_descricao")
    private String baiDescricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "endPbaiid")
    private Collection<TbEndPostal> tbEndPostalCollection;

    public TbBairro() {
    }

    public TbBairro(String baiDescricao) {
        this.baiDescricao = baiDescricao;
    }

    public Integer getBaiId() {
        return baiId;
    }

    public void setBaiId(Integer baiId) {
        this.baiId = baiId;
    }

    public String getBaiDescricao() {
        return baiDescricao;
    }

    public void setBaiDescricao(String baiDescricao) {
        this.baiDescricao = baiDescricao;
    }

    @XmlTransient
    public Collection<TbEndPostal> getTbEndPostalCollection() {
        return tbEndPostalCollection;
    }

    public void setTbEndPostalCollection(Collection<TbEndPostal> tbEndPostalCollection) {
        this.tbEndPostalCollection = tbEndPostalCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (baiId != null ? baiId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbBairro)) {
            return false;
        }
        TbBairro other = (TbBairro) object;
        if ((this.baiId == null && other.baiId != null) || (this.baiId != null && !this.baiId.equals(other.baiId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Bairros: \n" + baiDescricao + " ";
    }
    
}
