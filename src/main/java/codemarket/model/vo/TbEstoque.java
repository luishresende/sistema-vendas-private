package codemarket.model.vo;

import codemarket.model.vo.TbEntradaEstoque;
import codemarket.model.vo.TbPedido;
import codemarket.model.vo.TbProduto;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Luis Resende
 */
@Entity
@Table(name = "tb_estoque")
@NamedQueries({
    @NamedQuery(name = "TbEstoque.findAll", query = "SELECT t FROM TbEstoque t")})
public class TbEstoque implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "esto_id")
    private Integer estoId;
    @Basic(optional = false)
    @Column(name = "esto_valor_base")
    private float estoValorBase;
    @Basic(optional = false)
    @Column(name = "esto_quantidade")
    private float estoQuantidade;
    @Basic(optional = false)
    @Column(name = "esto_valor_final")
    private float estoValorFinal;
    @Basic(optional = false)
    @Column(name = "esto_limite_min")
    private float estoLimiteMin;
    @Basic(optional = false)
    @Column(name = "esto_proibir_venda_lim_min")
    private short estoProibirVendaLimMin;
    @Basic(optional = false)
    @Column(name = "esto_atualizar_custo_no_pedido")
    private short estoAtualizarCustoNoPedido;
    @Basic(optional = false)
    @Column(name = "esto_data_atualizacao")
    @Temporal(TemporalType.DATE)
    private Date estoDataAtualizacao;
    @JoinColumn(name = "esto_produto_codigo", referencedColumnName = "pdt_codigo")
    @OneToOne(cascade = CascadeType.ALL, optional = false)
    private TbProduto estoProdutoCodigo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedEstoProduto")
    private List<TbPedido> tbPedidoList;

    public TbEstoque() {
    }

    public TbEstoque(TbProduto produto, float estoQuantidade, float estoValorFinal, 
                     float estoLimiteMin, short estoProibirVendaLimMin, short estoAtualizarCustoNoPedido, 
                     Date estoDataAtualizacao, float estoValorBase) {
        
        this.estoProdutoCodigo = produto;
        this.estoQuantidade = estoQuantidade;
        this.estoValorFinal = estoValorFinal;
        this.estoLimiteMin = estoLimiteMin;
        this.estoProibirVendaLimMin = estoProibirVendaLimMin;
        this.estoAtualizarCustoNoPedido = estoAtualizarCustoNoPedido;
        this.estoDataAtualizacao = estoDataAtualizacao;
        this.estoValorBase = estoValorBase;
    }

    public Integer getEstoId() {
        return estoId;
    }

    public void setEstoId(Integer estoId) {
        this.estoId = estoId;
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

    public Date getEstoDataAtualizacao() {
        return estoDataAtualizacao;
    }

    public void setEstoDataAtualizacao(Date estoDataAtualizacao) {
        this.estoDataAtualizacao = estoDataAtualizacao;
    }

    public TbProduto getEstoProdutoCodigo() {
        return estoProdutoCodigo;
    }

    public void setEstoProdutoCodigo(TbProduto estoProdutoCodigo) {
        this.estoProdutoCodigo = estoProdutoCodigo;
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
        hash += (estoId != null ? estoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbEstoque)) {
            return false;
        }
        TbEstoque other = (TbEstoque) object;
        if ((this.estoId == null && other.estoId != null) || (this.estoId != null && !this.estoId.equals(other.estoId))) {
            return false;
        }
        return true;
    }

    public float getEstoValorBase() {
        return estoValorBase;
    }

    public void setEstoValorBase(float estoValorBase) {
        this.estoValorBase = estoValorBase;
    }

    @Override
    public String toString() {
        return "pojos.TbEstoque[ estoId=" + estoId + " ]";
    }
    
}
