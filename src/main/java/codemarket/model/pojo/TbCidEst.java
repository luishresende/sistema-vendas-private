/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codemarket.model.pojo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author kauan
 */
@Entity
@Table(name = "tb_cid_est")
@NamedQueries({
    @NamedQuery(name = "TbCidEst.findAll", query = "SELECT t FROM TbCidEst t")})
public class TbCidEst implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TbCidEstPK tbCidEstPK;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbCidEst")
    private List<TbEndPostal> tbEndPostalList;
    @JoinColumn(name = "ce_cid_id", referencedColumnName = "cid_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TbCidade tbCidade;
    @JoinColumn(name = "ce_est_sigla", referencedColumnName = "est_sigla", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TbEstado tbEstado;
    @JoinColumn(name = "cep_pai_sigla", referencedColumnName = "pai_sigla")
    @ManyToOne(optional = false)
    private TbPais cepPaiSigla;

    public TbCidEst() {
    }

    public TbCidEst(TbCidEstPK tbCidEstPK) {
        this.tbCidEstPK = tbCidEstPK;
    }

    public TbCidEst(int ceCidId, String ceEstSigla) {
        this.tbCidEstPK = new TbCidEstPK(ceCidId, ceEstSigla);
    }

    public TbCidEstPK getTbCidEstPK() {
        return tbCidEstPK;
    }

    public void setTbCidEstPK(TbCidEstPK tbCidEstPK) {
        this.tbCidEstPK = tbCidEstPK;
    }

    public List<TbEndPostal> getTbEndPostalList() {
        return tbEndPostalList;
    }

    public void setTbEndPostalList(List<TbEndPostal> tbEndPostalList) {
        this.tbEndPostalList = tbEndPostalList;
    }

    public TbCidade getTbCidade() {
        return tbCidade;
    }

    public void setTbCidade(TbCidade tbCidade) {
        this.tbCidade = tbCidade;
    }

    public TbEstado getTbEstado() {
        return tbEstado;
    }

    public void setTbEstado(TbEstado tbEstado) {
        this.tbEstado = tbEstado;
    }

    public TbPais getCepPaiSigla() {
        return cepPaiSigla;
    }

    public void setCepPaiSigla(TbPais cepPaiSigla) {
        this.cepPaiSigla = cepPaiSigla;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tbCidEstPK != null ? tbCidEstPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbCidEst)) {
            return false;
        }
        TbCidEst other = (TbCidEst) object;
        if ((this.tbCidEstPK == null && other.tbCidEstPK != null) || (this.tbCidEstPK != null && !this.tbCidEstPK.equals(other.tbCidEstPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "codemarket.model.pojo.TbCidEst[ tbCidEstPK=" + tbCidEstPK + " ]";
    }
    
}
