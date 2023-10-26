package codemarket.model.vo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TbAlmoxarifado.class)
public abstract class TbAlmoxarifado_ {

	public static volatile SingularAttribute<TbAlmoxarifado, String> almoNome;
	public static volatile SingularAttribute<TbAlmoxarifado, Integer> almoId;
	public static volatile CollectionAttribute<TbAlmoxarifado, TbEstoque> tbEstoqueCollection;
	public static volatile CollectionAttribute<TbAlmoxarifado, TbTransferenciasAlmoxarifado> tbTransferenciasAlmoxarifadoCollection1;
	public static volatile SingularAttribute<TbAlmoxarifado, String> almoDescricao;
	public static volatile CollectionAttribute<TbAlmoxarifado, TbEntrada> tbEntradaCollection;
	public static volatile CollectionAttribute<TbAlmoxarifado, TbFuncionarioHasAlmoxarifado> tbFuncionarioHasAlmoxarifadoCollection;
	public static volatile CollectionAttribute<TbAlmoxarifado, TbTransferenciasAlmoxarifado> tbTransferenciasAlmoxarifadoCollection;

	public static final String ALMO_NOME = "almoNome";
	public static final String ALMO_ID = "almoId";
	public static final String TB_ESTOQUE_COLLECTION = "tbEstoqueCollection";
	public static final String TB_TRANSFERENCIAS_ALMOXARIFADO_COLLECTION1 = "tbTransferenciasAlmoxarifadoCollection1";
	public static final String ALMO_DESCRICAO = "almoDescricao";
	public static final String TB_ENTRADA_COLLECTION = "tbEntradaCollection";
	public static final String TB_FUNCIONARIO_HAS_ALMOXARIFADO_COLLECTION = "tbFuncionarioHasAlmoxarifadoCollection";
	public static final String TB_TRANSFERENCIAS_ALMOXARIFADO_COLLECTION = "tbTransferenciasAlmoxarifadoCollection";

}

