package codemarket.model.vo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TbTipoEndereco.class)
public abstract class TbTipoEndereco_ {

	public static volatile SingularAttribute<TbTipoEndereco, Integer> teId;
	public static volatile SingularAttribute<TbTipoEndereco, String> teDescricao;
	public static volatile ListAttribute<TbTipoEndereco, TbEndereco> tbEnderecoList;

	public static final String TE_ID = "teId";
	public static final String TE_DESCRICAO = "teDescricao";
	public static final String TB_ENDERECO_LIST = "tbEnderecoList";

}

