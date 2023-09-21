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
import javax.persistence.Lob;
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
@Table(name = "tb_grupo_permissoes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbGrupoPermissoes.findAll", query = "SELECT t FROM TbGrupoPermissoes t"),
    @NamedQuery(name = "TbGrupoPermissoes.findByGpermId", query = "SELECT t FROM TbGrupoPermissoes t WHERE t.gpermId = :gpermId"),
    @NamedQuery(name = "TbGrupoPermissoes.findByGpermNome", query = "SELECT t FROM TbGrupoPermissoes t WHERE t.gpermNome = :gpermNome"),
    @NamedQuery(name = "TbGrupoPermissoes.findByGpermDescricao", query = "SELECT t FROM TbGrupoPermissoes t WHERE t.gpermDescricao = :gpermDescricao")})
public class TbGrupoPermissoes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "gperm_id")
    private Integer gpermId;
    @Basic(optional = false)
    @Column(name = "gperm_nome")
    private String gpermNome;
    @Basic(optional = false)
    @Column(name = "gperm_descricao")
    private String gpermDescricao;
    @Basic(optional = false)
    @Lob
    @Column(name = "gperm_permisoes")
    private String gpermPermisoes;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuGpPermissao")
    private List<TbUsuario> tbUsuarioList;

    public TbGrupoPermissoes() {
    }

    public TbGrupoPermissoes(Integer gpermId) {
        this.gpermId = gpermId;
    }

    public TbGrupoPermissoes(Integer gpermId, String gpermNome, String gpermDescricao, String gpermPermisoes) {
        this.gpermId = gpermId;
        this.gpermNome = gpermNome;
        this.gpermDescricao = gpermDescricao;
        this.gpermPermisoes = gpermPermisoes;
    }

    public Integer getGpermId() {
        return gpermId;
    }

    public void setGpermId(Integer gpermId) {
        this.gpermId = gpermId;
    }

    public String getGpermNome() {
        return gpermNome;
    }

    public void setGpermNome(String gpermNome) {
        this.gpermNome = gpermNome;
    }

    public String getGpermDescricao() {
        return gpermDescricao;
    }

    public void setGpermDescricao(String gpermDescricao) {
        this.gpermDescricao = gpermDescricao;
    }

    public String getGpermPermisoes() {
        return gpermPermisoes;
    }

    public void setGpermPermisoes(String gpermPermisoes) {
        this.gpermPermisoes = gpermPermisoes;
    }

    @XmlTransient
    public List<TbUsuario> getTbUsuarioList() {
        return tbUsuarioList;
    }

    public void setTbUsuarioList(List<TbUsuario> tbUsuarioList) {
        this.tbUsuarioList = tbUsuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gpermId != null ? gpermId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbGrupoPermissoes)) {
            return false;
        }
        TbGrupoPermissoes other = (TbGrupoPermissoes) object;
        if ((this.gpermId == null && other.gpermId != null) || (this.gpermId != null && !this.gpermId.equals(other.gpermId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "codemarket.model.pojo.TbGrupoPermissoes[ gpermId=" + gpermId + " ]";
    }
    
}
