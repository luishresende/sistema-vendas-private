package codemarket.model.vo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TbCargo.class)
public abstract class TbCargo_ {

	public static volatile SingularAttribute<TbCargo, String> carDescricao;
	public static volatile ListAttribute<TbCargo, TbFuncionario> tbFuncionarioList;
	public static volatile SingularAttribute<TbCargo, Double> carsalarioBase;
	public static volatile SingularAttribute<TbCargo, Integer> carId;

	public static final String CAR_DESCRICAO = "carDescricao";
	public static final String TB_FUNCIONARIO_LIST = "tbFuncionarioList";
	public static final String CARSALARIO_BASE = "carsalarioBase";
	public static final String CAR_ID = "carId";

}

