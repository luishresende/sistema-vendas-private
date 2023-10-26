package codemarket.model.vo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TbEstoque.class)
public abstract class TbEstoque_ {

	public static volatile SingularAttribute<TbEstoque, Float> estoValorFinalPrazo;
	public static volatile SingularAttribute<TbEstoque, TbProduto> tbProduto;
	public static volatile SingularAttribute<TbEstoque, Short> estoProibirVendaLimMin;
	public static volatile SingularAttribute<TbEstoque, Short> estoAtualizarCustoNoPedido;
	public static volatile CollectionAttribute<TbEstoque, TbEntradaEstoque> tbEntradaEstoqueCollection;
	public static volatile SingularAttribute<TbEstoque, Float> estoLimiteMin;
	public static volatile CollectionAttribute<TbEstoque, TbPedidoTransferencia> tbPedidoTransferenciaCollection;
	public static volatile SingularAttribute<TbEstoque, TbEstoquePK> tbEstoquePK;
	public static volatile SingularAttribute<TbEstoque, TbAlmoxarifado> tbAlmoxarifado;
	public static volatile CollectionAttribute<TbEstoque, TbPedido> tbPedidoCollection;
	public static volatile SingularAttribute<TbEstoque, Float> estoQuantidade;
	public static volatile SingularAttribute<TbEstoque, Float> estoValorFinal;

	public static final String ESTO_VALOR_FINAL_PRAZO = "estoValorFinalPrazo";
	public static final String TB_PRODUTO = "tbProduto";
	public static final String ESTO_PROIBIR_VENDA_LIM_MIN = "estoProibirVendaLimMin";
	public static final String ESTO_ATUALIZAR_CUSTO_NO_PEDIDO = "estoAtualizarCustoNoPedido";
	public static final String TB_ENTRADA_ESTOQUE_COLLECTION = "tbEntradaEstoqueCollection";
	public static final String ESTO_LIMITE_MIN = "estoLimiteMin";
	public static final String TB_PEDIDO_TRANSFERENCIA_COLLECTION = "tbPedidoTransferenciaCollection";
	public static final String TB_ESTOQUE_PK = "tbEstoquePK";
	public static final String TB_ALMOXARIFADO = "tbAlmoxarifado";
	public static final String TB_PEDIDO_COLLECTION = "tbPedidoCollection";
	public static final String ESTO_QUANTIDADE = "estoQuantidade";
	public static final String ESTO_VALOR_FINAL = "estoValorFinal";

}

