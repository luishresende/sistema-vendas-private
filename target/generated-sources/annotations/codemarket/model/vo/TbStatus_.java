package codemarket.model.vo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TbStatus.class)
public abstract class TbStatus_ {

	public static volatile SingularAttribute<TbStatus, Integer> staId;
	public static volatile SingularAttribute<TbStatus, String> staDescricao;
	public static volatile CollectionAttribute<TbStatus, TbFuncionario> tbFuncionarioCollection;
	public static volatile CollectionAttribute<TbStatus, TbUsuario> tbUsuarioCollection;

	public static final String STA_ID = "staId";
	public static final String STA_DESCRICAO = "staDescricao";
	public static final String TB_FUNCIONARIO_COLLECTION = "tbFuncionarioCollection";
	public static final String TB_USUARIO_COLLECTION = "tbUsuarioCollection";

}

