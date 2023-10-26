package codemarket.model.vo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TbFornecedor.class)
public abstract class TbFornecedor_ {

	public static volatile CollectionAttribute<TbFornecedor, TbEntradaEstoque> tbEntradaEstoqueCollection;
	public static volatile SingularAttribute<TbFornecedor, Integer> forId;
	public static volatile SingularAttribute<TbFornecedor, TbEntidade> forcpfCnpj;
	public static volatile CollectionAttribute<TbFornecedor, TbFornecedorHasProduto> tbFornecedorHasProdutoCollection;

	public static final String TB_ENTRADA_ESTOQUE_COLLECTION = "tbEntradaEstoqueCollection";
	public static final String FOR_ID = "forId";
	public static final String FORCPF_CNPJ = "forcpfCnpj";
	public static final String TB_FORNECEDOR_HAS_PRODUTO_COLLECTION = "tbFornecedorHasProdutoCollection";

}

