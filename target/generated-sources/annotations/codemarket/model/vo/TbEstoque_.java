package codemarket.model.vo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TbEstoque.class)
public abstract class TbEstoque_ {

	public static volatile SingularAttribute<TbEstoque, Integer> estoId;
	public static volatile SingularAttribute<TbEstoque, Short> estoProibirVendaLimMin;
	public static volatile SingularAttribute<TbEstoque, Short> estoAtualizarCustoNoPedido;
	public static volatile SingularAttribute<TbEstoque, TbProduto> estoProdutoCodigo;
	public static volatile SingularAttribute<TbEstoque, Float> estoLimiteMin;
	public static volatile SingularAttribute<TbEstoque, Date> estoDataAtualizacao;
	public static volatile ListAttribute<TbEstoque, TbPedido> tbPedidoList;
	public static volatile ListAttribute<TbEstoque, TbEntradaEstoque> tbEntradaEstoqueList;
	public static volatile SingularAttribute<TbEstoque, Float> estoQuantidade;
	public static volatile SingularAttribute<TbEstoque, Float> estoValorFinal;

	public static final String ESTO_ID = "estoId";
	public static final String ESTO_PROIBIR_VENDA_LIM_MIN = "estoProibirVendaLimMin";
	public static final String ESTO_ATUALIZAR_CUSTO_NO_PEDIDO = "estoAtualizarCustoNoPedido";
	public static final String ESTO_PRODUTO_CODIGO = "estoProdutoCodigo";
	public static final String ESTO_LIMITE_MIN = "estoLimiteMin";
	public static final String ESTO_DATA_ATUALIZACAO = "estoDataAtualizacao";
	public static final String TB_PEDIDO_LIST = "tbPedidoList";
	public static final String TB_ENTRADA_ESTOQUE_LIST = "tbEntradaEstoqueList";
	public static final String ESTO_QUANTIDADE = "estoQuantidade";
	public static final String ESTO_VALOR_FINAL = "estoValorFinal";

}

