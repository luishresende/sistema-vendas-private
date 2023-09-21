package codemarket.model.pojo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TbOrdemServico.class)
public abstract class TbOrdemServico_ {

	public static volatile SingularAttribute<TbOrdemServico, TbServico> osServico;
	public static volatile SingularAttribute<TbOrdemServico, TbVenda> osVenda;
	public static volatile SingularAttribute<TbOrdemServico, Float> osValorServico;
	public static volatile SingularAttribute<TbOrdemServico, Integer> osId;

	public static final String OS_SERVICO = "osServico";
	public static final String OS_VENDA = "osVenda";
	public static final String OS_VALOR_SERVICO = "osValorServico";
	public static final String OS_ID = "osId";

}

