package codemarket.model.pojo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TbFornecedorHasProduto.class)
public abstract class TbFornecedorHasProduto_ {

	public static volatile SingularAttribute<TbFornecedorHasProduto, TbProduto> tbProduto;
	public static volatile SingularAttribute<TbFornecedorHasProduto, Float> fhpValorCompra;
	public static volatile SingularAttribute<TbFornecedorHasProduto, TbFornecedor> tbFornecedor;
	public static volatile SingularAttribute<TbFornecedorHasProduto, TbFornecedorHasProdutoPK> tbFornecedorHasProdutoPK;

	public static final String TB_PRODUTO = "tbProduto";
	public static final String FHP_VALOR_COMPRA = "fhpValorCompra";
	public static final String TB_FORNECEDOR = "tbFornecedor";
	public static final String TB_FORNECEDOR_HAS_PRODUTO_PK = "tbFornecedorHasProdutoPK";

}

