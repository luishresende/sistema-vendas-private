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
@Table(name = "tb_servico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbServico.findAll", query = "SELECT t FROM TbServico t")})
public class TbServico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ser_id")
    private Integer serId;
    @Basic(optional = false)
    @Column(name = "ser_nome")
    private String serNome;
    @Basic(optional = false)
    @Column(name = "ser_descricao")
    private String serDescricao;
    @Basic(optional = false)
    @Column(name = "ser_valor_base")
    private float serValorBase;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "osServico")
    private List<TbOrdemServico> tbOrdemServicoList;

    public TbServico() {
    }

    public TbServico(Integer serId) {
        this.serId = serId;
    }

    public TbServico(Integer serId, String serNome, String serDescricao, float serValorBase) {
        this.serId = serId;
        this.serNome = serNome;
        this.serDescricao = serDescricao;
        this.serValorBase = serValorBase;
    }

    public Integer getSerId() {
        return serId;
    }

    public void setSerId(Integer serId) {
        this.serId = serId;
    }

    public String getSerNome() {
        return serNome;
    }

    public void setSerNome(String serNome) {
        this.serNome = serNome;
    }

    public String getSerDescricao() {
        return serDescricao;
    }

    public void setSerDescricao(String serDescricao) {
        this.serDescricao = serDescricao;
    }

    public float getSerValorBase() {
        return serValorBase;
    }

    public void setSerValorBase(float serValorBase) {
        this.serValorBase = serValorBase;
    }

    @XmlTransient
    public List<TbOrdemServico> getTbOrdemServicoList() {
        return tbOrdemServicoList;
    }

    public void setTbOrdemServicoList(List<TbOrdemServico> tbOrdemServicoList) {
        this.tbOrdemServicoList = tbOrdemServicoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (serId != null ? serId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbServico)) {
            return false;
        }
        TbServico other = (TbServico) object;
        if ((this.serId == null && other.serId != null) || (this.serId != null && !this.serId.equals(other.serId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "codemarket.model.pojo.TbServico[ serId=" + serId + " ]";
    }
    
}
