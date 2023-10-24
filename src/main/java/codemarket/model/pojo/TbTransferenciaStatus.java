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
import javax.persistence.Id;
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
@Table(name = "tb_transferencia_status")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbTransferenciaStatus.findAll", query = "SELECT t FROM TbTransferenciaStatus t")})
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
    private List<TbTransferenciasAlmoxarifado> tbTransferenciasAlmoxarifadoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entrStatus")
    private List<TbEntrada> tbEntradaList;

    public TbTransferenciaStatus() {
    }

    public TbTransferenciaStatus(Integer trsId) {
        this.trsId = trsId;
    }

    public TbTransferenciaStatus(Integer trsId, String trsNome) {
        this.trsId = trsId;
        this.trsNome = trsNome;
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
    public List<TbTransferenciasAlmoxarifado> getTbTransferenciasAlmoxarifadoList() {
        return tbTransferenciasAlmoxarifadoList;
    }

    public void setTbTransferenciasAlmoxarifadoList(List<TbTransferenciasAlmoxarifado> tbTransferenciasAlmoxarifadoList) {
        this.tbTransferenciasAlmoxarifadoList = tbTransferenciasAlmoxarifadoList;
    }

    @XmlTransient
    public List<TbEntrada> getTbEntradaList() {
        return tbEntradaList;
    }

    public void setTbEntradaList(List<TbEntrada> tbEntradaList) {
        this.tbEntradaList = tbEntradaList;
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
        return "codemarket.model.pojo.TbTransferenciaStatus[ trsId=" + trsId + " ]";
    }
    
}
