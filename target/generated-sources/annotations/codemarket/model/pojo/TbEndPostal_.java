package codemarket.model.pojo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TbEndPostal.class)
public abstract class TbEndPostal_ {

	public static volatile SingularAttribute<TbEndPostal, TbCidEst> tbCidEst;
	public static volatile SingularAttribute<TbEndPostal, TbLogradouro> endPlogid;
	public static volatile SingularAttribute<TbEndPostal, String> endCEP;
	public static volatile SingularAttribute<TbEndPostal, Integer> endPid;
	public static volatile SingularAttribute<TbEndPostal, TbBairro> endPbaiid;
	public static volatile SingularAttribute<TbEndPostal, String> endPnomerua;
	public static volatile ListAttribute<TbEndPostal, TbEndereco> tbEnderecoList;

	public static final String TB_CID_EST = "tbCidEst";
	public static final String END_PLOGID = "endPlogid";
	public static final String END_CE_P = "endCEP";
	public static final String END_PID = "endPid";
	public static final String END_PBAIID = "endPbaiid";
	public static final String END_PNOMERUA = "endPnomerua";
	public static final String TB_ENDERECO_LIST = "tbEnderecoList";

}

