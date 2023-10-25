/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codemarket.model.vo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author kauan
 */
@Embeddable
public class TbEstoquePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "esto_almoxarifado")
    private int estoAlmoxarifado;
    @Basic(optional = false)
    @Column(name = "esto_produto_codigo")
    private String estoProdutoCodigo;

    public TbEstoquePK() {
    }

    public TbEstoquePK(int estoAlmoxarifado, String estoProdutoCodigo) {
        this.estoAlmoxarifado = estoAlmoxarifado;
        this.estoProdutoCodigo = estoProdutoCodigo;
    }

    public int getEstoAlmoxarifado() {
        return estoAlmoxarifado;
    }

    public void setEstoAlmoxarifado(int estoAlmoxarifado) {
        this.estoAlmoxarifado = estoAlmoxarifado;
    }

    public String getEstoProdutoCodigo() {
        return estoProdutoCodigo;
    }

    public void setEstoProdutoCodigo(String estoProdutoCodigo) {
        this.estoProdutoCodigo = estoProdutoCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) estoAlmoxarifado;
        hash += (estoProdutoCodigo != null ? estoProdutoCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbEstoquePK)) {
            return false;
        }
        TbEstoquePK other = (TbEstoquePK) object;
        if (this.estoAlmoxarifado != other.estoAlmoxarifado) {
            return false;
        }
        if ((this.estoProdutoCodigo == null && other.estoProdutoCodigo != null) || (this.estoProdutoCodigo != null && !this.estoProdutoCodigo.equals(other.estoProdutoCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "codemarket.model.vo.TbEstoquePK[ estoAlmoxarifado=" + estoAlmoxarifado + ", estoProdutoCodigo=" + estoProdutoCodigo + " ]";
    }
    
}
