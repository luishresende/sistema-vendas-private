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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Iuri Pereira
 */
@Entity
@Table(name = "tb_entidade_has_telefone")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbEntidadeHasTelefone.findAll", query = "SELECT t FROM TbEntidadeHasTelefone t")
    , @NamedQuery(name = "TbEntidadeHasTelefone.findByEhtentcpfCnpj", query = "SELECT t FROM TbEntidadeHasTelefone t WHERE t.ehtentcpfCnpj = :ehtentcpfCnpj")})
public class TbEntidadeHasTelefone implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "eht_ent_cpfCnpj")
    private String ehtentcpfCnpj;
    @JoinColumn(name = "eht_ent_cpfCnpj", referencedColumnName = "ent_cpfCnpj", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private TbEntidade tbEntidade;
    @JoinColumn(name = "eht_fone_id", referencedColumnName = "fone_id")
    @ManyToOne(optional = false)
    private TbTelefone ehtFoneId;

    public TbEntidadeHasTelefone() {
    }

    public TbEntidadeHasTelefone(String ehtentcpfCnpj) {
        this.ehtentcpfCnpj = ehtentcpfCnpj;
    }

    public String getEhtentcpfCnpj() {
        return ehtentcpfCnpj;
    }

    public void setEhtentcpfCnpj(String ehtentcpfCnpj) {
        this.ehtentcpfCnpj = ehtentcpfCnpj;
    }

    public TbEntidade getTbEntidade() {
        return tbEntidade;
    }

    public void setTbEntidade(TbEntidade tbEntidade) {
        this.tbEntidade = tbEntidade;
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
        hash += (ehtentcpfCnpj != null ? ehtentcpfCnpj.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbEntidadeHasTelefone)) {
            return false;
        }
        TbEntidadeHasTelefone other = (TbEntidadeHasTelefone) object;
        if ((this.ehtentcpfCnpj == null && other.ehtentcpfCnpj != null) || (this.ehtentcpfCnpj != null && !this.ehtentcpfCnpj.equals(other.ehtentcpfCnpj))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "codemarket.model.vo.TbEntidadeHasTelefone[ ehtentcpfCnpj=" + ehtentcpfCnpj + " ]";
    }
    
}
