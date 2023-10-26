package codemarket.model.vo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TbVenda.class)
public abstract class TbVenda_ {

	public static volatile CollectionAttribute<TbVenda, TbOrdemServico> tbOrdemServicoCollection;
	public static volatile SingularAttribute<TbVenda, Integer> venId;
	public static volatile SingularAttribute<TbVenda, TbTipoPagamento> venTpId;
	public static volatile SingularAttribute<TbVenda, TbCliente> venCliId;
	public static volatile CollectionAttribute<TbVenda, TbPedido> tbPedidoCollection;
	public static volatile SingularAttribute<TbVenda, Date> venData;

	public static final String TB_ORDEM_SERVICO_COLLECTION = "tbOrdemServicoCollection";
	public static final String VEN_ID = "venId";
	public static final String VEN_TP_ID = "venTpId";
	public static final String VEN_CLI_ID = "venCliId";
	public static final String TB_PEDIDO_COLLECTION = "tbPedidoCollection";
	public static final String VEN_DATA = "venData";

}

