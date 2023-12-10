/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codemarket.model.vo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author kauan
 */
@Entity
@Table(name = "tb_funcionario")
@NamedQueries({
    @NamedQuery(name = "TbFuncionario.findAll", query = "SELECT t FROM TbFuncionario t")})
public class TbFuncionario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "func_id")
    private Integer funcId;
    @JoinColumn(name = "func_cargo", referencedColumnName = "car_id")
    @ManyToOne(optional = false)
    private TbCargo funcCargo;
    @JoinColumn(name = "func_ent_cpfCnpj", referencedColumnName = "ent_cpfCnpj")
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, optional = false)
    private TbEntidade funcentcpfCnpj;
    @JoinColumn(name = "func_status", referencedColumnName = "sta_id")
    @ManyToOne(optional = false)
    private TbStatus funcStatus;
    @JoinColumn(name = "func_usuario", referencedColumnName = "usu_usuario")
    @ManyToOne(cascade = CascadeType.ALL)
    private TbUsuario funcUsuario;

    public TbFuncionario() {
    }

    public TbFuncionario(TbEntidade cpf, TbUsuario usuario, TbCargo cargo, TbStatus status) {
        this.funcentcpfCnpj = cpf;
        this.funcUsuario = usuario;
        this.funcCargo = cargo;
        this.funcStatus = status;
    }

    public Integer getFuncId() {
        return funcId;
    }

    public void setFuncId(Integer funcId) {
        this.funcId = funcId;
    }

    public TbCargo getFuncCargo() {
        return funcCargo;
    }

    public void setFuncCargo(TbCargo funcCargo) {
        this.funcCargo = funcCargo;
    }

    public TbEntidade getFuncentcpfCnpj() {
        return funcentcpfCnpj;
    }

    public void setFuncentcpfCnpj(TbEntidade funcentcpfCnpj) {
        this.funcentcpfCnpj = funcentcpfCnpj;
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
