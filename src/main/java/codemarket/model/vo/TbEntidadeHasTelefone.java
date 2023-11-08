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
@Table(name = "tb_entidade_has_telefone")
@NamedQueries({
    @NamedQuery(name = "TbEntidadeHasTelefone.findAll", query = "SELECT t FROM TbEntidadeHasTelefone t")})
public class TbEntidadeHasTelefone implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "eht_id")
    private Integer ehtId;
    @JoinColumn(name = "eht_ent_cpfCnpj", referencedColumnName = "ent_cpfCnpj")
    @ManyToOne(optional = false)
    private TbEntidade ehtentcpfCnpj;
    @JoinColumn(name = "eht_fone_id", referencedColumnName = "fone_id")
    @ManyToOne(optional = false)
    private TbTelefone ehtFoneId;

    public TbEntidadeHasTelefone() {
    }

    public TbEntidadeHasTelefone(Integer ehtId) {
        this.ehtId = ehtId;
    }

    public Integer getEhtId() {
        return ehtId;
    }

    public void setEhtId(Integer ehtId) {
        this.ehtId = ehtId;
    }

    public TbEntidade getEhtentcpfCnpj() {
        return ehtentcpfCnpj;
    }

    public void setEhtentcpfCnpj(TbEntidade ehtentcpfCnpj) {
        this.ehtentcpfCnpj = ehtentcpfCnpj;
    }

    public TbTelefone getEhtFoneId() {
        return ehtFoneId;
    }

    public void setEhtFoneId(TbTelefone ehtFoneId) {
        this.ehtFoneId = ehtFoneId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ehtId != null ? ehtId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbEntidadeHasTelefone)) {
            return false;
        }
        TbEntidadeHasTelefone other = (TbEntidadeHasTelefone) object;
        if ((this.ehtId == null && other.ehtId != null) || (this.ehtId != null && !this.ehtId.equals(other.ehtId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "codemarket.model.vo.TbEntidadeHasTelefone[ ehtId=" + ehtId + " ]";
    }
    
}
