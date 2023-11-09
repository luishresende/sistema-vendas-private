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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author kauan
 */
@Entity
@Table(name = "tb_cliente")
@NamedQueries({
    @NamedQuery(name = "TbCliente.findAll", query = "SELECT t FROM TbCliente t")})
public class TbCliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cli_id")
    private Integer cliId;
    @JoinColumn(name = "cli_cpfCnpj", referencedColumnName = "ent_cpfCnpj")
    @OneToOne(cascade = CascadeType.ALL, optional = false)
    private TbEntidade clicpfCnpj;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "venCliId")
    private List<TbVenda> tbVendaList;

    public TbCliente() {
    }

    public TbCliente(TbEntidade entidade) {
        this.clicpfCnpj = entidade;
    }

    public Integer getCliId() {
        return cliId;
    }

    public void setCliId(Integer cliId) {
        this.cliId = cliId;
    }

    public TbEntidade getClicpfCnpj() {
        return clicpfCnpj;
    }

    public void setClicpfCnpj(TbEntidade clicpfCnpj) {
        this.clicpfCnpj = clicpfCnpj;
    }

    public List<TbVenda> getTbVendaList() {
        return tbVendaList;
    }

    public void setTbVendaList(List<TbVenda> tbVendaList) {
        this.tbVendaList = tbVendaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cliId != null ? cliId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbCliente)) {
            return false;
        }
        TbCliente other = (TbCliente) object;
        if ((this.cliId == null && other.cliId != null) || (this.cliId != null && !this.cliId.equals(other.cliId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "codemarket.model.vo.TbCliente[ cliId=" + cliId + " ]";
    }
    
}
