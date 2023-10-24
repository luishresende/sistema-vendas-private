/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codemarket.model.pojo;

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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Luis Resende
 */
@Entity
@Table(name = "tb_pais")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbPais.findAll", query = "SELECT t FROM TbPais t")})
public class TbPais implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pai_sigla")
    private String paiSigla;
    @Basic(optional = false)
    @Column(name = "pai_descricao")
    private String paiDescricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cepPaiSigla")
    private List<TbCidEst> tbCidEstList;

    public TbPais() {
    }

    public TbPais(String paiSigla) {
        this.paiSigla = paiSigla;
    }

    public TbPais(String paiSigla, String paiDescricao) {
        this.paiSigla = paiSigla;
        this.paiDescricao = paiDescricao;
    }

    public String getPaiSigla() {
        return paiSigla;
    }

    public void setPaiSigla(String paiSigla) {
        this.paiSigla = paiSigla;
    }

    public String getPaiDescricao() {
        return paiDescricao;
    }

    public void setPaiDescricao(String paiDescricao) {
        this.paiDescricao = paiDescricao;
    }

    @XmlTransient
    public List<TbCidEst> getTbCidEstList() {
        return tbCidEstList;
    }

    public void setTbCidEstList(List<TbCidEst> tbCidEstList) {
        this.tbCidEstList = tbCidEstList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paiSigla != null ? paiSigla.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbPais)) {
            return false;
        }
        TbPais other = (TbPais) object;
        if ((this.paiSigla == null && other.paiSigla != null) || (this.paiSigla != null && !this.paiSigla.equals(other.paiSigla))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "codemarket.model.pojo.TbPais[ paiSigla=" + paiSigla + " ]";
    }
    
}
