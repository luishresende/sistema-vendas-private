package codemarket.model.vo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TbEntradaStatus.class)
public abstract class TbEntradaStatus_ {

	public static volatile SingularAttribute<TbEntradaStatus, String> tesDescricao;
	public static volatile CollectionAttribute<TbEntradaStatus, TbEntrada> tbEntradaCollection;
	public static volatile SingularAttribute<TbEntradaStatus, Integer> tesId;

	public static final String TES_DESCRICAO = "tesDescricao";
	public static final String TB_ENTRADA_COLLECTION = "tbEntradaCollection";
	public static final String TES_ID = "tesId";

}

