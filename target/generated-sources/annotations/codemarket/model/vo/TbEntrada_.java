package codemarket.model.vo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TbEntrada.class)
public abstract class TbEntrada_ {

	public static volatile CollectionAttribute<TbEntrada, TbEntradaEstoque> tbEntradaEstoqueCollection;
	public static volatile SingularAttribute<TbEntrada, TbEntradaStatus> entrStatus;
	public static volatile SingularAttribute<TbEntrada, Integer> entrId;
	public static volatile SingularAttribute<TbEntrada, TbAlmoxarifado> entrAlmoId;

	public static final String TB_ENTRADA_ESTOQUE_COLLECTION = "tbEntradaEstoqueCollection";
	public static final String ENTR_STATUS = "entrStatus";
	public static final String ENTR_ID = "entrId";
	public static final String ENTR_ALMO_ID = "entrAlmoId";

}

