package codemarket.model.pojo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TbGrupoPermissoes.class)
public abstract class TbGrupoPermissoes_ {

	public static volatile SingularAttribute<TbGrupoPermissoes, String> gpermPermisoes;
	public static volatile SingularAttribute<TbGrupoPermissoes, Integer> gpermId;
	public static volatile ListAttribute<TbGrupoPermissoes, TbUsuario> tbUsuarioList;
	public static volatile SingularAttribute<TbGrupoPermissoes, String> gpermDescricao;
	public static volatile SingularAttribute<TbGrupoPermissoes, String> gpermNome;

	public static final String GPERM_PERMISOES = "gpermPermisoes";
	public static final String GPERM_ID = "gpermId";
	public static final String TB_USUARIO_LIST = "tbUsuarioList";
	public static final String GPERM_DESCRICAO = "gpermDescricao";
	public static final String GPERM_NOME = "gpermNome";

}

