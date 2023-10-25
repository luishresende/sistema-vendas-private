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
 * @author Luis Resende
 */
@Embeddable
public class TbCidEstPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ce_cid_id")
    private int ceCidId;
    @Basic(optional = false)
    @Column(name = "ce_est_sigla")
    private String ceEstSigla;

    public TbCidEstPK() {
    }

    public TbCidEstPK(int ceCidId, String ceEstSigla) {
        this.ceCidId = ceCidId;
        this.ceEstSigla = ceEstSigla;
    }

    public int getCeCidId() {
        return ceCidId;
    }

    public void setCeCidId(int ceCidId) {
        this.ceCidId = ceCidId;
    }

    public String getCeEstSigla() {
        return ceEstSigla;
    }

    public void setCeEstSigla(String ceEstSigla) {
        this.ceEstSigla = ceEstSigla;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) ceCidId;
        hash += (ceEstSigla != null ? ceEstSigla.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbCidEstPK)) {
            return false;
        }
        TbCidEstPK other = (TbCidEstPK) object;
        if (this.ceCidId != other.ceCidId) {
            return false;
        }
        if ((this.ceEstSigla == null && other.ceEstSigla != null) || (this.ceEstSigla != null && !this.ceEstSigla.equals(other.ceEstSigla))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "codemarket.model.pojo.TbCidEstPK[ ceCidId=" + ceCidId + ", ceEstSigla=" + ceEstSigla + " ]";
    }
    
}
