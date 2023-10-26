package codemarket.model.vo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TbPedido.class)
public abstract class TbPedido_ {

	public static volatile SingularAttribute<TbPedido, TbPedidoPK> tbPedidoPK;
	public static volatile SingularAttribute<TbPedido, Float> pedDesconto;
	public static volatile SingularAttribute<TbPedido, TbVenda> tbVenda;
	public static volatile SingularAttribute<TbPedido, Float> pedQuantidade;
	public static volatile SingularAttribute<TbPedido, TbEstoque> tbEstoque;

	public static final String TB_PEDIDO_PK = "tbPedidoPK";
	public static final String PED_DESCONTO = "pedDesconto";
	public static final String TB_VENDA = "tbVenda";
	public static final String PED_QUANTIDADE = "pedQuantidade";
	public static final String TB_ESTOQUE = "tbEstoque";

}

