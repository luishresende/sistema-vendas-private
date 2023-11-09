package codemarket.model.vo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TbEntrada.class)
public abstract class TbEntrada_ {

	public static volatile ListAttribute<TbEntrada, TbEntradaEstoque> tbEntradaEstoqueList;
	public static volatile SingularAttribute<TbEntrada, TbEntradaStatus> entrStatus;
	public static volatile SingularAttribute<TbEntrada, Integer> entrId;
	public static volatile SingularAttribute<TbEntrada, Integer> entrAlmoId;

	public static final String TB_ENTRADA_ESTOQUE_LIST = "tbEntradaEstoqueList";
	public static final String ENTR_STATUS = "entrStatus";
	public static final String ENTR_ID = "entrId";
	public static final String ENTR_ALMO_ID = "entrAlmoId";

}

