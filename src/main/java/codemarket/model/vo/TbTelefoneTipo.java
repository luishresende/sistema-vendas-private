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
@Table(name = "tb_telefone_tipo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbTelefoneTipo.findAll", query = "SELECT t FROM TbTelefoneTipo t")
    , @NamedQuery(name = "TbTelefoneTipo.findByTtId", query = "SELECT t FROM TbTelefoneTipo t WHERE t.ttId = :ttId")
    , @NamedQuery(name = "TbTelefoneTipo.findByTtDescricao", query = "SELECT t FROM TbTelefoneTipo t WHERE t.ttDescricao = :ttDescricao")})
public class TbTelefoneTipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tt_id")
    private Integer ttId;
    @Basic(optional = false)
    @Column(name = "tt_descricao")
    private String ttDescricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "foneTipo")
    private List<TbTelefone> tbTelefoneList;

    public TbTelefoneTipo() {
    }

    public TbTelefoneTipo(Integer ttId) {
        this.ttId = ttId;
    }

    public TbTelefoneTipo(Integer ttId, String ttDescricao) {
        this.ttId = ttId;
        this.ttDescricao = ttDescricao;
    }

    public Integer getTtId() {
        return ttId;
    }

    public void setTtId(Integer ttId) {
        this.ttId = ttId;
    }

    public String getTtDescricao() {
        return ttDescricao;
    }

    public void setTtDescricao(String ttDescricao) {
        this.ttDescricao = ttDescricao;
    }

    @XmlTransient
    public List<TbTelefone> getTbTelefoneList() {
        return tbTelefoneList;
    }

    public void setTbTelefoneList(List<TbTelefone> tbTelefoneList) {
        this.tbTelefoneList = tbTelefoneList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ttId != null ? ttId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbTelefoneTipo)) {
            return false;
        }
        TbTelefoneTipo other = (TbTelefoneTipo) object;
        if ((this.ttId == null && other.ttId != null) || (this.ttId != null && !this.ttId.equals(other.ttId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "codemarket.model.vo.TbTelefoneTipo[ ttId=" + ttId + " ]";
    }
    
}
