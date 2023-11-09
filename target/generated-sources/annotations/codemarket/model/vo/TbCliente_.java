package codemarket.model.vo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TbCliente.class)
public abstract class TbCliente_ {

	public static volatile ListAttribute<TbCliente, TbVenda> tbVendaList;
	public static volatile SingularAttribute<TbCliente, TbEntidade> clicpfCnpj;
	public static volatile SingularAttribute<TbCliente, Integer> cliId;

	public static final String TB_VENDA_LIST = "tbVendaList";
	public static final String CLICPF_CNPJ = "clicpfCnpj";
	public static final String CLI_ID = "cliId";

}

