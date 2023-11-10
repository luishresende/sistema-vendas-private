package codemarket.model.vo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TbUsuario.class)
public abstract class TbUsuario_ {

	public static volatile SingularAttribute<TbUsuario, String> usuSenha;
	public static volatile SingularAttribute<TbUsuario, Date> usuValidade;
	public static volatile SingularAttribute<TbUsuario, TbStatus> usuStatus;
	public static volatile SingularAttribute<TbUsuario, byte[]> usuimgPerfil;
	public static volatile SingularAttribute<TbUsuario, String> usuUsuario;
	public static volatile ListAttribute<TbUsuario, TbFuncionario> tbFuncionarioList;

	public static final String USU_SENHA = "usuSenha";
	public static final String USU_VALIDADE = "usuValidade";
	public static final String USU_STATUS = "usuStatus";
	public static final String USUIMG_PERFIL = "usuimgPerfil";
	public static final String USU_USUARIO = "usuUsuario";
	public static final String TB_FUNCIONARIO_LIST = "tbFuncionarioList";

}

