/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codemarket.model.vo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author kauan
 */
@Embeddable
public class TbCidEstPaiPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "cep_cid_id")
    private int cepCidId;
    @Basic(optional = false)
    @Column(name = "cep_est_sigla")
    private String cepEstSigla;

    public TbCidEstPaiPK() {
    }

    public TbCidEstPaiPK(int cepCidId, String cepEstSigla) {
        this.cepCidId = cepCidId;
        this.cepEstSigla = cepEstSigla;
    }

    public int getCepCidId() {
        return cepCidId;
    }

    public void setCepCidId(int cepCidId) {
        this.cepCidId = cepCidId;
    }

    public String getCepEstSigla() {
        return cepEstSigla;
    }

    public void setCepEstSigla(String cepEstSigla) {
        this.cepEstSigla = cepEstSigla;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) cepCidId;
        hash += (cepEstSigla != null ? cepEstSigla.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbCidEstPaiPK)) {
            return false;
        }
        TbCidEstPaiPK other = (TbCidEstPaiPK) object;
        if (this.cepCidId != other.cepCidId) {
            return false;
        }
        if ((this.cepEstSigla == null && other.cepEstSigla != null) || (this.cepEstSigla != null && !this.cepEstSigla.equals(other.cepEstSigla))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "codemarket.model.vo.TbCidEstPaiPK[ cepCidId=" + cepCidId + ", cepEstSigla=" + cepEstSigla + " ]";
    }
    
}
