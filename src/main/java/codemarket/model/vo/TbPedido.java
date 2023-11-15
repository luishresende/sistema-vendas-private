package codemarket.model.vo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Luis Resende
 */
@Entity
@Table(name = "tb_pedido")
@NamedQueries({
    @NamedQuery(name = "TbPedido.findAll", query = "SELECT t FROM TbPedido t")})
public class TbPedido implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ped_id")
    private Integer pedId;
    @Basic(optional = false)
    @Column(name = "ped_quantidade")
    private float pedQuantidade;
    @Basic(optional = false)
    @Column(name = "ped_desconto")
    private float pedDesconto;
    @JoinColumn(name = "ped_esto_produto", referencedColumnName = "esto_produto_codigo")
    @ManyToOne(optional = false)
    private TbEstoque pedEstoProduto;
    @JoinColumn(name = "ped_venda", referencedColumnName = "ven_id")
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private TbVenda pedVenda;

    public TbPedido() {
    }

    public TbPedido(float pedQuantidade, float pedDesconto, TbVenda venda, TbEstoque pedEstoProduto ) {
        this.pedQuantidade = pedQuantidade;
        this.pedDesconto = pedDesconto;
        this.pedVenda = venda;
        this.pedEstoProduto = pedEstoProduto;
    }

    public Integer getPedId() {
        return pedId;
    }

    public void setPedId(Integer pedId) {
        this.pedId = pedId;
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

    public TbVenda getPedVenda() {
        return pedVenda;
    }

    public void setPedVenda(TbVenda pedVenda) {
        this.pedVenda = pedVenda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pedId != null ? pedId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbPedido)) {
            return false;
        }
        TbPedido other = (TbPedido) object;
        if ((this.pedId == null && other.pedId != null) || (this.pedId != null && !this.pedId.equals(other.pedId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojos.TbPedido[ pedId=" + pedId + " ]";
    }
    
}
