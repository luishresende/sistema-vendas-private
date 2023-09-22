/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codemarket.model.pojo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author kauan
 */
@Entity
@Table(name = "tb_unidade_medida")
@NamedQueries({
    @NamedQuery(name = "TbUnidadeMedida.findAll", query = "SELECT t FROM TbUnidadeMedida t")})
public class TbUnidadeMedida implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "um_sigla")
    private String umSigla;
    @Basic(optional = false)
    @Column(name = "um_descricao")
    private String umDescricao;
    @Basic(optional = false)
    @Column(name = "um_tipo")
    private String umTipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pdtUmSigla")
    private List<TbProduto> tbProdutoList;

    public TbUnidadeMedida() {
    }

    public TbUnidadeMedida(String umSigla) {
        this.umSigla = umSigla;
    }

    public TbUnidadeMedida(String umSigla, String umDescricao, String umTipo) {
        this.umSigla = umSigla;
        this.umDescricao = umDescricao;
        this.umTipo = umTipo;
    }

    public String getUmSigla() {
        return umSigla;
    }

    public void setUmSigla(String umSigla) {
        this.umSigla = umSigla;
    }

    public String getUmDescricao() {
        return umDescricao;
    }

    public void setUmDescricao(String umDescricao) {
        this.umDescricao = umDescricao;
    }

    public String getUmTipo() {
        return umTipo;
    }

    public void setUmTipo(String umTipo) {
        this.umTipo = umTipo;
    }

    public List<TbProduto> getTbProdutoList() {
        return tbProdutoList;
    }

    public void setTbProdutoList(List<TbProduto> tbProdutoList) {
        this.tbProdutoList = tbProdutoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (umSigla != null ? umSigla.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbUnidadeMedida)) {
            return false;
        }
        TbUnidadeMedida other = (TbUnidadeMedida) object;
        if ((this.umSigla == null && other.umSigla != null) || (this.umSigla != null && !this.umSigla.equals(other.umSigla))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "codemarket.model.pojo.TbUnidadeMedida[ umSigla=" + umSigla + " ]";
    }
    
}
