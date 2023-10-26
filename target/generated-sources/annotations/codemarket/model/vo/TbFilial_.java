package codemarket.model.vo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TbFilial.class)
public abstract class TbFilial_ {

	public static volatile SingularAttribute<TbFilial, TbEntidade> filEntidade;
	public static volatile CollectionAttribute<TbFilial, TbFuncionario> tbFuncionarioCollection;
	public static volatile SingularAttribute<TbFilial, Integer> filId;
	public static volatile SingularAttribute<TbFilial, String> filPreferencias;
	public static volatile CollectionAttribute<TbFilial, TbFuncionario> tbFuncionarioCollection1;

	public static final String FIL_ENTIDADE = "filEntidade";
	public static final String TB_FUNCIONARIO_COLLECTION = "tbFuncionarioCollection";
	public static final String FIL_ID = "filId";
	public static final String FIL_PREFERENCIAS = "filPreferencias";
	public static final String TB_FUNCIONARIO_COLLECTION1 = "tbFuncionarioCollection1";

}

