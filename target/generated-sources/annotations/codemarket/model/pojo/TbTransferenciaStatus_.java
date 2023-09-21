package codemarket.model.pojo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TbTransferenciaStatus.class)
public abstract class TbTransferenciaStatus_ {

	public static volatile ListAttribute<TbTransferenciaStatus, TbEntrada> tbEntradaList;
	public static volatile SingularAttribute<TbTransferenciaStatus, Integer> trsId;
	public static volatile SingularAttribute<TbTransferenciaStatus, String> trsDescricao;
	public static volatile SingularAttribute<TbTransferenciaStatus, String> trsNome;
	public static volatile ListAttribute<TbTransferenciaStatus, TbTransferenciasAlmoxarifado> tbTransferenciasAlmoxarifadoList;

	public static final String TB_ENTRADA_LIST = "tbEntradaList";
	public static final String TRS_ID = "trsId";
	public static final String TRS_DESCRICAO = "trsDescricao";
	public static final String TRS_NOME = "trsNome";
	public static final String TB_TRANSFERENCIAS_ALMOXARIFADO_LIST = "tbTransferenciasAlmoxarifadoList";

}

