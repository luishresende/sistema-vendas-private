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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "tb_endereco")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbEndereco.findAll", query = "SELECT t FROM TbEndereco t"),
    @NamedQuery(name = "TbEndereco.findByEndId", query = "SELECT t FROM TbEndereco t WHERE t.endId = :endId"),
    @NamedQuery(name = "TbEndereco.findByEndNumero", query = "SELECT t FROM TbEndereco t WHERE t.endNumero = :endNumero"),
    @NamedQuery(name = "TbEndereco.findByEndComplemento", query = "SELECT t FROM TbEndereco t WHERE t.endComplemento = :endComplemento")})
public class TbEndereco implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "end_id")
    private Integer endId;
    @Basic(optional = false)
    @Column(name = "end_numero")
    private int endNumero;
    @Column(name = "end_complemento")
    private String endComplemento;
    @JoinTable(name = "tb_entidade_has_endereco", joinColumns = {
        @JoinColumn(name = "ee_end_id", referencedColumnName = "end_id")}, inverseJoinColumns = {
        @JoinColumn(name = "ee_ent_cpfCnpj", referencedColumnName = "ent_cpfCnpj")})
    @ManyToMany
    private Collection<TbEntidade> tbEntidadeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entEnderecoPrincipal")
    private Collection<TbEntidade> tbEntidadeCollection1;
    @JoinColumn(name = "end_endP_id", referencedColumnName = "endP_id")
    @ManyToOne(optional = false)
    private TbEndPostal endendPid;

    public TbEndereco() {
    }

    public TbEndereco(int endNumero, String endComplemento, TbEndPostal endendPid) {
        this.endNumero = endNumero;
        this.endComplemento = endComplemento;
        this.endendPid = endendPid;
    }

    public Integer getEndId() {
        return endId;
    }

    public void setEndId(Integer endId) {
        this.endId = endId;
    }

    public int getEndNumero() {
        return endNumero;
    }

    public void setEndNumero(int endNumero) {
        this.endNumero = endNumero;
    }

    public String getEndComplemento() {
        return endComplemento;
    }

    public void setEndComplemento(String endComplemento) {
        this.endComplemento = endComplemento;
    }

    @XmlTransient
    public Collection<TbEntidade> getTbEntidadeCollection() {
        return tbEntidadeCollection;
    }

    public void setTbEntidadeCollection(Collection<TbEntidade> tbEntidadeCollection) {
        this.tbEntidadeCollection = tbEntidadeCollection;
    }

    @XmlTransient
    public Collection<TbEntidade> getTbEntidadeCollection1() {
        return tbEntidadeCollection1;
    }

    public void setTbEntidadeCollection1(Collection<TbEntidade> tbEntidadeCollection1) {
        this.tbEntidadeCollection1 = tbEntidadeCollection1;
    }

    public TbEndPostal getEndendPid() {
        return endendPid;
    }

    public void setEndendPid(TbEndPostal endendPid) {
        this.endendPid = endendPid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (endId != null ? endId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbEndereco)) {
            return false;
        }
        TbEndereco other = (TbEndereco) object;
        if ((this.endId == null && other.endId != null) || (this.endId != null && !this.endId.equals(other.endId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "codemarket.model.vo.TbEndereco[ endId=" + endId + " ]";
    }
    
}
