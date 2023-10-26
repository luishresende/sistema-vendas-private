package codemarket.model.vo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TbCategoriaProduto.class)
public abstract class TbCategoriaProduto_ {

	public static volatile CollectionAttribute<TbCategoriaProduto, TbProduto> tbProdutoCollection;
	public static volatile SingularAttribute<TbCategoriaProduto, Integer> catpId;
	public static volatile SingularAttribute<TbCategoriaProduto, String> catpDescricao;

	public static final String TB_PRODUTO_COLLECTION = "tbProdutoCollection";
	public static final String CATP_ID = "catpId";
	public static final String CATP_DESCRICAO = "catpDescricao";

}

