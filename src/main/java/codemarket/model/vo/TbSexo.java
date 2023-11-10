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
@Table(name = "tb_sexo")
@NamedQueries({
    @NamedQuery(name = "TbSexo.findAll", query = "SELECT t FROM TbSexo t")})
public class TbSexo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sex_id")
    private Integer sexId;
    @Basic(optional = false)
    @Column(name = "sex_descricao")
    private String sexDescricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entSexo")
    private List<TbEntidade> tbEntidadeList;

    public TbSexo() {
    }

    public TbSexo(Integer sexId) {
        this.sexId = sexId;
    }

    public TbSexo(Integer sexId, String sexDescricao) {
        this.sexId = sexId;
        this.sexDescricao = sexDescricao;
    }

    public Integer getSexId() {
        return sexId;
    }

    public void setSexId(Integer sexId) {
        this.sexId = sexId;
    }

    public String getSexDescricao() {
        return sexDescricao;
    }

    public void setSexDescricao(String sexDescricao) {
        this.sexDescricao = sexDescricao;
    }

    public List<TbEntidade> getTbEntidadeList() {
        return tbEntidadeList;
    }

    public void setTbEntidadeList(List<TbEntidade> tbEntidadeList) {
        this.tbEntidadeList = tbEntidadeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sexId != null ? sexId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbSexo)) {
            return false;
        }
        TbSexo other = (TbSexo) object;
        if ((this.sexId == null && other.sexId != null) || (this.sexId != null && !this.sexId.equals(other.sexId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "codemarket.model.vo.TbSexo[ sexId=" + sexId + " ]";
    }
    
}
