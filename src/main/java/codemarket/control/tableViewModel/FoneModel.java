/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codemarket.control.tableViewModel;

import codemarket.model.vo.TbTelefone;

/**
 *
 * @author kauan
 */
public class FoneModel {
    private String tipoContato;
    private String nomeContato;

    public TbTelefone getHas() {
        return has;
    }

    public void setHas(TbTelefone has) {
        this.has = has;
    }
    private String ddd;
    private String Fone;
    private TbTelefone has;

    public FoneModel(String nomeContato, String ddd, String Fone, String tipoContato, TbTelefone has) {
        this.tipoContato = tipoContato;
        this.nomeContato = nomeContato;
        this.ddd = ddd;
        this.Fone = Fone;
        this.has = has;
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
