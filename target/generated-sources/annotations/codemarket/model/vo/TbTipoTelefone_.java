package codemarket.model.vo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TbTipoTelefone.class)
public abstract class TbTipoTelefone_ {

	public static volatile SingularAttribute<TbTipoTelefone, String> ttDescricao;
	public static volatile ListAttribute<TbTipoTelefone, TbTelefone> tbTelefoneList;
	public static volatile SingularAttribute<TbTipoTelefone, Integer> ttId;

	public static final String TT_DESCRICAO = "ttDescricao";
	public static final String TB_TELEFONE_LIST = "tbTelefoneList";
	public static final String TT_ID = "ttId";

}

