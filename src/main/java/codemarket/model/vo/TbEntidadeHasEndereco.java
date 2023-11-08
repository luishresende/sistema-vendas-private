/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codemarket.model.vo;

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

/**
 *
 * @author kauan
 */
@Entity
@Table(name = "tb_entidade_has_endereco")
@NamedQueries({
    @NamedQuery(name = "TbEntidadeHasEndereco.findAll", query = "SELECT t FROM TbEntidadeHasEndereco t")})
public class TbEntidadeHasEndereco implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ee_id")
    private Integer eeId;
    @JoinColumn(name = "ee_end_id", referencedColumnName = "end_id")
    @ManyToOne(optional = false)
    private TbEndereco eeEndId;
    @JoinColumn(name = "ee_ent_cpfCnpj", referencedColumnName = "ent_cpfCnpj")
    @ManyToOne(optional = false)
    private TbEntidade eeentcpfCnpj;

    public TbEntidadeHasEndereco() {
    }

    public TbEntidadeHasEndereco(Integer eeId) {
        this.eeId = eeId;
    }

    public Integer getEeId() {
        return eeId;
    }

    public void setEeId(Integer eeId) {
        this.eeId = eeId;
    }

    public TbEndereco getEeEndId() {
        return eeEndId;
    }

    public void setEeEndId(TbEndereco eeEndId) {
        this.eeEndId = eeEndId;
    }

    public TbEntidade getEeentcpfCnpj() {
        return eeentcpfCnpj;
    }

    public void setEeentcpfCnpj(TbEntidade eeentcpfCnpj) {
        this.eeentcpfCnpj = eeentcpfCnpj;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eeId != null ? eeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbEntidadeHasEndereco)) {
            return false;
        }
        TbEntidadeHasEndereco other = (TbEntidadeHasEndereco) object;
        if ((this.eeId == null && other.eeId != null) || (this.eeId != null && !this.eeId.equals(other.eeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "codemarket.model.vo.TbEntidadeHasEndereco[ eeId=" + eeId + " ]";
    }
    
}
