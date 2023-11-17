/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codemarket.control.tableViewModel;

public class DetalhesVendaModel {

    private String codigo;
    private String produto;
    private float quantidade;
    private float valorUN;
    private float valorTotal;

    public DetalhesVendaModel(String codigo, String produto, float quantidade, float valorUN, float valorTotal) {
        this.codigo = codigo;
        this.produto = produto;
        this.quantidade = quantidade;
        this.valorUN = valorUN;
        this.valorTotal = valorTotal;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(float quantidade) {
        this.quantidade = quantidade;
    }

    public float getValorUN() {
        return valorUN;
    }

    public void setValorUN(float valorUN) {
        this.valorUN = valorUN;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    
}
