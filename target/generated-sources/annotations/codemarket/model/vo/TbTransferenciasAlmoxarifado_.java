package codemarket.model.vo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TbTransferenciasAlmoxarifado.class)
public abstract class TbTransferenciasAlmoxarifado_ {

	public static volatile SingularAttribute<TbTransferenciasAlmoxarifado, TbTransferenciaStatus> traStatus;
	public static volatile CollectionAttribute<TbTransferenciasAlmoxarifado, TbPedidoTransferencia> tbPedidoTransferenciaCollection;
	public static volatile SingularAttribute<TbTransferenciasAlmoxarifado, TbAlmoxarifado> traAlmoxarifadoOrigem;
	public static volatile SingularAttribute<TbTransferenciasAlmoxarifado, Integer> traId;
	public static volatile SingularAttribute<TbTransferenciasAlmoxarifado, TbAlmoxarifado> traAlmoxarifadoDestino;

	public static final String TRA_STATUS = "traStatus";
	public static final String TB_PEDIDO_TRANSFERENCIA_COLLECTION = "tbPedidoTransferenciaCollection";
	public static final String TRA_ALMOXARIFADO_ORIGEM = "traAlmoxarifadoOrigem";
	public static final String TRA_ID = "traId";
	public static final String TRA_ALMOXARIFADO_DESTINO = "traAlmoxarifadoDestino";

}

