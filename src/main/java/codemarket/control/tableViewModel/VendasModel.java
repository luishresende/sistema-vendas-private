/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codemarket.control.tableViewModel;

/**
 *
 * @author Luis Resende
 */
public class VendasModel {

    private Integer ID;
    private float valorTotal;
    private String clienteNome;
    private String tipoPagamento;
    private String funcionarioResponsavel;
    private String data;

    public VendasModel(Integer ID, float valorTotal, String clienteNome, String tipoPagamento, String funcionarioResponsavel, String data) {
        this.ID = ID;
        this.valorTotal = valorTotal;
        this.clienteNome = clienteNome;
        this.tipoPagamento = tipoPagamento;
        this.funcionarioResponsavel = funcionarioResponsavel;
        this.data = data;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getClienteNome() {
        return clienteNome;
    }

    public void setClienteNome(String clienteNome) {
        this.clienteNome = clienteNome;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public String getFuncionarioResponsavel() {
        return funcionarioResponsavel;
    }

    public void setFuncionarioResponsavel(String funcionarioResponsavel) {
        this.funcionarioResponsavel = funcionarioResponsavel;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }
    
}
