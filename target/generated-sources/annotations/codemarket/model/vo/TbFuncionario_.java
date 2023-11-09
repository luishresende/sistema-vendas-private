package codemarket.model.vo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TbFuncionario.class)
public abstract class TbFuncionario_ {

	public static volatile SingularAttribute<TbFuncionario, TbCargo> funcCargo;
	public static volatile SingularAttribute<TbFuncionario, TbStatus> funcStatus;
	public static volatile SingularAttribute<TbFuncionario, TbEntidade> funcentcpfCnpj;
	public static volatile SingularAttribute<TbFuncionario, TbUsuario> funcUsuario;
	public static volatile SingularAttribute<TbFuncionario, Integer> funcId;

	public static final String FUNC_CARGO = "funcCargo";
	public static final String FUNC_STATUS = "funcStatus";
	public static final String FUNCENTCPF_CNPJ = "funcentcpfCnpj";
	public static final String FUNC_USUARIO = "funcUsuario";
	public static final String FUNC_ID = "funcId";

}

