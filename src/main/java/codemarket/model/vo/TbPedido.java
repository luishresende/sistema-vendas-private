/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codemarket.model.vo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author kauan
 */
@Entity
@Table(name = "tb_pedido")
@NamedQueries({
    @NamedQuery(name = "TbPedido.findAll", query = "SELECT t FROM TbPedido t")})
public class TbPedido implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TbPedidoPK tbPedidoPK;
    @Basic(optional = false)
    @Column(name = "ped_quantidade")
    private float pedQuantidade;
    @Basic(optional = false)
    @Column(name = "ped_desconto")
    private float pedDesconto;
    @JoinColumn(name = "ped_esto_produto", referencedColumnName = "esto_produto_codigo")
    @ManyToOne(optional = false)
    private TbEstoque pedEstoProduto;
    @JoinColumn(name = "ped_id", referencedColumnName = "ven_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TbVenda tbVenda;

    public TbPedido() {
    }

    public TbPedido(TbPedidoPK tbPedidoPK) {
        this.tbPedidoPK = tbPedidoPK;
    }

    public TbPedido(TbPedidoPK tbPedidoPK, float pedQuantidade, float pedDesconto) {
        this.tbPedidoPK = tbPedidoPK;
        this.pedQuantidade = pedQuantidade;
        this.pedDesconto = pedDesconto;
    }

    public TbPedido(int pedId, String pedVenda) {
        this.tbPedidoPK = new TbPedidoPK(pedId, pedVenda);
    }

    public TbPedidoPK getTbPedidoPK() {
        return tbPedidoPK;
    }

    public void setTbPedidoPK(TbPedidoPK tbPedidoPK) {
        this.tbPedidoPK = tbPedidoPK;
    }

    public float getPedQuantidade() {
        return pedQuantidade;
    }

    public void setPedQuantidade(float pedQuantidade) {
        this.pedQuantidade = pedQuantidade;
    }

    public float getPedDesconto() {
        return pedDesconto;
    }

    public void setPedDesconto(float pedDesconto) {
        this.pedDesconto = pedDesconto;
    }

    public TbEstoque getPedEstoProduto() {
        return pedEstoProduto;
    }

    public void setPedEstoProduto(TbEstoque pedEstoProduto) {
        this.pedEstoProduto = pedEstoProduto;
    }

    public TbVenda getTbVenda() {
        return tbVenda;
    }

    public void setTbVenda(TbVenda tbVenda) {
        this.tbVenda = tbVenda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tbPedidoPK != null ? tbPedidoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbPedido)) {
            return false;
        }
        TbPedido other = (TbPedido) object;
        if ((this.tbPedidoPK == null && other.tbPedidoPK != null) || (this.tbPedidoPK != null && !this.tbPedidoPK.equals(other.tbPedidoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "codemarket.model.vo.TbPedido[ tbPedidoPK=" + tbPedidoPK + " ]";
    }
    
}
