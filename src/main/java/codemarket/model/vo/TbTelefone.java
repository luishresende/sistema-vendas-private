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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Iuri Pereira
 */
@Entity
@Table(name = "tb_telefone")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbTelefone.findAll", query = "SELECT t FROM TbTelefone t")
    , @NamedQuery(name = "TbTelefone.findByFoneId", query = "SELECT t FROM TbTelefone t WHERE t.foneId = :foneId")
    , @NamedQuery(name = "TbTelefone.findByFoneNome", query = "SELECT t FROM TbTelefone t WHERE t.foneNome = :foneNome")
    , @NamedQuery(name = "TbTelefone.findByFoneNumero", query = "SELECT t FROM TbTelefone t WHERE t.foneNumero = :foneNumero")})
public class TbTelefone implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "fone_id")
    private Integer foneId;
    @Basic(optional = false)
    @Column(name = "fone_nome")
    private String foneNome;
    @Basic(optional = false)
    @Column(name = "fone_numero")
    private String foneNumero;
    @JoinColumn(name = "fone_tipo", referencedColumnName = "tt_id")
    @ManyToOne(optional = false)
    private TbTelefoneTipo foneTipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ehtFoneId")
    private List<TbEntidadeHasTelefone> tbEntidadeHasTelefoneList;

    public TbTelefone() {
    }

    public TbTelefone(Integer foneId) {
        this.foneId = foneId;
    }

    public TbTelefone(Integer foneId, String foneNome, String foneNumero) {
        this.foneId = foneId;
        this.foneNome = foneNome;
        this.foneNumero = foneNumero;
    }

    public Integer getFoneId() {
        return foneId;
    }

    public void setFoneId(Integer foneId) {
        this.foneId = foneId;
    }

    public String getFoneNome() {
        return foneNome;
    }

    public void setFoneNome(String foneNome) {
        this.foneNome = foneNome;
    }

    public String getFoneNumero() {
        return foneNumero;
    }

    public void setFoneNumero(String foneNumero) {
        this.foneNumero = foneNumero;
    }

    public TbTelefoneTipo getFoneTipo() {
        return foneTipo;
    }

    public void setFoneTipo(TbTelefoneTipo foneTipo) {
        this.foneTipo = foneTipo;
    }

    @XmlTransient
    public List<TbEntidadeHasTelefone> getTbEntidadeHasTelefoneList() {
        return tbEntidadeHasTelefoneList;
    }

    public void setTbEntidadeHasTelefoneList(List<TbEntidadeHasTelefone> tbEntidadeHasTelefoneList) {
        this.tbEntidadeHasTelefoneList = tbEntidadeHasTelefoneList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (foneId != null ? foneId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbTelefone)) {
            return false;
        }
        TbTelefone other = (TbTelefone) object;
        if ((this.foneId == null && other.foneId != null) || (this.foneId != null && !this.foneId.equals(other.foneId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "codemarket.model.vo.TbTelefone[ foneId=" + foneId + " ]";
    }
    
}
