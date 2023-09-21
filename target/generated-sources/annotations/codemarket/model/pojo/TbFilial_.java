package codemarket.model.pojo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TbFilial.class)
public abstract class TbFilial_ {

	public static volatile SingularAttribute<TbFilial, TbEntidade> filEntidade;
	public static volatile ListAttribute<TbFilial, TbFuncionario> tbFuncionarioList1;
	public static volatile ListAttribute<TbFilial, TbFuncionario> tbFuncionarioList;
	public static volatile SingularAttribute<TbFilial, Integer> filId;
	public static volatile SingularAttribute<TbFilial, String> filPreferencias;

	public static final String FIL_ENTIDADE = "filEntidade";
	public static final String TB_FUNCIONARIO_LIST1 = "tbFuncionarioList1";
	public static final String TB_FUNCIONARIO_LIST = "tbFuncionarioList";
	public static final String FIL_ID = "filId";
	public static final String FIL_PREFERENCIAS = "filPreferencias";

}

