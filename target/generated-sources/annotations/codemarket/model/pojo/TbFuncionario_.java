package codemarket.model.pojo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TbFuncionario.class)
public abstract class TbFuncionario_ {

	public static volatile SingularAttribute<TbFuncionario, TbAlmoxarifado> funcStatus;
	public static volatile SingularAttribute<TbFuncionario, TbCargo> funcCargo;
	public static volatile SingularAttribute<TbFuncionario, TbUsuario> funcUsuario;
	public static volatile ListAttribute<TbFuncionario, TbAlmoxarifado> tbAlmoxarifadoList;
	public static volatile SingularAttribute<TbFuncionario, TbEntidade> funcEntId;
	public static volatile SingularAttribute<TbFuncionario, TbStatus> funcStatus1;
	public static volatile ListAttribute<TbFuncionario, TbFilial> tbFilialList;
	public static volatile SingularAttribute<TbFuncionario, Integer> funcId;
	public static volatile SingularAttribute<TbFuncionario, TbFilial> funcFilialId;

	public static final String FUNC_STATUS = "funcStatus";
	public static final String FUNC_CARGO = "funcCargo";
	public static final String FUNC_USUARIO = "funcUsuario";
	public static final String TB_ALMOXARIFADO_LIST = "tbAlmoxarifadoList";
	public static final String FUNC_ENT_ID = "funcEntId";
	public static final String FUNC_STATUS1 = "funcStatus1";
	public static final String TB_FILIAL_LIST = "tbFilialList";
	public static final String FUNC_ID = "funcId";
	public static final String FUNC_FILIAL_ID = "funcFilialId";

}

