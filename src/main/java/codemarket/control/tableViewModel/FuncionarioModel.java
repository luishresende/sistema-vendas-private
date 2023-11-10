
package codemarket.control.tableViewModel;
public class FuncionarioModel {
    private String nome;
    private String CPF;
    private String usuario;
    private String telefone;
    private String vencimento;

    public FuncionarioModel(String nome, String cpf, String usuario, String telefone, String vencimento) {
        this.nome = nome;
        this.CPF = cpf;
        this.usuario = usuario;
        this.telefone = telefone;
        this.vencimento = vencimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getVencimento() {
        return vencimento;
    }

    public void setVencimento(String vencimento) {
        this.vencimento = vencimento;
    }

  
}