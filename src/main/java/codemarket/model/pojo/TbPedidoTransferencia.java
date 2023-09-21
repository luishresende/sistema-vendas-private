/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codemarket.model.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Luis Resende
 */
@Entity
@Table(name = "tb_pedido_transferencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbPedidoTransferencia.findAll", query = "SELECT t FROM TbPedidoTransferencia t"),
    @NamedQuery(name = "TbPedidoTransferencia.findByPtrId", query = "SELECT t FROM TbPedidoTransferencia t WHERE t.ptrId = :ptrId"),
    @NamedQuery(name = "TbPedidoTransferencia.findByPtrQuantidade", query = "SELECT t FROM TbPedidoTransferencia t WHERE t.ptrQuantidade = :ptrQuantidade")})
public class TbPedidoTransferencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ptr_id")
    private Integer ptrId;
    @Basic(optional = false)
    @Column(name = "ptr_quantidade")
    private float ptrQuantidade;
    @JoinColumns({
        @JoinColumn(name = "ptr_estoque_produto", referencedColumnName = "esto_produto_codigo"),
        @JoinColumn(name = "ptr_estoque_almoxarifado", referencedColumnName = "esto_almoxarifado")})
    @ManyToOne(optional = false)
    private TbEstoque tbEstoque;
    @JoinColumn(name = "ptr_transferencia_id", referencedColumnName = "tra_id")
    @ManyToOne(optional = false)
    private TbTransferenciasAlmoxarifado ptrTransferenciaId;

    public TbPedidoTransferencia() {
    }

    public TbPedidoTransferencia(Integer ptrId) {
        this.ptrId = ptrId;
    }

    public TbPedidoTransferencia(Integer ptrId, float ptrQuantidade) {
        this.ptrId = ptrId;
        this.ptrQuantidade = ptrQuantidade;
    }

    public Integer getPtrId() {
        return ptrId;
    }

    public void setPtrId(Integer ptrId) {
        this.ptrId = ptrId;
    }

    public float getPtrQuantidade() {
        return ptrQuantidade;
    }

    public void setPtrQuantidade(float ptrQuantidade) {
        this.ptrQuantidade = ptrQuantidade;
    }

    public TbEstoque getTbEstoque() {
        return tbEstoque;
    }

    public void setTbEstoque(TbEstoque tbEstoque) {
        this.tbEstoque = tbEstoque;
    }

    public TbTransferenciasAlmoxarifado getPtrTransferenciaId() {
        return ptrTransferenciaId;
    }

    public void setPtrTransferenciaId(TbTransferenciasAlmoxarifado ptrTransferenciaId) {
        this.ptrTransferenciaId = ptrTransferenciaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ptrId != null ? ptrId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbPedidoTransferencia)) {
            return false;
        }
        TbPedidoTransferencia other = (TbPedidoTransferencia) object;
        if ((this.ptrId == null && other.ptrId != null) || (this.ptrId != null && !this.ptrId.equals(other.ptrId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "codemarket.model.pojo.TbPedidoTransferencia[ ptrId=" + ptrId + " ]";
    }
    
}
