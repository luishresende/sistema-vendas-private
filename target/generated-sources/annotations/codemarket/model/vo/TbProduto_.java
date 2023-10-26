package codemarket.model.vo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TbProduto.class)
public abstract class TbProduto_ {

	public static volatile SingularAttribute<TbProduto, String> pdtCodigo;
	public static volatile CollectionAttribute<TbProduto, TbEstoque> tbEstoqueCollection;
	public static volatile SingularAttribute<TbProduto, TbUnidadeMedida> pdtUmSigla;
	public static volatile SingularAttribute<TbProduto, String> pdtNome;
	public static volatile CollectionAttribute<TbProduto, TbFornecedorHasProduto> tbFornecedorHasProdutoCollection;
	public static volatile SingularAttribute<TbProduto, TbCategoriaProduto> pdtCategoria;

	public static final String PDT_CODIGO = "pdtCodigo";
	public static final String TB_ESTOQUE_COLLECTION = "tbEstoqueCollection";
	public static final String PDT_UM_SIGLA = "pdtUmSigla";
	public static final String PDT_NOME = "pdtNome";
	public static final String TB_FORNECEDOR_HAS_PRODUTO_COLLECTION = "tbFornecedorHasProdutoCollection";
	public static final String PDT_CATEGORIA = "pdtCategoria";

}

