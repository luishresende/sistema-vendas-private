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
@Table(name = "tb_transferencia_status")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbTransferenciaStatus.findAll", query = "SELECT t FROM TbTransferenciaStatus t"),
    @NamedQuery(name = "TbTransferenciaStatus.findByTrsId", query = "SELECT t FROM TbTransferenciaStatus t WHERE t.trsId = :trsId"),
    @NamedQuery(name = "TbTransferenciaStatus.findByTrsNome", query = "SELECT t FROM TbTransferenciaStatus t WHERE t.trsNome = :trsNome"),
    @NamedQuery(name = "TbTransferenciaStatus.findByTrsDescricao", query = "SELECT t FROM TbTransferenciaStatus t WHERE t.trsDescricao = :trsDescricao")})
public class TbTransferenciaStatus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "trs_id")
    private Integer trsId;
    @Basic(optional = false)
    @Column(name = "trs_nome")
    private String trsNome;
    @Column(name = "trs_descricao")
    private String trsDescricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "traStatus")
    private Collection<TbTransferenciasAlmoxarifado> tbTransferenciasAlmoxarifadoCollection;

    public TbTransferenciaStatus() {
    }

    public TbTransferenciaStatus(String trsNome, String trsDescricao) {
        this.trsNome = trsNome;
        this.trsDescricao = trsDescricao;
    }

    public Integer getTrsId() {
        return trsId;
    }

    public void setTrsId(Integer trsId) {
        this.trsId = trsId;
    }

    public String getTrsNome() {
        return trsNome;
    }

    public void setTrsNome(String trsNome) {
        this.trsNome = trsNome;
    }

    public String getTrsDescricao() {
        return trsDescricao;
    }

    public void setTrsDescricao(String trsDescricao) {
        this.trsDescricao = trsDescricao;
    }

    @XmlTransient
    public Collection<TbTransferenciasAlmoxarifado> getTbTransferenciasAlmoxarifadoCollection() {
        return tbTransferenciasAlmoxarifadoCollection;
    }

    public void setTbTransferenciasAlmoxarifadoCollection(Collection<TbTransferenciasAlmoxarifado> tbTransferenciasAlmoxarifadoCollection) {
        this.tbTransferenciasAlmoxarifadoCollection = tbTransferenciasAlmoxarifadoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (trsId != null ? trsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbTransferenciaStatus)) {
            return false;
        }
        TbTransferenciaStatus other = (TbTransferenciaStatus) object;
        if ((this.trsId == null && other.trsId != null) || (this.trsId != null && !this.trsId.equals(other.trsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "codemarket.model.vo.TbTransferenciaStatus[ trsId=" + trsId + " ]";
    }
    
}
