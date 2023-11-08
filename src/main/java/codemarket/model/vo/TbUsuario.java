/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codemarket.model.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author kauan
 */
@Entity
@Table(name = "tb_usuario")
@NamedQueries({
    @NamedQuery(name = "TbUsuario.findAll", query = "SELECT t FROM TbUsuario t")})
public class TbUsuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "usu_usuario")
    private String usuUsuario;
    @Basic(optional = false)
    @Column(name = "usu_senha")
    private String usuSenha;
    @Column(name = "usu_validade")
    @Temporal(TemporalType.DATE)
    private Date usuValidade;
    @JoinColumn(name = "usu_status", referencedColumnName = "sta_id")
    @ManyToOne(optional = false)
    private TbStatus usuStatus;
    @OneToMany(mappedBy = "funcUsuario")
    private List<TbFuncionario> tbFuncionarioList;

    public TbUsuario() {
    }

    public TbUsuario(String usuUsuario) {
        this.usuUsuario = usuUsuario;
    }

    public TbUsuario(String usuUsuario, String usuSenha) {
        this.usuUsuario = usuUsuario;
        this.usuSenha = usuSenha;
    }

    public String getUsuUsuario() {
        return usuUsuario;
    }

    public void setUsuUsuario(String usuUsuario) {
        this.usuUsuario = usuUsuario;
    }

    public String getUsuSenha() {
        return usuSenha;
    }

    public void setUsuSenha(String usuSenha) {
        this.usuSenha = usuSenha;
    }

    public Date getUsuValidade() {
        return usuValidade;
    }

    public void setUsuValidade(Date usuValidade) {
        this.usuValidade = usuValidade;
    }

    public TbStatus getUsuStatus() {
        return usuStatus;
    }

    public void setUsuStatus(TbStatus usuStatus) {
        this.usuStatus = usuStatus;
    }

    public List<TbFuncionario> getTbFuncionarioList() {
        return tbFuncionarioList;
    }

    public void setTbFuncionarioList(List<TbFuncionario> tbFuncionarioList) {
        this.tbFuncionarioList = tbFuncionarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuUsuario != null ? usuUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbUsuario)) {
            return false;
        }
        TbUsuario other = (TbUsuario) object;
        if ((this.usuUsuario == null && other.usuUsuario != null) || (this.usuUsuario != null && !this.usuUsuario.equals(other.usuUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "codemarket.model.vo.TbUsuario[ usuUsuario=" + usuUsuario + " ]";
    }
    
}
