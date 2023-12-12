/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author kauan
 */
@Entity
@Table(name = "tb_fornecedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbFornecedor.findAll", query = "SELECT t FROM TbFornecedor t"),
    @NamedQuery(name = "TbFornecedor.findByForId", query = "SELECT t FROM TbFornecedor t WHERE t.forId = :forId")})
public class TbFornecedor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "for_id")
    private Integer forId;
    @JoinColumn(name = "for_cpfCnpj", referencedColumnName = "ent_cpfCnpj")
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, optional = false)
    private TbEntidade forcpfCnpj;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pdtForIf")
    private List<TbProduto> tbProdutoList;


    public TbFornecedor() {
    }

    public TbFornecedor(TbEntidade ent) {
        this.forcpfCnpj = ent;
    }

    public Integer getForId() {
        return forId;
    }

    public void setForId(Integer forId) {
        this.forId = forId;
    }

    public TbEntidade getForcpfCnpj() {
        return forcpfCnpj;
    }

    public void setForcpfCnpj(TbEntidade forcpfCnpj) {
        this.forcpfCnpj = forcpfCnpj;
    }

    @XmlTransient
    public List<TbProduto> getTbProdutoList() {
        return tbProdutoList;
    }

    public void setTbProdutoList(List<TbProduto> tbProdutoList) {
        this.tbProdutoList = tbProdutoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (forId != null ? forId.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "teste.TbFornecedor[ forId=" + forId + " ]";
    }
    
}
