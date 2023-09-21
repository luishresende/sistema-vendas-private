package codemarket.model.pojo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TbUnidadeMedida.class)
public abstract class TbUnidadeMedida_ {

	public static volatile ListAttribute<TbUnidadeMedida, TbProduto> tbProdutoList;
	public static volatile SingularAttribute<TbUnidadeMedida, String> umSigla;
	public static volatile SingularAttribute<TbUnidadeMedida, String> umDescricao;
	public static volatile SingularAttribute<TbUnidadeMedida, String> umTipo;

	public static final String TB_PRODUTO_LIST = "tbProdutoList";
	public static final String UM_SIGLA = "umSigla";
	public static final String UM_DESCRICAO = "umDescricao";
	public static final String UM_TIPO = "umTipo";

}

