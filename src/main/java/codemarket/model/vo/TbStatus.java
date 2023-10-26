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
@Table(name = "tb_status")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbStatus.findAll", query = "SELECT t FROM TbStatus t"),
    @NamedQuery(name = "TbStatus.findByStaId", query = "SELECT t FROM TbStatus t WHERE t.staId = :staId"),
    @NamedQuery(name = "TbStatus.findByStaDescricao", query = "SELECT t FROM TbStatus t WHERE t.staDescricao = :staDescricao")})
public class TbStatus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "sta_id")
    private Integer staId;
    @Basic(optional = false)
    @Column(name = "sta_descricao")
    private String staDescricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuStatus")
    private Collection<TbUsuario> tbUsuarioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "funcStatus")
    private Collection<TbFuncionario> tbFuncionarioCollection;

    public TbStatus() {
    }

    public TbStatus(String staDescricao) {
        this.staDescricao = staDescricao;
    }

    public Integer getStaId() {
        return staId;
    }

    public void setStaId(Integer staId) {
        this.staId = staId;
    }

    public String getStaDescricao() {
        return staDescricao;
    }

    public void setStaDescricao(String staDescricao) {
        this.staDescricao = staDescricao;
    }

    @XmlTransient
    public Collection<TbUsuario> getTbUsuarioCollection() {
        return tbUsuarioCollection;
    }

    public void setTbUsuarioCollection(Collection<TbUsuario> tbUsuarioCollection) {
        this.tbUsuarioCollection = tbUsuarioCollection;
    }

    @XmlTransient
    public Collection<TbFuncionario> getTbFuncionarioCollection() {
        return tbFuncionarioCollection;
    }

    public void setTbFuncionarioCollection(Collection<TbFuncionario> tbFuncionarioCollection) {
        this.tbFuncionarioCollection = tbFuncionarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (staId != null ? staId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbStatus)) {
            return false;
        }
        TbStatus other = (TbStatus) object;
        if ((this.staId == null && other.staId != null) || (this.staId != null && !this.staId.equals(other.staId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "codemarket.model.vo.TbStatus[ staId=" + staId + " ]";
    }
    
}
