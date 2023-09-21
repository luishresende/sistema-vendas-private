package codemarket.model.pojo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TbCategoriaProduto.class)
public abstract class TbCategoriaProduto_ {

	public static volatile ListAttribute<TbCategoriaProduto, TbProduto> tbProdutoList;
	public static volatile SingularAttribute<TbCategoriaProduto, Integer> catpId;
	public static volatile SingularAttribute<TbCategoriaProduto, String> catpDescricao;

	public static final String TB_PRODUTO_LIST = "tbProdutoList";
	public static final String CATP_ID = "catpId";
	public static final String CATP_DESCRICAO = "catpDescricao";

}

