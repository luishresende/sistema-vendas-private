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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author kauan
 */
@Entity
@Table(name = "tb_bairro")
@NamedQueries({
    @NamedQuery(name = "TbBairro.findAll", query = "SELECT t FROM TbBairro t")})
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
    private List<TbEndPostal> tbEndPostalList;

    public TbBairro() {
    }

    public TbBairro(Integer baiId) {
        this.baiId = baiId;
    }

    public TbBairro(Integer baiId, String baiDescricao) {
        this.baiId = baiId;
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

    public List<TbEndPostal> getTbEndPostalList() {
        return tbEndPostalList;
    }

    public void setTbEndPostalList(List<TbEndPostal> tbEndPostalList) {
        this.tbEndPostalList = tbEndPostalList;
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
        return "codemarket.model.vo.TbBairro[ baiId=" + baiId + " ]";
    }
    
}
