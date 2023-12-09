package codemarket.control.tableViewModel;

public class EstoqueModel {
    private String Codigo;
    private String DescProduto;
    private String UN;
    private String Avista;
    private String Atual;  
    private String Categoria;  

    public EstoqueModel(Integer Codigo, String DescProduto, String UN, float Avista, float Atual, String Categoria) {
        this.Codigo = String.valueOf(Codigo);
        this.DescProduto = DescProduto;
        this.UN = UN;
        this.Avista = String.valueOf(Avista);
        this.Atual = String.valueOf(Atual);
        this.Categoria = Categoria;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public String getDescProduto() {
        return DescProduto;
    }

    public void setDescProduto(String DescProduto) {
        this.DescProduto = DescProduto;
    }

    public String getUN() {
        return UN;
    }

    public void setUN(String UN) {
        this.UN = UN;
    }


    public String getAtual() {
        return Atual;
    }

    public void setAtual(String Atual) {
        this.Atual = Atual;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public String getAvista() {
        return ("R$ " + Avista);
    }

    public void setAvista(String Avista) {
        this.Avista = Avista;
    }


}
