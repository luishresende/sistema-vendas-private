package codemarket.model.vo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TbEndereco.class)
public abstract class TbEndereco_ {

	public static volatile SingularAttribute<TbEndereco, Integer> endId;
	public static volatile ListAttribute<TbEndereco, TbEntidade> tbEntidadeList1;
	public static volatile SingularAttribute<TbEndereco, Integer> endNumero;
	public static volatile ListAttribute<TbEndereco, TbEntidade> tbEntidadeList;
	public static volatile SingularAttribute<TbEndereco, String> endComplemento;
	public static volatile SingularAttribute<TbEndereco, TbTipoEndereco> endTipo;
	public static volatile SingularAttribute<TbEndereco, TbEndPostal> endendPid;
	public static volatile ListAttribute<TbEndereco, TbEntidadeHasEndereco> tbEntidadeHasEnderecoList;

	public static final String END_ID = "endId";
	public static final String TB_ENTIDADE_LIST1 = "tbEntidadeList1";
	public static final String END_NUMERO = "endNumero";
	public static final String TB_ENTIDADE_LIST = "tbEntidadeList";
	public static final String END_COMPLEMENTO = "endComplemento";
	public static final String END_TIPO = "endTipo";
	public static final String ENDEND_PID = "endendPid";
	public static final String TB_ENTIDADE_HAS_ENDERECO_LIST = "tbEntidadeHasEnderecoList";

}

