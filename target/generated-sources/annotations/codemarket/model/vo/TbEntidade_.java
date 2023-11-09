package codemarket.model.vo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TbEntidade.class)
public abstract class TbEntidade_ {

	public static volatile SingularAttribute<TbEntidade, TbSexo> entSexo;
	public static volatile SingularAttribute<TbEntidade, String> entEmail;
	public static volatile SingularAttribute<TbEntidade, TbEndereco> entEnderecoPrincipal;
	public static volatile SingularAttribute<TbEntidade, TbFornecedor> tbFornecedor;
	public static volatile ListAttribute<TbEntidade, TbTelefone> tbTelefoneList;
	public static volatile SingularAttribute<TbEntidade, String> entTipo;
	public static volatile ListAttribute<TbEntidade, TbEntidadeHasEndereco> tbEntidadeHasEnderecoList;
	public static volatile ListAttribute<TbEntidade, TbEntidadeHasTelefone> tbEntidadeHasTelefoneList;
	public static volatile ListAttribute<TbEntidade, TbFuncionario> tbFuncionarioList;
	public static volatile SingularAttribute<TbEntidade, TbCliente> tbCliente;
	public static volatile SingularAttribute<TbEntidade, String> entNome;
	public static volatile SingularAttribute<TbEntidade, String> entnomeFantasia;
	public static volatile ListAttribute<TbEntidade, TbEndereco> tbEnderecoList;
	public static volatile SingularAttribute<TbEntidade, String> entcpfCnpj;
	public static volatile SingularAttribute<TbEntidade, String> entrgIe;
	public static volatile SingularAttribute<TbEntidade, Date> entdtNasc;

	public static final String ENT_SEXO = "entSexo";
	public static final String ENT_EMAIL = "entEmail";
	public static final String ENT_ENDERECO_PRINCIPAL = "entEnderecoPrincipal";
	public static final String TB_FORNECEDOR = "tbFornecedor";
	public static final String TB_TELEFONE_LIST = "tbTelefoneList";
	public static final String ENT_TIPO = "entTipo";
	public static final String TB_ENTIDADE_HAS_ENDERECO_LIST = "tbEntidadeHasEnderecoList";
	public static final String TB_ENTIDADE_HAS_TELEFONE_LIST = "tbEntidadeHasTelefoneList";
	public static final String TB_FUNCIONARIO_LIST = "tbFuncionarioList";
	public static final String TB_CLIENTE = "tbCliente";
	public static final String ENT_NOME = "entNome";
	public static final String ENTNOME_FANTASIA = "entnomeFantasia";
	public static final String TB_ENDERECO_LIST = "tbEnderecoList";
	public static final String ENTCPF_CNPJ = "entcpfCnpj";
	public static final String ENTRG_IE = "entrgIe";
	public static final String ENTDT_NASC = "entdtNasc";

}

