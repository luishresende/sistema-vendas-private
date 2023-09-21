package codemarket.model.pojo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TbAlmoxarifado.class)
public abstract class TbAlmoxarifado_ {

	public static volatile ListAttribute<TbAlmoxarifado, TbEntrada> tbEntradaList;
	public static volatile SingularAttribute<TbAlmoxarifado, Integer> almoId;
	public static volatile ListAttribute<TbAlmoxarifado, TbFuncionario> tbFuncionarioList1;
	public static volatile ListAttribute<TbAlmoxarifado, TbTransferenciasAlmoxarifado> tbTransferenciasAlmoxarifadoList1;
	public static volatile ListAttribute<TbAlmoxarifado, TbFuncionario> tbFuncionarioList;
	public static volatile SingularAttribute<TbAlmoxarifado, TbAlmoxarifadoHasEstoque> tbAlmoxarifadoHasEstoque;
	public static volatile ListAttribute<TbAlmoxarifado, TbEstoque> tbEstoqueList;
	public static volatile ListAttribute<TbAlmoxarifado, TbTransferenciasAlmoxarifado> tbTransferenciasAlmoxarifadoList;

	public static final String TB_ENTRADA_LIST = "tbEntradaList";
	public static final String ALMO_ID = "almoId";
	public static final String TB_FUNCIONARIO_LIST1 = "tbFuncionarioList1";
	public static final String TB_TRANSFERENCIAS_ALMOXARIFADO_LIST1 = "tbTransferenciasAlmoxarifadoList1";
	public static final String TB_FUNCIONARIO_LIST = "tbFuncionarioList";
	public static final String TB_ALMOXARIFADO_HAS_ESTOQUE = "tbAlmoxarifadoHasEstoque";
	public static final String TB_ESTOQUE_LIST = "tbEstoqueList";
	public static final String TB_TRANSFERENCIAS_ALMOXARIFADO_LIST = "tbTransferenciasAlmoxarifadoList";

}

