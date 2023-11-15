package codemarket.model.vo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Luis Resende
 */
@Entity
@Table(name = "tb_categoria_produto")
@NamedQueries({
    @NamedQuery(name = "TbCategoriaProduto.findAll", query = "SELECT t FROM TbCategoriaProduto t")})
public class TbCategoriaProduto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "catp_id")
    private Integer catpId;
    @Basic(optional = false)
    @Column(name = "catp_descricao")
    private String catpDescricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pdtCategoria")
    private List<TbProduto> tbProdutoList;

    public TbCategoriaProduto() {
    }

    public TbCategoriaProduto(Integer catpId) {
        this.catpId = catpId;
    }

    public TbCategoriaProduto(String catpDescricao) {
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

    public List<TbProduto> getTbProdutoList() {
        return tbProdutoList;
    }

    public void setTbProdutoList(List<TbProduto> tbProdutoList) {
        this.tbProdutoList = tbProdutoList;
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
        return "pojos.TbCategoriaProduto[ catpId=" + catpId + " ]";
    }
    
}
