
package codemarket.control.tableViewModel;
public class EnderecoModel {
    private String tipoEndereco;
    private String cep;
    private String cidade;
    private String pais;
    private String estado;
    private String logradouro;
    private String bairro;
    private String complemento;
    private String numero;

    public EnderecoModel(String tipoEndereco, String cep, String cidade, String estado, String pais, String logradouro, String bairro, String complemento, String numero) {
        this.tipoEndereco = tipoEndereco;
        this.cep = cep;
        this.cidade = cidade;
        this.pais = pais;
        this.estado = estado;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.complemento = complemento;
        this.numero = numero;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipoEndereco() {
        return tipoEndereco;
    }

    public void setTipoEndereco(String tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

  
}