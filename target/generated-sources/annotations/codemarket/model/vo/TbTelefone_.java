package codemarket.model.vo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TbTelefone.class)
public abstract class TbTelefone_ {

	public static volatile SingularAttribute<TbTelefone, String> fonenomeContato;
	public static volatile SingularAttribute<TbTelefone, TbTipoTelefone> foneTipo;
	public static volatile SingularAttribute<TbTelefone, Integer> foneId;
	public static volatile ListAttribute<TbTelefone, TbEntidade> tbEntidadeList;
	public static volatile SingularAttribute<TbTelefone, String> foneDescricao;

	public static final String FONENOME_CONTATO = "fonenomeContato";
	public static final String FONE_TIPO = "foneTipo";
	public static final String FONE_ID = "foneId";
	public static final String TB_ENTIDADE_LIST = "tbEntidadeList";
	public static final String FONE_DESCRICAO = "foneDescricao";

}

