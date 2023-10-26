/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codemarket.model.vo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kauan
 */
@Entity
@Table(name = "tb_funcionario_has_almoxarifado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbFuncionarioHasAlmoxarifado.findAll", query = "SELECT t FROM TbFuncionarioHasAlmoxarifado t"),
    @NamedQuery(name = "TbFuncionarioHasAlmoxarifado.findByFuncId", query = "SELECT t FROM TbFuncionarioHasAlmoxarifado t WHERE t.tbFuncionarioHasAlmoxarifadoPK.funcId = :funcId"),
    @NamedQuery(name = "TbFuncionarioHasAlmoxarifado.findByAlmoId", query = "SELECT t FROM TbFuncionarioHasAlmoxarifado t WHERE t.tbFuncionarioHasAlmoxarifadoPK.almoId = :almoId"),
    @NamedQuery(name = "TbFuncionarioHasAlmoxarifado.findByIsPadrao", query = "SELECT t FROM TbFuncionarioHasAlmoxarifado t WHERE t.isPadrao = :isPadrao")})
public class TbFuncionarioHasAlmoxarifado implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TbFuncionarioHasAlmoxarifadoPK tbFuncionarioHasAlmoxarifadoPK;
    @Basic(optional = false)
    @Column(name = "isPadrao")
    private short isPadrao;
    @JoinColumn(name = "almo_id", referencedColumnName = "almo_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TbAlmoxarifado tbAlmoxarifado;
    @JoinColumn(name = "func_id", referencedColumnName = "func_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TbFuncionario tbFuncionario;

    public TbFuncionarioHasAlmoxarifado() {
    }

    public TbFuncionarioHasAlmoxarifado(short isPadrao, TbAlmoxarifado tbAlmoxarifado, TbFuncionario tbFuncionario) {
        this.isPadrao = isPadrao;
        this.tbAlmoxarifado = tbAlmoxarifado;
        this.tbFuncionario = tbFuncionario;
    }
    
    public short getIsPadrao() {
        return isPadrao;
    }

    public void setIsPadrao(short isPadrao) {
        this.isPadrao = isPadrao;
    }

    public TbAlmoxarifado getTbAlmoxarifado() {
        return tbAlmoxarifado;
    }

    public void setTbAlmoxarifado(TbAlmoxarifado tbAlmoxarifado) {
        this.tbAlmoxarifado = tbAlmoxarifado;
    }

    public TbFuncionario getTbFuncionario() {
        return tbFuncionario;
    }

    public void setTbFuncionario(TbFuncionario tbFuncionario) {
        this.tbFuncionario = tbFuncionario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tbFuncionarioHasAlmoxarifadoPK != null ? tbFuncionarioHasAlmoxarifadoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbFuncionarioHasAlmoxarifado)) {
            return false;
        }
        TbFuncionarioHasAlmoxarifado other = (TbFuncionarioHasAlmoxarifado) object;
        if ((this.tbFuncionarioHasAlmoxarifadoPK == null && other.tbFuncionarioHasAlmoxarifadoPK != null) || (this.tbFuncionarioHasAlmoxarifadoPK != null && !this.tbFuncionarioHasAlmoxarifadoPK.equals(other.tbFuncionarioHasAlmoxarifadoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "codemarket.model.vo.TbFuncionarioHasAlmoxarifado[ tbFuncionarioHasAlmoxarifadoPK=" + tbFuncionarioHasAlmoxarifadoPK + " ]";
    }
    
}
