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
public class TbPedidoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ped_id")
    private int pedId;
    @Basic(optional = false)
    @Column(name = "ped_venda")
    private String pedVenda;

    public TbPedidoPK() {
    }

    public TbPedidoPK(int pedId, String pedVenda) {
        this.pedId = pedId;
        this.pedVenda = pedVenda;
    }

    public int getPedId() {
        return pedId;
    }

    public void setPedId(int pedId) {
        this.pedId = pedId;
    }

    public String getPedVenda() {
        return pedVenda;
    }

    public void setPedVenda(String pedVenda) {
        this.pedVenda = pedVenda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) pedId;
        hash += (pedVenda != null ? pedVenda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbPedidoPK)) {
            return false;
        }
        TbPedidoPK other = (TbPedidoPK) object;
        if (this.pedId != other.pedId) {
            return false;
        }
        if ((this.pedVenda == null && other.pedVenda != null) || (this.pedVenda != null && !this.pedVenda.equals(other.pedVenda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "codemarket.model.vo.TbPedidoPK[ pedId=" + pedId + ", pedVenda=" + pedVenda + " ]";
    }
    
}
