package codemarket.model.vo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TbCidade.class)
public abstract class TbCidade_ {

	public static volatile SingularAttribute<TbCidade, String> cidDescricao;
	public static volatile ListAttribute<TbCidade, TbCidEstPai> tbCidEstPaiList;
	public static volatile SingularAttribute<TbCidade, Integer> cidId;

	public static final String CID_DESCRICAO = "cidDescricao";
	public static final String TB_CID_EST_PAI_LIST = "tbCidEstPaiList";
	public static final String CID_ID = "cidId";

}

