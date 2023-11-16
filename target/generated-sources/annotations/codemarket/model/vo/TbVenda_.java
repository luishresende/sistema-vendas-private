package codemarket.model.vo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TbVenda.class)
public abstract class TbVenda_ {

	public static volatile SingularAttribute<TbVenda, Integer> venId;
	public static volatile ListAttribute<TbVenda, TbPedido> tbPedidoList;
	public static volatile SingularAttribute<TbVenda, TbUsuario> venUsuario;
	public static volatile SingularAttribute<TbVenda, TbTipoPagamento> venTpId;
	public static volatile SingularAttribute<TbVenda, TbCliente> venCliId;
	public static volatile SingularAttribute<TbVenda, Date> venData;

	public static final String VEN_ID = "venId";
	public static final String TB_PEDIDO_LIST = "tbPedidoList";
	public static final String VEN_USUARIO = "venUsuario";
	public static final String VEN_TP_ID = "venTpId";
	public static final String VEN_CLI_ID = "venCliId";
	public static final String VEN_DATA = "venData";

}

