package codemarket.model.pojo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TbPedidoTransferencia.class)
public abstract class TbPedidoTransferencia_ {

	public static volatile SingularAttribute<TbPedidoTransferencia, TbTransferenciasAlmoxarifado> ptrTransferenciaId;
	public static volatile SingularAttribute<TbPedidoTransferencia, Float> ptrQuantidade;
	public static volatile SingularAttribute<TbPedidoTransferencia, Integer> ptrId;
	public static volatile SingularAttribute<TbPedidoTransferencia, TbEstoque> tbEstoque;

	public static final String PTR_TRANSFERENCIA_ID = "ptrTransferenciaId";
	public static final String PTR_QUANTIDADE = "ptrQuantidade";
	public static final String PTR_ID = "ptrId";
	public static final String TB_ESTOQUE = "tbEstoque";

}

