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
@Table(name = "tb_logradouro")
@NamedQueries({
    @NamedQuery(name = "TbLogradouro.findAll", query = "SELECT t FROM TbLogradouro t")})
public class TbLogradouro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "log_id")
    private Integer logId;
    @Basic(optional = false)
    @Column(name = "log_descricao")
    private String logDescricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "endPlogid")
    private List<TbEndPostal> tbEndPostalList;

    public TbLogradouro() {
    }

    public TbLogradouro(String logDescricao) {
        this.logDescricao = logDescricao;
    }

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public String getLogDescricao() {
        return logDescricao;
    }

    public void setLogDescricao(String logDescricao) {
        this.logDescricao = logDescricao;
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
        hash += (logId != null ? logId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbLogradouro)) {
            return false;
        }
        TbLogradouro other = (TbLogradouro) object;
        if ((this.logId == null && other.logId != null) || (this.logId != null && !this.logId.equals(other.logId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "codemarket.model.vo.TbLogradouro[ logId=" + logId + " ]";
    }
    
}
