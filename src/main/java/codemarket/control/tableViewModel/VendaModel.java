package codemarket.control.tableViewModel;

public class VendaModel {
    private String codigo;
    private String uni;
    private String valor;
    private String categoria;
    private String descricao;
    private Integer quantidade;

    public VendaModel(String codigo, String uni, float valor, String categoria, String descricao, Integer quantidade) {
        this.codigo = codigo;
        this.uni = uni;
        this.valor = String.valueOf(valor);;
        this.categoria = categoria;
        this.descricao = descricao;
        this.quantidade = quantidade;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUni() {
        return uni;
    }

    public void setUni(String uni) {
        this.uni = uni;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
