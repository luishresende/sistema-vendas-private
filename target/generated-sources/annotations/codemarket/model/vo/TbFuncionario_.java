package codemarket.model.vo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TbFuncionario.class)
public abstract class TbFuncionario_ {

	public static volatile SingularAttribute<TbFuncionario, TbCargo> funcCargo;
	public static volatile SingularAttribute<TbFuncionario, TbStatus> funcStatus;
	public static volatile CollectionAttribute<TbFuncionario, TbFilial> tbFilialCollection;
	public static volatile SingularAttribute<TbFuncionario, TbUsuario> funcUsuario;
	public static volatile SingularAttribute<TbFuncionario, TbEntidade> funcEntId;
	public static volatile SingularAttribute<TbFuncionario, Integer> funcId;
	public static volatile CollectionAttribute<TbFuncionario, TbFuncionarioHasAlmoxarifado> tbFuncionarioHasAlmoxarifadoCollection;
	public static volatile SingularAttribute<TbFuncionario, TbFilial> funcFilialId;

	public static final String FUNC_CARGO = "funcCargo";
	public static final String FUNC_STATUS = "funcStatus";
	public static final String TB_FILIAL_COLLECTION = "tbFilialCollection";
	public static final String FUNC_USUARIO = "funcUsuario";
	public static final String FUNC_ENT_ID = "funcEntId";
	public static final String FUNC_ID = "funcId";
	public static final String TB_FUNCIONARIO_HAS_ALMOXARIFADO_COLLECTION = "tbFuncionarioHasAlmoxarifadoCollection";
	public static final String FUNC_FILIAL_ID = "funcFilialId";

}

