/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codemarket.model.vo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author kauan
 */
@Entity
@Table(name = "tb_cid_est_pai")
@NamedQueries({
    @NamedQuery(name = "TbCidEstPai.findAll", query = "SELECT t FROM TbCidEstPai t")})
public class TbCidEstPai implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TbCidEstPaiPK tbCidEstPaiPK;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbCidEstPai")
    private List<TbEndPostal> tbEndPostalList;
    @JoinColumn(name = "cep_cid_id", referencedColumnName = "cid_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TbCidade tbCidade;
    @JoinColumn(name = "cep_est_sigla", referencedColumnName = "est_sigla", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TbEstado tbEstado;
    @JoinColumn(name = "cep_pai_sigla", referencedColumnName = "pai_sigla")
    @ManyToOne(optional = false)
    private TbPais cepPaiSigla;

    public TbCidEstPai() {
    }

    public TbCidEstPai(TbCidEstPaiPK tbCidEstPaiPK) {
        this.tbCidEstPaiPK = tbCidEstPaiPK;
    }

    public TbCidEstPai(int cepCidId, String cepEstSigla) {
        this.tbCidEstPaiPK = new TbCidEstPaiPK(cepCidId, cepEstSigla);
    }

    public TbCidEstPaiPK getTbCidEstPaiPK() {
        return tbCidEstPaiPK;
    }

    public void setTbCidEstPaiPK(TbCidEstPaiPK tbCidEstPaiPK) {
        this.tbCidEstPaiPK = tbCidEstPaiPK;
    }

    public List<TbEndPostal> getTbEndPostalList() {
        return tbEndPostalList;
    }

    public void setTbEndPostalList(List<TbEndPostal> tbEndPostalList) {
        this.tbEndPostalList = tbEndPostalList;
    }

    public TbCidade getTbCidade() {
        return tbCidade;
    }

    public void setTbCidade(TbCidade tbCidade) {
        this.tbCidade = tbCidade;
    }

    public TbEstado getTbEstado() {
        return tbEstado;
    }

    public void setTbEstado(TbEstado tbEstado) {
        this.tbEstado = tbEstado;
    }

    public TbPais getCepPaiSigla() {
        return cepPaiSigla;
    }

    public void setCepPaiSigla(TbPais cepPaiSigla) {
        this.cepPaiSigla = cepPaiSigla;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tbCidEstPaiPK != null ? tbCidEstPaiPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbCidEstPai)) {
            return false;
        }
        TbCidEstPai other = (TbCidEstPai) object;
        if ((this.tbCidEstPaiPK == null && other.tbCidEstPaiPK != null) || (this.tbCidEstPaiPK != null && !this.tbCidEstPaiPK.equals(other.tbCidEstPaiPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "codemarket.model.vo.TbCidEstPai[ tbCidEstPaiPK=" + tbCidEstPaiPK + " ]";
    }
    
}
