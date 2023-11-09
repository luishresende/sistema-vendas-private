package codemarket.model.vo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TbEntradaStatus.class)
public abstract class TbEntradaStatus_ {

	public static volatile ListAttribute<TbEntradaStatus, TbEntrada> tbEntradaList;
	public static volatile SingularAttribute<TbEntradaStatus, String> tesDescricao;
	public static volatile SingularAttribute<TbEntradaStatus, Integer> tesId;

	public static final String TB_ENTRADA_LIST = "tbEntradaList";
	public static final String TES_DESCRICAO = "tesDescricao";
	public static final String TES_ID = "tesId";

}

