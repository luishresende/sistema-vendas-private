/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codemarket.model.pojo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Luis Resende
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
    @ManyToMany(mappedBy = "tbFuncionarioList")
    private List<TbAlmoxarifado> tbAlmoxarifadoList;
    @ManyToMany(mappedBy = "tbFuncionarioList")
    private List<TbFilial> tbFilialList;
    @JoinColumn(name = "func_status_almo", referencedColumnName = "almo_id")
    @ManyToOne(optional = false)
    private TbAlmoxarifado funcStatus;
    @JoinColumn(name = "func_cargo", referencedColumnName = "car_id")
    @ManyToOne(optional = false)
    private TbCargo funcCargo;
    @JoinColumn(name = "func_ent_id", referencedColumnName = "ent_cpfCnpj")
    @ManyToOne(optional = false)
    private TbEntidade funcEntId;
    @JoinColumn(name = "func_filial_id", referencedColumnName = "fil_id")
    @ManyToOne(optional = false)
    private TbFilial funcFilialId;
    @JoinColumn(name = "func_status_sta", referencedColumnName = "sta_id")
    @ManyToOne(optional = false)
    private TbStatus funcStatus1;
    @JoinColumn(name = "func_usuario", referencedColumnName = "usu_usuario")
    @ManyToOne(optional = false)
    private TbUsuario funcUsuario;

    public TbFuncionario() {
    }

    public TbFuncionario(Integer funcId) {
        this.funcId = funcId;
    }

    public Integer getFuncId() {
        return funcId;
    }

    public void setFuncId(Integer funcId) {
        this.funcId = funcId;
    }

    @XmlTransient
    public List<TbAlmoxarifado> getTbAlmoxarifadoList() {
        return tbAlmoxarifadoList;
    }

    public void setTbAlmoxarifadoList(List<TbAlmoxarifado> tbAlmoxarifadoList) {
        this.tbAlmoxarifadoList = tbAlmoxarifadoList;
    }

    @XmlTransient
    public List<TbFilial> getTbFilialList() {
        return tbFilialList;
    }

    public void setTbFilialList(List<TbFilial> tbFilialList) {
        this.tbFilialList = tbFilialList;
    }

    public TbAlmoxarifado getFuncStatus() {
        return funcStatus;
    }

    public void setFuncStatus(TbAlmoxarifado funcStatus) {
        this.funcStatus = funcStatus;
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

    public TbStatus getFuncStatus1() {
        return funcStatus1;
    }

    public void setFuncStatus1(TbStatus funcStatus1) {
        this.funcStatus1 = funcStatus1;
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
        return "codemarket.model.pojo.TbFuncionario[ funcId=" + funcId + " ]";
    }
    
}
