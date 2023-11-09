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
@Table(name = "tb_status")
@NamedQueries({
    @NamedQuery(name = "TbStatus.findAll", query = "SELECT t FROM TbStatus t")})
public class TbStatus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sta_id")
    private Integer staId;
    @Basic(optional = false)
    @Column(name = "sta_descricao")
    private String staDescricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuStatus")
    private List<TbUsuario> tbUsuarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "funcStatus")
    private List<TbFuncionario> tbFuncionarioList;

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

    public List<TbUsuario> getTbUsuarioList() {
        return tbUsuarioList;
    }

    public void setTbUsuarioList(List<TbUsuario> tbUsuarioList) {
        this.tbUsuarioList = tbUsuarioList;
    }

    public List<TbFuncionario> getTbFuncionarioList() {
        return tbFuncionarioList;
    }

    public void setTbFuncionarioList(List<TbFuncionario> tbFuncionarioList) {
        this.tbFuncionarioList = tbFuncionarioList;
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
