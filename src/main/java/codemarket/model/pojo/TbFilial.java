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
import javax.persistence.Lob;
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
@Table(name = "tb_filial")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbFilial.findAll", query = "SELECT t FROM TbFilial t")})
public class TbFilial implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "fil_id")
    private Integer filId;
    @Basic(optional = false)
    @Lob
    @Column(name = "fil_preferencias")
    private String filPreferencias;
    @JoinTable(name = "tb_funcionario_has_filial", joinColumns = {
        @JoinColumn(name = "ff_filial_id", referencedColumnName = "fil_id")}, inverseJoinColumns = {
        @JoinColumn(name = "ff_funcionario_id", referencedColumnName = "func_id")})
    @ManyToMany
    private List<TbFuncionario> tbFuncionarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "funcFilialId")
    private List<TbFuncionario> tbFuncionarioList1;
    @JoinColumn(name = "fil_entidade", referencedColumnName = "ent_cpfCnpj")
    @ManyToOne(optional = false)
    private TbEntidade filEntidade;

    public TbFilial() {
    }

    public TbFilial(Integer filId) {
        this.filId = filId;
    }

    public TbFilial(Integer filId, String filPreferencias) {
        this.filId = filId;
        this.filPreferencias = filPreferencias;
    }

    public Integer getFilId() {
        return filId;
    }

    public void setFilId(Integer filId) {
        this.filId = filId;
    }

    public String getFilPreferencias() {
        return filPreferencias;
    }

    public void setFilPreferencias(String filPreferencias) {
        this.filPreferencias = filPreferencias;
    }

    @XmlTransient
    public List<TbFuncionario> getTbFuncionarioList() {
        return tbFuncionarioList;
    }

    public void setTbFuncionarioList(List<TbFuncionario> tbFuncionarioList) {
        this.tbFuncionarioList = tbFuncionarioList;
    }

    @XmlTransient
    public List<TbFuncionario> getTbFuncionarioList1() {
        return tbFuncionarioList1;
    }

    public void setTbFuncionarioList1(List<TbFuncionario> tbFuncionarioList1) {
        this.tbFuncionarioList1 = tbFuncionarioList1;
    }

    public TbEntidade getFilEntidade() {
        return filEntidade;
    }

    public void setFilEntidade(TbEntidade filEntidade) {
        this.filEntidade = filEntidade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (filId != null ? filId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbFilial)) {
            return false;
        }
        TbFilial other = (TbFilial) object;
        if ((this.filId == null && other.filId != null) || (this.filId != null && !this.filId.equals(other.filId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "codemarket.model.pojo.TbFilial[ filId=" + filId + " ]";
    }
    
}
