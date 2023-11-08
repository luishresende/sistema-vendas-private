/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codemarket.control.tableViewModel;

/**
 *
 * @author kauan
 */
public class FoneModel {
    private String tipoContato;
    private String nomeContato;
    private String ddd;
    private String Fone;

    public FoneModel(String nomeContato, String ddd, String Fone, String tipoContato) {
        this.tipoContato = tipoContato;
        this.nomeContato = nomeContato;
        this.ddd = ddd;
        this.Fone = Fone;
    }

    public String getTipoContato() {
        return tipoContato;
    }

    public void setTipoContato(String tipoContato) {
        this.tipoContato = tipoContato;
    }

    public String getNomeContato() {
        return nomeContato;
    }

    public void setNomeContato(String nomeContato) {
        this.nomeContato = nomeContato;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getFone() {
        return Fone;
    }

    public void setFone(String Fone) {
        this.Fone = Fone;
    }
}
