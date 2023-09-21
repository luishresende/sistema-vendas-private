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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "tb_ordem_servico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbOrdemServico.findAll", query = "SELECT t FROM TbOrdemServico t"),
    @NamedQuery(name = "TbOrdemServico.findByOsId", query = "SELECT t FROM TbOrdemServico t WHERE t.osId = :osId"),
    @NamedQuery(name = "TbOrdemServico.findByOsValorServico", query = "SELECT t FROM TbOrdemServico t WHERE t.osValorServico = :osValorServico")})
public class TbOrdemServico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "os_id")
    private Integer osId;
    @Basic(optional = false)
    @Column(name = "os_valor_servico")
    private float osValorServico;
    @JoinColumn(name = "os_servico", referencedColumnName = "ser_id")
    @ManyToOne(optional = false)
    private TbServico osServico;
    @JoinColumn(name = "os_venda", referencedColumnName = "ven_id")
    @ManyToOne(optional = false)
    private TbVenda osVenda;

    public TbOrdemServico() {
    }

    public TbOrdemServico(Integer osId) {
        this.osId = osId;
    }

    public TbOrdemServico(Integer osId, float osValorServico) {
        this.osId = osId;
        this.osValorServico = osValorServico;
    }

    public Integer getOsId() {
        return osId;
    }

    public void setOsId(Integer osId) {
        this.osId = osId;
    }

    public float getOsValorServico() {
        return osValorServico;
    }

    public void setOsValorServico(float osValorServico) {
        this.osValorServico = osValorServico;
    }

    public TbServico getOsServico() {
        return osServico;
    }

    public void setOsServico(TbServico osServico) {
        this.osServico = osServico;
    }

    public TbVenda getOsVenda() {
        return osVenda;
    }

    public void setOsVenda(TbVenda osVenda) {
        this.osVenda = osVenda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (osId != null ? osId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbOrdemServico)) {
            return false;
        }
        TbOrdemServico other = (TbOrdemServico) object;
        if ((this.osId == null && other.osId != null) || (this.osId != null && !this.osId.equals(other.osId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "codemarket.model.pojo.TbOrdemServico[ osId=" + osId + " ]";
    }
    
}
