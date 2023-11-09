package codemarket.model.vo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TbCidEstPai.class)
public abstract class TbCidEstPai_ {

	public static volatile SingularAttribute<TbCidEstPai, TbEstado> tbEstado;
	public static volatile ListAttribute<TbCidEstPai, TbEndPostal> tbEndPostalList;
	public static volatile SingularAttribute<TbCidEstPai, TbCidade> tbCidade;
	public static volatile SingularAttribute<TbCidEstPai, TbCidEstPaiPK> tbCidEstPaiPK;
	public static volatile SingularAttribute<TbCidEstPai, TbPais> cepPaiSigla;

	public static final String TB_ESTADO = "tbEstado";
	public static final String TB_END_POSTAL_LIST = "tbEndPostalList";
	public static final String TB_CIDADE = "tbCidade";
	public static final String TB_CID_EST_PAI_PK = "tbCidEstPaiPK";
	public static final String CEP_PAI_SIGLA = "cepPaiSigla";

}

