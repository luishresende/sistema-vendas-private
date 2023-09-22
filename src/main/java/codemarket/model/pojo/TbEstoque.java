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
@Table(name = "tb_estoque")
@NamedQueries({
    @NamedQuery(name = "TbEstoque.findAll", query = "SELECT t FROM TbEstoque t")})
public class TbEstoque implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TbEstoquePK tbEstoquePK;
    @Basic(optional = false)
    @Column(name = "esto_quantidade")
    private float estoQuantidade;
    @Basic(optional = false)
    @Column(name = "esto_valor_final")
    private float estoValorFinal;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "esto_valor_final_prazo")
    private Float estoValorFinalPrazo;
    @Basic(optional = false)
    @Column(name = "esto_limite_min")
    private float estoLimiteMin;
    @Basic(optional = false)
    @Column(name = "esto_proibir_venda_lim_min")
    private short estoProibirVendaLimMin;
    @Basic(optional = false)
    @Column(name = "esto_atualizar_custo_no_pedido")
    private short estoAtualizarCustoNoPedido;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbEstoque")
    private List<TbPedidoTransferencia> tbPedidoTransferenciaList;
    @JoinColumn(name = "esto_almoxarifado", referencedColumnName = "almo_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TbAlmoxarifado tbAlmoxarifado;
    @JoinColumn(name = "esto_produto_codigo", referencedColumnName = "pdt_codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TbProduto tbProduto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbEstoque")
    private List<TbPedido> tbPedidoList;

    public TbEstoque() {
    }

    public TbEstoque(TbEstoquePK tbEstoquePK) {
        this.tbEstoquePK = tbEstoquePK;
    }

    public TbEstoque(TbEstoquePK tbEstoquePK, float estoQuantidade, float estoValorFinal, float estoLimiteMin, short estoProibirVendaLimMin, short estoAtualizarCustoNoPedido) {
        this.tbEstoquePK = tbEstoquePK;
        this.estoQuantidade = estoQuantidade;
        this.estoValorFinal = estoValorFinal;
        this.estoLimiteMin = estoLimiteMin;
        this.estoProibirVendaLimMin = estoProibirVendaLimMin;
        this.estoAtualizarCustoNoPedido = estoAtualizarCustoNoPedido;
    }

    public TbEstoque(int estoAlmoxarifado, String estoProdutoCodigo) {
        this.tbEstoquePK = new TbEstoquePK(estoAlmoxarifado, estoProdutoCodigo);
    }

    public TbEstoquePK getTbEstoquePK() {
        return tbEstoquePK;
    }

    public void setTbEstoquePK(TbEstoquePK tbEstoquePK) {
        this.tbEstoquePK = tbEstoquePK;
    }

    public float getEstoQuantidade() {
        return estoQuantidade;
    }

    public void setEstoQuantidade(float estoQuantidade) {
        this.estoQuantidade = estoQuantidade;
    }

    public float getEstoValorFinal() {
        return estoValorFinal;
    }

    public void setEstoValorFinal(float estoValorFinal) {
        this.estoValorFinal = estoValorFinal;
    }

    public Float getEstoValorFinalPrazo() {
        return estoValorFinalPrazo;
    }

    public void setEstoValorFinalPrazo(Float estoValorFinalPrazo) {
        this.estoValorFinalPrazo = estoValorFinalPrazo;
    }

    public float getEstoLimiteMin() {
        return estoLimiteMin;
    }

    public void setEstoLimiteMin(float estoLimiteMin) {
        this.estoLimiteMin = estoLimiteMin;
    }

    public short getEstoProibirVendaLimMin() {
        return estoProibirVendaLimMin;
    }

    public void setEstoProibirVendaLimMin(short estoProibirVendaLimMin) {
        this.estoProibirVendaLimMin = estoProibirVendaLimMin;
    }

    public short getEstoAtualizarCustoNoPedido() {
        return estoAtualizarCustoNoPedido;
    }

    public void setEstoAtualizarCustoNoPedido(short estoAtualizarCustoNoPedido) {
        this.estoAtualizarCustoNoPedido = estoAtualizarCustoNoPedido;
    }

    public List<TbPedidoTransferencia> getTbPedidoTransferenciaList() {
        return tbPedidoTransferenciaList;
    }

    public void setTbPedidoTransferenciaList(List<TbPedidoTransferencia> tbPedidoTransferenciaList) {
        this.tbPedidoTransferenciaList = tbPedidoTransferenciaList;
    }

    public TbAlmoxarifado getTbAlmoxarifado() {
        return tbAlmoxarifado;
    }

    public void setTbAlmoxarifado(TbAlmoxarifado tbAlmoxarifado) {
        this.tbAlmoxarifado = tbAlmoxarifado;
    }

    public TbProduto getTbProduto() {
        return tbProduto;
    }

    public void setTbProduto(TbProduto tbProduto) {
        this.tbProduto = tbProduto;
    }

    public List<TbPedido> getTbPedidoList() {
        return tbPedidoList;
    }

    public void setTbPedidoList(List<TbPedido> tbPedidoList) {
        this.tbPedidoList = tbPedidoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tbEstoquePK != null ? tbEstoquePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbEstoque)) {
            return false;
        }
        TbEstoque other = (TbEstoque) object;
        if ((this.tbEstoquePK == null && other.tbEstoquePK != null) || (this.tbEstoquePK != null && !this.tbEstoquePK.equals(other.tbEstoquePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "codemarket.model.pojo.TbEstoque[ tbEstoquePK=" + tbEstoquePK + " ]";
    }
    
}
