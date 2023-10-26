package codemarket.model.vo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TbFuncionarioHasAlmoxarifado.class)
public abstract class TbFuncionarioHasAlmoxarifado_ {

	public static volatile SingularAttribute<TbFuncionarioHasAlmoxarifado, Short> isPadrao;
	public static volatile SingularAttribute<TbFuncionarioHasAlmoxarifado, TbFuncionario> tbFuncionario;
	public static volatile SingularAttribute<TbFuncionarioHasAlmoxarifado, TbAlmoxarifado> tbAlmoxarifado;
	public static volatile SingularAttribute<TbFuncionarioHasAlmoxarifado, TbFuncionarioHasAlmoxarifadoPK> tbFuncionarioHasAlmoxarifadoPK;

	public static final String IS_PADRAO = "isPadrao";
	public static final String TB_FUNCIONARIO = "tbFuncionario";
	public static final String TB_ALMOXARIFADO = "tbAlmoxarifado";
	public static final String TB_FUNCIONARIO_HAS_ALMOXARIFADO_PK = "tbFuncionarioHasAlmoxarifadoPK";

}

