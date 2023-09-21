package codemarket.model.pojo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TbEntradaEstoque.class)
public abstract class TbEntradaEstoque_ {

	public static volatile SingularAttribute<TbEntradaEstoque, TbProduto> entrePdtCodigo;
	public static volatile SingularAttribute<TbEntradaEstoque, TbEntrada> entreEntradaId;
	public static volatile SingularAttribute<TbEntradaEstoque, Integer> entreId;
	public static volatile SingularAttribute<TbEntradaEstoque, TbFornecedor> entreForId;

	public static final String ENTRE_PDT_CODIGO = "entrePdtCodigo";
	public static final String ENTRE_ENTRADA_ID = "entreEntradaId";
	public static final String ENTRE_ID = "entreId";
	public static final String ENTRE_FOR_ID = "entreForId";

}

