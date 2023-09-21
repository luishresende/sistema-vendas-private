package codemarket.model.pojo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TbServico.class)
public abstract class TbServico_ {

	public static volatile ListAttribute<TbServico, TbOrdemServico> tbOrdemServicoList;
	public static volatile SingularAttribute<TbServico, String> serNome;
	public static volatile SingularAttribute<TbServico, Float> serValorBase;
	public static volatile SingularAttribute<TbServico, String> serDescricao;
	public static volatile SingularAttribute<TbServico, Integer> serId;

	public static final String TB_ORDEM_SERVICO_LIST = "tbOrdemServicoList";
	public static final String SER_NOME = "serNome";
	public static final String SER_VALOR_BASE = "serValorBase";
	public static final String SER_DESCRICAO = "serDescricao";
	public static final String SER_ID = "serId";

}

