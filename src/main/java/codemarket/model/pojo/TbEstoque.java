package codemarket.model.pojo;
// Generated 20/09/2023 14:26:58 by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * TbEstoque generated by hbm2java
 */
public class TbEstoque  implements java.io.Serializable {


     private TbEstoqueId id;
     private TbAlmoxarifado tbAlmoxarifado;
     private TbProduto tbProduto;
     private float estoQuantidade;
     private float estoValorFinal;
     private Float estoValorFinalPrazo;
     private float estoLimiteMin;
     private byte estoProibirVendaLimMin;
     private byte estoAtualizarCustoNoPedido;
     private Set tbPedidos = new HashSet(0);
     private Set tbPedidoTransferencias = new HashSet(0);

    public TbEstoque() {
    }

	
    public TbEstoque(TbEstoqueId id, TbAlmoxarifado tbAlmoxarifado, TbProduto tbProduto, float estoQuantidade, float estoValorFinal, float estoLimiteMin, byte estoProibirVendaLimMin, byte estoAtualizarCustoNoPedido) {
        this.id = id;
        this.tbAlmoxarifado = tbAlmoxarifado;
        this.tbProduto = tbProduto;
        this.estoQuantidade = estoQuantidade;
        this.estoValorFinal = estoValorFinal;
        this.estoLimiteMin = estoLimiteMin;
        this.estoProibirVendaLimMin = estoProibirVendaLimMin;
        this.estoAtualizarCustoNoPedido = estoAtualizarCustoNoPedido;
    }
    public TbEstoque(TbEstoqueId id, TbAlmoxarifado tbAlmoxarifado, TbProduto tbProduto, float estoQuantidade, float estoValorFinal, Float estoValorFinalPrazo, float estoLimiteMin, byte estoProibirVendaLimMin, byte estoAtualizarCustoNoPedido, Set tbPedidos, Set tbPedidoTransferencias) {
       this.id = id;
       this.tbAlmoxarifado = tbAlmoxarifado;
       this.tbProduto = tbProduto;
       this.estoQuantidade = estoQuantidade;
       this.estoValorFinal = estoValorFinal;
       this.estoValorFinalPrazo = estoValorFinalPrazo;
       this.estoLimiteMin = estoLimiteMin;
       this.estoProibirVendaLimMin = estoProibirVendaLimMin;
       this.estoAtualizarCustoNoPedido = estoAtualizarCustoNoPedido;
       this.tbPedidos = tbPedidos;
       this.tbPedidoTransferencias = tbPedidoTransferencias;
    }
   
    public TbEstoqueId getId() {
        return this.id;
    }
    
    public void setId(TbEstoqueId id) {
        this.id = id;
    }
    public TbAlmoxarifado getTbAlmoxarifado() {
        return this.tbAlmoxarifado;
    }
    
    public void setTbAlmoxarifado(TbAlmoxarifado tbAlmoxarifado) {
        this.tbAlmoxarifado = tbAlmoxarifado;
    }
    public TbProduto getTbProduto() {
        return this.tbProduto;
    }
    
    public void setTbProduto(TbProduto tbProduto) {
        this.tbProduto = tbProduto;
    }
    public float getEstoQuantidade() {
        return this.estoQuantidade;
    }
    
    public void setEstoQuantidade(float estoQuantidade) {
        this.estoQuantidade = estoQuantidade;
    }
    public float getEstoValorFinal() {
        return this.estoValorFinal;
    }
    
    public void setEstoValorFinal(float estoValorFinal) {
        this.estoValorFinal = estoValorFinal;
    }
    public Float getEstoValorFinalPrazo() {
        return this.estoValorFinalPrazo;
    }
    
    public void setEstoValorFinalPrazo(Float estoValorFinalPrazo) {
        this.estoValorFinalPrazo = estoValorFinalPrazo;
    }
    public float getEstoLimiteMin() {
        return this.estoLimiteMin;
    }
    
    public void setEstoLimiteMin(float estoLimiteMin) {
        this.estoLimiteMin = estoLimiteMin;
    }
    public byte getEstoProibirVendaLimMin() {
        return this.estoProibirVendaLimMin;
    }
    
    public void setEstoProibirVendaLimMin(byte estoProibirVendaLimMin) {
        this.estoProibirVendaLimMin = estoProibirVendaLimMin;
    }
    public byte getEstoAtualizarCustoNoPedido() {
        return this.estoAtualizarCustoNoPedido;
    }
    
    public void setEstoAtualizarCustoNoPedido(byte estoAtualizarCustoNoPedido) {
        this.estoAtualizarCustoNoPedido = estoAtualizarCustoNoPedido;
    }
    public Set getTbPedidos() {
        return this.tbPedidos;
    }
    
    public void setTbPedidos(Set tbPedidos) {
        this.tbPedidos = tbPedidos;
    }
    public Set getTbPedidoTransferencias() {
        return this.tbPedidoTransferencias;
    }
    
    public void setTbPedidoTransferencias(Set tbPedidoTransferencias) {
        this.tbPedidoTransferencias = tbPedidoTransferencias;
    }




}


