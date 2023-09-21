package codemarket.model.pojo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TbFornecedor.class)
public abstract class TbFornecedor_ {

	public static volatile ListAttribute<TbFornecedor, TbFornecedorHasProduto> tbFornecedorHasProdutoList;
	public static volatile SingularAttribute<TbFornecedor, Integer> forId;
	public static volatile ListAttribute<TbFornecedor, TbEntradaEstoque> tbEntradaEstoqueList;
	public static volatile SingularAttribute<TbFornecedor, TbEntidade> forcpfCnpj;

	public static final String TB_FORNECEDOR_HAS_PRODUTO_LIST = "tbFornecedorHasProdutoList";
	public static final String FOR_ID = "forId";
	public static final String TB_ENTRADA_ESTOQUE_LIST = "tbEntradaEstoqueList";
	public static final String FORCPF_CNPJ = "forcpfCnpj";

}

