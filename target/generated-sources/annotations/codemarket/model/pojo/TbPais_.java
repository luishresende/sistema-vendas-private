package codemarket.model.pojo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TbPais.class)
public abstract class TbPais_ {

	public static volatile SingularAttribute<TbPais, String> paiSigla;
	public static volatile SingularAttribute<TbPais, String> paiDescricao;
	public static volatile ListAttribute<TbPais, TbCidEst> tbCidEstList;

	public static final String PAI_SIGLA = "paiSigla";
	public static final String PAI_DESCRICAO = "paiDescricao";
	public static final String TB_CID_EST_LIST = "tbCidEstList";

}

