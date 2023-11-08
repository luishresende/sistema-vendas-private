/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codemarket.model.vo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author kauan
 */
@Entity
@Table(name = "tb_telefone")
@NamedQueries({
    @NamedQuery(name = "TbTelefone.findAll", query = "SELECT t FROM TbTelefone t")})
public class TbTelefone implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "fone_id")
    private Integer foneId;
    @Basic(optional = false)
    @Column(name = "fone_descricao")
    private String foneDescricao;
    @ManyToMany(mappedBy = "tbTelefoneList")
    private List<TbEntidade> tbEntidadeList;
    @JoinColumn(name = "fone_tipo", referencedColumnName = "tt_id")
    @ManyToOne(optional = false)
    private TbTipoTelefone foneTipo;

    public TbTelefone() {
    }

    public TbTelefone(Integer foneId) {
        this.foneId = foneId;
    }

    public TbTelefone(Integer foneId, String foneDescricao) {
        this.foneId = foneId;
        this.foneDescricao = foneDescricao;
    }

    public Integer getFoneId() {
        return foneId;
    }

    public void setFoneId(Integer foneId) {
        this.foneId = foneId;
    }

    public String getFoneDescricao() {
        return foneDescricao;
    }

    public void setFoneDescricao(String foneDescricao) {
        this.foneDescricao = foneDescricao;
    }

    public List<TbEntidade> getTbEntidadeList() {
        return tbEntidadeList;
    }

    public void setTbEntidadeList(List<TbEntidade> tbEntidadeList) {
        this.tbEntidadeList = tbEntidadeList;
    }

    public TbTipoTelefone getFoneTipo() {
        return foneTipo;
    }

    public void setFoneTipo(TbTipoTelefone foneTipo) {
        this.foneTipo = foneTipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (foneId != null ? foneId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbTelefone)) {
            return false;
        }
        TbTelefone other = (TbTelefone) object;
        if ((this.foneId == null && other.foneId != null) || (this.foneId != null && !this.foneId.equals(other.foneId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "codemarket.model.vo.TbTelefone[ foneId=" + foneId + " ]";
    }
    
}
