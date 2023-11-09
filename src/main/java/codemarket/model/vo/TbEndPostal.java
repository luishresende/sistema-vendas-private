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
import javax.persistence.JoinColumns;
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
@Table(name = "tb_end_postal")
@NamedQueries({
    @NamedQuery(name = "TbEndPostal.findAll", query = "SELECT t FROM TbEndPostal t")})
public class TbEndPostal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "endP_id")
    private Integer endPid;
    @Basic(optional = false)
    @Column(name = "endP_nome_rua")
    private String endPnomerua;
    @Basic(optional = false)
    @Column(name = "end_CEP")
    private String endCEP;
    @JoinColumn(name = "endP_bai_id", referencedColumnName = "bai_id")
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private TbBairro endPbaiid;
    @JoinColumns({
        @JoinColumn(name = "endP_cep_cid_id", referencedColumnName = "cep_cid_id"),
        @JoinColumn(name = "endP_cep_est_sigla", referencedColumnName = "cep_est_sigla")})
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private TbCidEstPai tbCidEstPai;
    @JoinColumn(name = "endP_log_id", referencedColumnName = "log_id")
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private TbLogradouro endPlogid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "endendPid")
    private List<TbEndereco> tbEnderecoList;

    public TbEndPostal() {
    }

    public TbEndPostal(String endPnomerua, String endCEP, TbLogradouro endLogId, TbBairro endPBairro, TbCidEstPai cep) {
        this.endPnomerua = endPnomerua;
        this.endCEP = endCEP;
        this.endPlogid = endLogId;
        this.endPbaiid = endPBairro;
        this.tbCidEstPai = cep;
    }

    public Integer getEndPid() {
        return endPid;
    }

    public void setEndPid(Integer endPid) {
        this.endPid = endPid;
    }

    public String getEndPnomerua() {
        return endPnomerua;
    }

    public void setEndPnomerua(String endPnomerua) {
        this.endPnomerua = endPnomerua;
    }

    public String getEndCEP() {
        return endCEP;
    }

    public void setEndCEP(String endCEP) {
        this.endCEP = endCEP;
    }

    public TbBairro getEndPbaiid() {
        return endPbaiid;
    }

    public void setEndPbaiid(TbBairro endPbaiid) {
        this.endPbaiid = endPbaiid;
    }

    public TbCidEstPai getTbCidEstPai() {
        return tbCidEstPai;
    }

    public void setTbCidEstPai(TbCidEstPai tbCidEstPai) {
        this.tbCidEstPai = tbCidEstPai;
    }

    public TbLogradouro getEndPlogid() {
        return endPlogid;
    }

    public void setEndPlogid(TbLogradouro endPlogid) {
        this.endPlogid = endPlogid;
    }

    public List<TbEndereco> getTbEnderecoList() {
        return tbEnderecoList;
    }

    public void setTbEnderecoList(List<TbEndereco> tbEnderecoList) {
        this.tbEnderecoList = tbEnderecoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (endPid != null ? endPid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbEndPostal)) {
            return false;
        }
        TbEndPostal other = (TbEndPostal) object;
        if ((this.endPid == null && other.endPid != null) || (this.endPid != null && !this.endPid.equals(other.endPid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "codemarket.model.vo.TbEndPostal[ endPid=" + endPid + " ]";
    }
    
}
