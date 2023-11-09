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
@Table(name = "tb_tipo_telefone")
@NamedQueries({
    @NamedQuery(name = "TbTipoTelefone.findAll", query = "SELECT t FROM TbTipoTelefone t")})
public class TbTipoTelefone implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tt_id")
    private Integer ttId;
    @Basic(optional = false)
    @Column(name = "tt_descricao")
    private String ttDescricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "foneTipo")
    private List<TbTelefone> tbTelefoneList;

    public TbTipoTelefone() {
    }

    public TbTipoTelefone(String ttDescricao) {
        this.ttDescricao = ttDescricao;
    }

    public Integer getTtId() {
        return ttId;
    }

    public void setTtId(Integer ttId) {
        this.ttId = ttId;
    }

    public String getTtDescricao() {
        return ttDescricao;
    }

    public void setTtDescricao(String ttDescricao) {
        this.ttDescricao = ttDescricao;
    }

    public List<TbTelefone> getTbTelefoneList() {
        return tbTelefoneList;
    }

    public void setTbTelefoneList(List<TbTelefone> tbTelefoneList) {
        this.tbTelefoneList = tbTelefoneList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ttId != null ? ttId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbTipoTelefone)) {
            return false;
        }
        TbTipoTelefone other = (TbTipoTelefone) object;
        if ((this.ttId == null && other.ttId != null) || (this.ttId != null && !this.ttId.equals(other.ttId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "codemarket.model.vo.TbTipoTelefone[ ttId=" + ttId + " ]";
    }
    
}
