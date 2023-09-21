package codemarket.model.pojo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TbCidEst.class)
public abstract class TbCidEst_ {

	public static volatile SingularAttribute<TbCidEst, TbEstado> tbEstado;
	public static volatile ListAttribute<TbCidEst, TbEndPostal> tbEndPostalList;
	public static volatile SingularAttribute<TbCidEst, TbCidade> tbCidade;
	public static volatile SingularAttribute<TbCidEst, TbPais> cepPaiSigla;
	public static volatile SingularAttribute<TbCidEst, TbCidEstPK> tbCidEstPK;

	public static final String TB_ESTADO = "tbEstado";
	public static final String TB_END_POSTAL_LIST = "tbEndPostalList";
	public static final String TB_CIDADE = "tbCidade";
	public static final String CEP_PAI_SIGLA = "cepPaiSigla";
	public static final String TB_CID_EST_PK = "tbCidEstPK";

}

