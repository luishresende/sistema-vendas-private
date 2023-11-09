package codemarket.model.vo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TbEntidadeHasEndereco.class)
public abstract class TbEntidadeHasEndereco_ {

	public static volatile SingularAttribute<TbEntidadeHasEndereco, Integer> eeId;
	public static volatile SingularAttribute<TbEntidadeHasEndereco, TbEndereco> eeEndId;
	public static volatile SingularAttribute<TbEntidadeHasEndereco, TbEntidade> eeentcpfCnpj;

	public static final String EE_ID = "eeId";
	public static final String EE_END_ID = "eeEndId";
	public static final String EEENTCPF_CNPJ = "eeentcpfCnpj";

}

