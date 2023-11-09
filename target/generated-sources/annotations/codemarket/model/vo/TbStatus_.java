package codemarket.model.vo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TbStatus.class)
public abstract class TbStatus_ {

	public static volatile SingularAttribute<TbStatus, Integer> staId;
	public static volatile SingularAttribute<TbStatus, String> staDescricao;
	public static volatile ListAttribute<TbStatus, TbFuncionario> tbFuncionarioList;
	public static volatile ListAttribute<TbStatus, TbUsuario> tbUsuarioList;

	public static final String STA_ID = "staId";
	public static final String STA_DESCRICAO = "staDescricao";
	public static final String TB_FUNCIONARIO_LIST = "tbFuncionarioList";
	public static final String TB_USUARIO_LIST = "tbUsuarioList";

}

