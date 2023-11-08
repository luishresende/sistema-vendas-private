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
@Table(name = "tb_entrada_status")
@NamedQueries({
    @NamedQuery(name = "TbEntradaStatus.findAll", query = "SELECT t FROM TbEntradaStatus t")})
public class TbEntradaStatus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tes_id")
    private Integer tesId;
    @Basic(optional = false)
    @Column(name = "tes_descricao")
    private String tesDescricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entrStatus")
    private List<TbEntrada> tbEntradaList;

    public TbEntradaStatus() {
    }

    public TbEntradaStatus(Integer tesId) {
        this.tesId = tesId;
    }

    public TbEntradaStatus(Integer tesId, String tesDescricao) {
        this.tesId = tesId;
        this.tesDescricao = tesDescricao;
    }

    public Integer getTesId() {
        return tesId;
    }

    public void setTesId(Integer tesId) {
        this.tesId = tesId;
    }

    public String getTesDescricao() {
        return tesDescricao;
    }

    public void setTesDescricao(String tesDescricao) {
        this.tesDescricao = tesDescricao;
    }

    public List<TbEntrada> getTbEntradaList() {
        return tbEntradaList;
    }

    public void setTbEntradaList(List<TbEntrada> tbEntradaList) {
        this.tbEntradaList = tbEntradaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tesId != null ? tesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbEntradaStatus)) {
            return false;
        }
        TbEntradaStatus other = (TbEntradaStatus) object;
        if ((this.tesId == null && other.tesId != null) || (this.tesId != null && !this.tesId.equals(other.tesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "codemarket.model.vo.TbEntradaStatus[ tesId=" + tesId + " ]";
    }
    
}
