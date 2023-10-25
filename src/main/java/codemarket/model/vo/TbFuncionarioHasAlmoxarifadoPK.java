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
public class TbFuncionarioHasAlmoxarifadoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "func_id")
    private int funcId;
    @Basic(optional = false)
    @Column(name = "almo_id")
    private int almoId;

    public TbFuncionarioHasAlmoxarifadoPK() {
    }

    public TbFuncionarioHasAlmoxarifadoPK(int funcId, int almoId) {
        this.funcId = funcId;
        this.almoId = almoId;
    }

    public int getFuncId() {
        return funcId;
    }

    public void setFuncId(int funcId) {
        this.funcId = funcId;
    }

    public int getAlmoId() {
        return almoId;
    }

    public void setAlmoId(int almoId) {
        this.almoId = almoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) funcId;
        hash += (int) almoId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbFuncionarioHasAlmoxarifadoPK)) {
            return false;
        }
        TbFuncionarioHasAlmoxarifadoPK other = (TbFuncionarioHasAlmoxarifadoPK) object;
        if (this.funcId != other.funcId) {
            return false;
        }
        if (this.almoId != other.almoId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "codemarket.model.vo.TbFuncionarioHasAlmoxarifadoPK[ funcId=" + funcId + ", almoId=" + almoId + " ]";
    }
    
}
