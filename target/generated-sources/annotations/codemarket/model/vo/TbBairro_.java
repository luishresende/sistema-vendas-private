package codemarket.model.vo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TbBairro.class)
public abstract class TbBairro_ {

	public static volatile ListAttribute<TbBairro, TbEndPostal> tbEndPostalList;
	public static volatile SingularAttribute<TbBairro, Integer> baiId;
	public static volatile SingularAttribute<TbBairro, String> baiDescricao;

	public static final String TB_END_POSTAL_LIST = "tbEndPostalList";
	public static final String BAI_ID = "baiId";
	public static final String BAI_DESCRICAO = "baiDescricao";

}

