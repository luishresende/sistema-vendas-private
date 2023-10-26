package codemarket.model.vo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TbEstado.class)
public abstract class TbEstado_ {

	public static volatile SingularAttribute<TbEstado, String> estDescricao;
	public static volatile CollectionAttribute<TbEstado, TbCidEstPai> tbCidEstPaiCollection;
	public static volatile SingularAttribute<TbEstado, String> estSigla;

	public static final String EST_DESCRICAO = "estDescricao";
	public static final String TB_CID_EST_PAI_COLLECTION = "tbCidEstPaiCollection";
	public static final String EST_SIGLA = "estSigla";

}

