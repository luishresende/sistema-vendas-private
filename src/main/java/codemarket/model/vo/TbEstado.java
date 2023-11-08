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
@Table(name = "tb_estado")
@NamedQueries({
    @NamedQuery(name = "TbEstado.findAll", query = "SELECT t FROM TbEstado t")})
public class TbEstado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "est_sigla")
    private String estSigla;
    @Basic(optional = false)
    @Column(name = "est_descricao")
    private String estDescricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbEstado")
    private List<TbCidEstPai> tbCidEstPaiList;

    public TbEstado() {
    }

    public TbEstado(String estSigla) {
        this.estSigla = estSigla;
    }

    public TbEstado(String estSigla, String estDescricao) {
        this.estSigla = estSigla;
        this.estDescricao = estDescricao;
    }

    public String getEstSigla() {
        return estSigla;
    }

    public void setEstSigla(String estSigla) {
        this.estSigla = estSigla;
    }

    public String getEstDescricao() {
        return estDescricao;
    }

    public void setEstDescricao(String estDescricao) {
        this.estDescricao = estDescricao;
    }

    public List<TbCidEstPai> getTbCidEstPaiList() {
        return tbCidEstPaiList;
    }

    public void setTbCidEstPaiList(List<TbCidEstPai> tbCidEstPaiList) {
        this.tbCidEstPaiList = tbCidEstPaiList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estSigla != null ? estSigla.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbEstado)) {
            return false;
        }
        TbEstado other = (TbEstado) object;
        if ((this.estSigla == null && other.estSigla != null) || (this.estSigla != null && !this.estSigla.equals(other.estSigla))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "codemarket.model.vo.TbEstado[ estSigla=" + estSigla + " ]";
    }
    
}
