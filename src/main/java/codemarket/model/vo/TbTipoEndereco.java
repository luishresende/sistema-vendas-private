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
@Table(name = "tb_tipo_endereco")
@NamedQueries({
    @NamedQuery(name = "TbTipoEndereco.findAll", query = "SELECT t FROM TbTipoEndereco t")})
public class TbTipoEndereco implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "te_id")
    private Integer teId;
    @Basic(optional = false)
    @Column(name = "te_descricao")
    private String teDescricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "endTipo")
    private List<TbEndereco> tbEnderecoList;

    public TbTipoEndereco() {
    }

    public TbTipoEndereco(Integer teId) {
        this.teId = teId;
    }

    public TbTipoEndereco(Integer teId, String teDescricao) {
        this.teId = teId;
        this.teDescricao = teDescricao;
    }

    public Integer getTeId() {
        return teId;
    }

    public void setTeId(Integer teId) {
        this.teId = teId;
    }

    public String getTeDescricao() {
        return teDescricao;
    }

    public void setTeDescricao(String teDescricao) {
        this.teDescricao = teDescricao;
    }

    public List<TbEndereco> getTbEnderecoList() {
        return tbEnderecoList;
    }

    public void setTbEnderecoList(List<TbEndereco> tbEnderecoList) {
        this.tbEnderecoList = tbEnderecoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (teId != null ? teId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbTipoEndereco)) {
            return false;
        }
        TbTipoEndereco other = (TbTipoEndereco) object;
        if ((this.teId == null && other.teId != null) || (this.teId != null && !this.teId.equals(other.teId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "codemarket.model.vo.TbTipoEndereco[ teId=" + teId + " ]";
    }
    
}
