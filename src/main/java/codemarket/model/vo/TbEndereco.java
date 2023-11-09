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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author kauan
 */
@Entity
@Table(name = "tb_endereco")
@NamedQueries({
    @NamedQuery(name = "TbEndereco.findAll", query = "SELECT t FROM TbEndereco t")})
public class TbEndereco implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eeEndId")
    private List<TbEntidadeHasEndereco> tbEntidadeHasEnderecoList;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "end_id")
    private Integer endId;
    @Column(name = "end_numero")
    private Integer endNumero;
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
    @JoinColumn(name = "end_tipo", referencedColumnName = "te_id")
    @ManyToOne(optional = false)
    private TbTipoEndereco endTipo;

    public TbEndereco() {
    }

    public TbEndereco(int endNumero, String endComplemento, TbEndPostal endpostal, TbTipoEndereco end) {
        this.endNumero = endNumero;
        this.endComplemento = endComplemento;
        this.endendPid = endpostal;
        this.endTipo = end;
        
    }

    public Integer getEndId() {
        return endId;
    }

    public void setEndId(Integer endId) {
        this.endId = endId;
    }

    public Integer getEndNumero() {
        return endNumero;
    }

    public void setEndNumero(Integer endNumero) {
        this.endNumero = endNumero;
    }

    public String getEndComplemento() {
        return endComplemento;
    }

    public void setEndComplemento(String endComplemento) {
        this.endComplemento = endComplemento;
    }

    public List<TbEntidade> getTbEntidadeList() {
        return tbEntidadeList;
    }

    public void setTbEntidadeList(List<TbEntidade> tbEntidadeList) {
        this.tbEntidadeList = tbEntidadeList;
    }

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

    public TbTipoEndereco getEndTipo() {
        return endTipo;
    }

    public void setEndTipo(TbTipoEndereco endTipo) {
        this.endTipo = endTipo;
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

    public List<TbEntidadeHasEndereco> getTbEntidadeHasEnderecoList() {
        return tbEntidadeHasEnderecoList;
    }

    public void setTbEntidadeHasEnderecoList(List<TbEntidadeHasEndereco> tbEntidadeHasEnderecoList) {
        this.tbEntidadeHasEnderecoList = tbEntidadeHasEnderecoList;
    }
    
}
