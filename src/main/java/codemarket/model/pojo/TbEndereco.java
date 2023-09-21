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
 * @author Luis Resende
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
    private List<TbEntidade> tbEntidadeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entEnderecoPrincipal")
    private List<TbEntidade> tbEntidadeList1;
    @JoinColumn(name = "end_endP_id", referencedColumnName = "endP_id")
    @ManyToOne(optional = false)
    private TbEndPostal endendPid;

    public TbEndereco() {
    }

    public TbEndereco(Integer endId) {
        this.endId = endId;
    }

    public TbEndereco(Integer endId, int endNumero) {
        this.endId = endId;
        this.endNumero = endNumero;
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
    public List<TbEntidade> getTbEntidadeList() {
        return tbEntidadeList;
    }

    public void setTbEntidadeList(List<TbEntidade> tbEntidadeList) {
        this.tbEntidadeList = tbEntidadeList;
    }

    @XmlTransient
    public List<TbEntidade> getTbEntidadeList1() {
        return tbEntidadeList1;
    }

    public void setTbEntidadeList1(List<TbEntidade> tbEntidadeList1) {
        this.tbEntidadeList1 = tbEntidadeList1;
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
        return "codemarket.model.pojo.TbEndereco[ endId=" + endId + " ]";
    }
    
}
