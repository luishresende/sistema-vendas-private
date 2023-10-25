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
 * @author Luis Resende
 */
@Entity
@Table(name = "tb_transferencias_almoxarifado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbTransferenciasAlmoxarifado.findAll", query = "SELECT t FROM TbTransferenciasAlmoxarifado t")})
public class TbTransferenciasAlmoxarifado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tra_id")
    private Integer traId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ptrTransferenciaId")
    private List<TbPedidoTransferencia> tbPedidoTransferenciaList;
    @JoinColumn(name = "tra_almoxarifado_origem", referencedColumnName = "almo_id")
    @ManyToOne(optional = false)
    private TbAlmoxarifado traAlmoxarifadoOrigem;
    @JoinColumn(name = "tra_almoxarifado_destino", referencedColumnName = "almo_id")
    @ManyToOne(optional = false)
    private TbAlmoxarifado traAlmoxarifadoDestino;
    @JoinColumn(name = "tra_status", referencedColumnName = "trs_id")
    @ManyToOne(optional = false)
    private TbTransferenciaStatus traStatus;

    public TbTransferenciasAlmoxarifado() {
    }

    public TbTransferenciasAlmoxarifado(Integer traId) {
        this.traId = traId;
    }

    public Integer getTraId() {
        return traId;
    }

    public void setTraId(Integer traId) {
        this.traId = traId;
    }

    @XmlTransient
    public List<TbPedidoTransferencia> getTbPedidoTransferenciaList() {
        return tbPedidoTransferenciaList;
    }

    public void setTbPedidoTransferenciaList(List<TbPedidoTransferencia> tbPedidoTransferenciaList) {
        this.tbPedidoTransferenciaList = tbPedidoTransferenciaList;
    }

    public TbAlmoxarifado getTraAlmoxarifadoOrigem() {
        return traAlmoxarifadoOrigem;
    }

    public void setTraAlmoxarifadoOrigem(TbAlmoxarifado traAlmoxarifadoOrigem) {
        this.traAlmoxarifadoOrigem = traAlmoxarifadoOrigem;
    }

    public TbAlmoxarifado getTraAlmoxarifadoDestino() {
        return traAlmoxarifadoDestino;
    }

    public void setTraAlmoxarifadoDestino(TbAlmoxarifado traAlmoxarifadoDestino) {
        this.traAlmoxarifadoDestino = traAlmoxarifadoDestino;
    }

    public TbTransferenciaStatus getTraStatus() {
        return traStatus;
    }

    public void setTraStatus(TbTransferenciaStatus traStatus) {
        this.traStatus = traStatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (traId != null ? traId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbTransferenciasAlmoxarifado)) {
            return false;
        }
        TbTransferenciasAlmoxarifado other = (TbTransferenciasAlmoxarifado) object;
        if ((this.traId == null && other.traId != null) || (this.traId != null && !this.traId.equals(other.traId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "codemarket.model.pojo.TbTransferenciasAlmoxarifado[ traId=" + traId + " ]";
    }
    
}
