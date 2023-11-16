package codemarket.model.vo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TbPedido.class)
public abstract class TbPedido_ {

	public static volatile SingularAttribute<TbPedido, Integer> pedId;
	public static volatile SingularAttribute<TbPedido, TbVenda> pedVenda;
	public static volatile SingularAttribute<TbPedido, Float> pedDesconto;
	public static volatile SingularAttribute<TbPedido, Float> pedQuantidade;
	public static volatile SingularAttribute<TbPedido, TbEstoque> pedEstoProduto;

	public static final String PED_ID = "pedId";
	public static final String PED_VENDA = "pedVenda";
	public static final String PED_DESCONTO = "pedDesconto";
	public static final String PED_QUANTIDADE = "pedQuantidade";
	public static final String PED_ESTO_PRODUTO = "pedEstoProduto";

}

