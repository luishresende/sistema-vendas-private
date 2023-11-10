
package codemarket.control.tableViewModel;
public class FornecedorClienteModel {
    private String nome;
    private String nomeFantasia;
    private String CNPJ;
    private String email;
    private String telefone;

    public FornecedorClienteModel(String nome, String nomeFantasia, String CNPJ, String email, String telefone) {
        this.nome = nome;
        this.nomeFantasia = nomeFantasia;
        this.CNPJ = CNPJ;
        this.email = email;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
  
}