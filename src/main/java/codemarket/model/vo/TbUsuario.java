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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Luis Resende
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
    @Lob
    @Column(name = "usu_imgPerfil")
    private byte[] usuimgPerfil;
    @JoinColumn(name = "usu_status", referencedColumnName = "sta_id")
    @ManyToOne(optional = false)
    private TbStatus usuStatus;
    @OneToMany(mappedBy = "funcUsuario")
    private List<TbFuncionario> tbFuncionarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "venUsuario")
    private List<TbVenda> tbVendaList;

    public List<TbVenda> getTbVendaList() {
        return tbVendaList;
    }

    public void setTbVendaList(List<TbVenda> tbVendaList) {
        this.tbVendaList = tbVendaList;
    }

    public TbUsuario(String usuUsuario, String usuSenha, Date usuValidade, TbStatus usuStatus, byte[] usuimgPerfil) {
        this.usuUsuario = usuUsuario;
        this.usuSenha = usuSenha;
        this.usuValidade = usuValidade;
        this.usuStatus = usuStatus;
        this.usuimgPerfil = usuimgPerfil;
    }
    
    public TbUsuario(String usuUsuario, String usuSenha, Date usuValidade, TbStatus usuStatus) {
        this.usuUsuario = usuUsuario;
        this.usuSenha = usuSenha;
        this.usuValidade = usuValidade;
        this.usuStatus = usuStatus;
    }

    public TbUsuario(String usuUsuario, String usuSenha, TbStatus usuStatus, byte[] usuimgPerfil) {
        this.usuUsuario = usuUsuario;
        this.usuSenha = usuSenha;
        this.usuValidade = usuValidade;
        this.usuStatus = usuStatus;
        this.usuimgPerfil = usuimgPerfil;
    }
    
    public TbUsuario(String usuUsuario, String usuSenha, TbStatus status) {
        this.usuUsuario = usuUsuario;
        this.usuSenha = usuSenha;
        this.usuStatus = status;
    }
    
    public TbUsuario() {
        
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

    public byte[] getUsuimgPerfil() {
        return usuimgPerfil;
    }

    public void setUsuimgPerfil(byte[] usuimgPerfil) {
        this.usuimgPerfil = usuimgPerfil;
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
        return "pojos.TbUsuario[ usuUsuario=" + usuUsuario + " ]";
    }

}
