package codemarket.model.pojo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TbProduto.class)
public abstract class TbProduto_ {

	public static volatile SingularAttribute<TbProduto, String> pdtCodigo;
	public static volatile ListAttribute<TbProduto, TbFornecedorHasProduto> tbFornecedorHasProdutoList;
	public static volatile SingularAttribute<TbProduto, TbUnidadeMedida> pdtUmSigla;
	public static volatile ListAttribute<TbProduto, TbEstoque> tbEstoqueList;
	public static volatile ListAttribute<TbProduto, TbEntradaEstoque> tbEntradaEstoqueList;
	public static volatile SingularAttribute<TbProduto, String> pdtNome;
	public static volatile SingularAttribute<TbProduto, TbCategoriaProduto> pdtCategoria;

	public static final String PDT_CODIGO = "pdtCodigo";
	public static final String TB_FORNECEDOR_HAS_PRODUTO_LIST = "tbFornecedorHasProdutoList";
	public static final String PDT_UM_SIGLA = "pdtUmSigla";
	public static final String TB_ESTOQUE_LIST = "tbEstoqueList";
	public static final String TB_ENTRADA_ESTOQUE_LIST = "tbEntradaEstoqueList";
	public static final String PDT_NOME = "pdtNome";
	public static final String PDT_CATEGORIA = "pdtCategoria";

}

