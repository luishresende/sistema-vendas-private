package codemarket.model.vo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TbSexo.class)
public abstract class TbSexo_ {

	public static volatile SingularAttribute<TbSexo, Integer> sexId;
	public static volatile ListAttribute<TbSexo, TbEntidade> tbEntidadeList;
	public static volatile SingularAttribute<TbSexo, String> sexDescricao;

	public static final String SEX_ID = "sexId";
	public static final String TB_ENTIDADE_LIST = "tbEntidadeList";
	public static final String SEX_DESCRICAO = "sexDescricao";

}

