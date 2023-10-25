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
public class TbFornecedorHasProdutoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "fhp_id")
    private int fhpId;
    @Basic(optional = false)
    @Column(name = "fhp_pdt")
    private String fhpPdt;

    public TbFornecedorHasProdutoPK() {
    }

    public TbFornecedorHasProdutoPK(int fhpId, String fhpPdt) {
        this.fhpId = fhpId;
        this.fhpPdt = fhpPdt;
    }

    public int getFhpId() {
        return fhpId;
    }

    public void setFhpId(int fhpId) {
        this.fhpId = fhpId;
    }

    public String getFhpPdt() {
        return fhpPdt;
    }

    public void setFhpPdt(String fhpPdt) {
        this.fhpPdt = fhpPdt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) fhpId;
        hash += (fhpPdt != null ? fhpPdt.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbFornecedorHasProdutoPK)) {
            return false;
        }
        TbFornecedorHasProdutoPK other = (TbFornecedorHasProdutoPK) object;
        if (this.fhpId != other.fhpId) {
            return false;
        }
        if ((this.fhpPdt == null && other.fhpPdt != null) || (this.fhpPdt != null && !this.fhpPdt.equals(other.fhpPdt))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "codemarket.model.pojo.TbFornecedorHasProdutoPK[ fhpId=" + fhpId + ", fhpPdt=" + fhpPdt + " ]";
    }
    
}
