/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codemarket.model.vo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author kauan
 */
@Entity
@Table(name = "tb_categoria_produto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbCategoriaProduto.findAll", query = "SELECT t FROM TbCategoriaProduto t"),
    @NamedQuery(name = "TbCategoriaProduto.findByCatpId", query = "SELECT t FROM TbCategoriaProduto t WHERE t.catpId = :catpId"),
    @NamedQuery(name = "TbCategoriaProduto.findByCatpDescricao", query = "SELECT t FROM TbCategoriaProduto t WHERE t.catpDescricao = :catpDescricao")})
public class TbCategoriaProduto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "catp_id")
    private Integer catpId;
    @Basic(optional = false)
    @Column(name = "catp_descricao")
    private String catpDescricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pdtCategoria")
    private Collection<TbProduto> tbProdutoCollection;

    public TbCategoriaProduto() {
    }

    public TbCategoriaProduto(Integer catpId) {
        this.catpId = catpId;
    }

    public TbCategoriaProduto(Integer catpId, String catpDescricao) {
        this.catpId = catpId;
        this.catpDescricao = catpDescricao;
    }

    public Integer getCatpId() {
        return catpId;
    }

    public void setCatpId(Integer catpId) {
        this.catpId = catpId;
    }

    public String getCatpDescricao() {
        return catpDescricao;
    }

    public void setCatpDescricao(String catpDescricao) {
        this.catpDescricao = catpDescricao;
    }

    @XmlTransient
    public Collection<TbProduto> getTbProdutoCollection() {
        return tbProdutoCollection;
    }

    public void setTbProdutoCollection(Collection<TbProduto> tbProdutoCollection) {
        this.tbProdutoCollection = tbProdutoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (catpId != null ? catpId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbCategoriaProduto)) {
            return false;
        }
        TbCategoriaProduto other = (TbCategoriaProduto) object;
        if ((this.catpId == null && other.catpId != null) || (this.catpId != null && !this.catpId.equals(other.catpId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "codemarket.model.vo.TbCategoriaProduto[ catpId=" + catpId + " ]";
    }
    
}
