package codemarket.model.vo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TbEndereco.class)
public abstract class TbEndereco_ {

	public static volatile CollectionAttribute<TbEndereco, TbEntidade> tbEntidadeCollection1;
	public static volatile SingularAttribute<TbEndereco, Integer> endId;
	public static volatile SingularAttribute<TbEndereco, Integer> endNumero;
	public static volatile SingularAttribute<TbEndereco, String> endComplemento;
	public static volatile CollectionAttribute<TbEndereco, TbEntidade> tbEntidadeCollection;
	public static volatile SingularAttribute<TbEndereco, TbEndPostal> endendPid;

	public static final String TB_ENTIDADE_COLLECTION1 = "tbEntidadeCollection1";
	public static final String END_ID = "endId";
	public static final String END_NUMERO = "endNumero";
	public static final String END_COMPLEMENTO = "endComplemento";
	public static final String TB_ENTIDADE_COLLECTION = "tbEntidadeCollection";
	public static final String ENDEND_PID = "endendPid";

}

