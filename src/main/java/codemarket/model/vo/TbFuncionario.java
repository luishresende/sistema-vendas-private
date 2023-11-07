/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codemarket.model.vo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author kauan
 */
@Entity
@Table(name = "tb_funcionario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbFuncionario.findAll", query = "SELECT t FROM TbFuncionario t"),
    @NamedQuery(name = "TbFuncionario.findByFuncId", query = "SELECT t FROM TbFuncionario t WHERE t.funcId = :funcId")})
public class TbFuncionario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "func_id")
    private Integer funcId;
    @ManyToMany(mappedBy = "tbFuncionarioCollection")
    private Collection<TbFilial> tbFilialCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbFuncionario")
    private Collection<TbFuncionarioHasAlmoxarifado> tbFuncionarioHasAlmoxarifadoCollection;
    @JoinColumn(name = "func_cargo", referencedColumnName = "car_id")
    @ManyToOne(optional = false)
    private TbCargo funcCargo;
    @JoinColumn(name = "func_ent_cpfCnpj", referencedColumnName = "ent_cpfCnpj")
    @ManyToOne(optional = false)
    private TbEntidade funcEntId;
    @JoinColumn(name = "func_filial_id", referencedColumnName = "fil_id")
    @ManyToOne(optional = false)
    private TbFilial funcFilialId;
    @JoinColumn(name = "func_status", referencedColumnName = "sta_id")
    @ManyToOne(optional = false)
    private TbStatus funcStatus;
    @JoinColumn(name = "func_usuario", referencedColumnName = "usu_usuario")
    @ManyToOne(optional = false)
    private TbUsuario funcUsuario;

    public TbFuncionario() {
    }

    public TbFuncionario(TbCargo funcCargo, TbEntidade funcEntId, TbFilial funcFilialId, TbStatus funcStatus, TbUsuario funcUsuario) {
        this.funcCargo = funcCargo;
        this.funcEntId = funcEntId;
        this.funcFilialId = funcFilialId;
        this.funcStatus = funcStatus;
        this.funcUsuario = funcUsuario;
    }

    public Integer getFuncId() {
        return funcId;
    }

    public void setFuncId(Integer funcId) {
        this.funcId = funcId;
    }

    @XmlTransient
    public Collection<TbFilial> getTbFilialCollection() {
        return tbFilialCollection;
    }

    public void setTbFilialCollection(Collection<TbFilial> tbFilialCollection) {
        this.tbFilialCollection = tbFilialCollection;
    }

    @XmlTransient
    public Collection<TbFuncionarioHasAlmoxarifado> getTbFuncionarioHasAlmoxarifadoCollection() {
        return tbFuncionarioHasAlmoxarifadoCollection;
    }

    public void setTbFuncionarioHasAlmoxarifadoCollection(Collection<TbFuncionarioHasAlmoxarifado> tbFuncionarioHasAlmoxarifadoCollection) {
        this.tbFuncionarioHasAlmoxarifadoCollection = tbFuncionarioHasAlmoxarifadoCollection;
    }

    public TbCargo getFuncCargo() {
        return funcCargo;
    }

    public void setFuncCargo(TbCargo funcCargo) {
        this.funcCargo = funcCargo;
    }

    public TbEntidade getFuncEntId() {
        return funcEntId;
    }

    public void setFuncEntId(TbEntidade funcEntId) {
        this.funcEntId = funcEntId;
    }

    public TbFilial getFuncFilialId() {
        return funcFilialId;
    }

    public void setFuncFilialId(TbFilial funcFilialId) {
        this.funcFilialId = funcFilialId;
    }

    public TbStatus getFuncStatus() {
        return funcStatus;
    }

    public void setFuncStatus(TbStatus funcStatus) {
        this.funcStatus = funcStatus;
    }

    public TbUsuario getFuncUsuario() {
        return funcUsuario;
    }

    public void setFuncUsuario(TbUsuario funcUsuario) {
        this.funcUsuario = funcUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (funcId != null ? funcId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbFuncionario)) {
            return false;
        }
        TbFuncionario other = (TbFuncionario) object;
        if ((this.funcId == null && other.funcId != null) || (this.funcId != null && !this.funcId.equals(other.funcId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "codemarket.model.vo.TbFuncionario[ funcId=" + funcId + " ]";
    }
    
}
