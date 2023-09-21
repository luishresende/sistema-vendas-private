package codemarket.model.pojo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TbLogradouro.class)
public abstract class TbLogradouro_ {

	public static volatile ListAttribute<TbLogradouro, TbEndPostal> tbEndPostalList;
	public static volatile SingularAttribute<TbLogradouro, String> logDescricao;
	public static volatile SingularAttribute<TbLogradouro, Integer> logId;

	public static final String TB_END_POSTAL_LIST = "tbEndPostalList";
	public static final String LOG_DESCRICAO = "logDescricao";
	public static final String LOG_ID = "logId";

}

