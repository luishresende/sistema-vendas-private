package codemarket.model.vo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TbTipoPagamento.class)
public abstract class TbTipoPagamento_ {

	public static volatile SingularAttribute<TbTipoPagamento, Integer> tpId;
	public static volatile ListAttribute<TbTipoPagamento, TbVenda> tbVendaList;
	public static volatile SingularAttribute<TbTipoPagamento, String> tpDescricao;

	public static final String TP_ID = "tpId";
	public static final String TB_VENDA_LIST = "tbVendaList";
	public static final String TP_DESCRICAO = "tpDescricao";

}

