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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Luis Resende
 */
@Entity
@Table(name = "tb_almoxarifado_has_estoque")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbAlmoxarifadoHasEstoque.findAll", query = "SELECT t FROM TbAlmoxarifadoHasEstoque t")})
public class TbAlmoxarifadoHasEstoque implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "almo_id")
    private Integer almoId;
    @Basic(optional = false)
    @Column(name = "esto_id")
    private int estoId;
    @Column(name = "tb_almoxarifado_has_estoquecol")
    private String tbAlmoxarifadoHasEstoquecol;
    @JoinColumn(name = "almo_id", referencedColumnName = "almo_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private TbAlmoxarifado tbAlmoxarifado;

    public TbAlmoxarifadoHasEstoque() {
    }

    public TbAlmoxarifadoHasEstoque(Integer almoId) {
        this.almoId = almoId;
    }

    public TbAlmoxarifadoHasEstoque(Integer almoId, int estoId) {
        this.almoId = almoId;
        this.estoId = estoId;
    }

    public Integer getAlmoId() {
        return almoId;
    }

    public void setAlmoId(Integer almoId) {
        this.almoId = almoId;
    }

    public int getEstoId() {
        return estoId;
    }

    public void setEstoId(int estoId) {
        this.estoId = estoId;
    }

    public String getTbAlmoxarifadoHasEstoquecol() {
        return tbAlmoxarifadoHasEstoquecol;
    }

    public void setTbAlmoxarifadoHasEstoquecol(String tbAlmoxarifadoHasEstoquecol) {
        this.tbAlmoxarifadoHasEstoquecol = tbAlmoxarifadoHasEstoquecol;
    }

    public TbAlmoxarifado getTbAlmoxarifado() {
        return tbAlmoxarifado;
    }

    public void setTbAlmoxarifado(TbAlmoxarifado tbAlmoxarifado) {
        this.tbAlmoxarifado = tbAlmoxarifado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (almoId != null ? almoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbAlmoxarifadoHasEstoque)) {
            return false;
        }
        TbAlmoxarifadoHasEstoque other = (TbAlmoxarifadoHasEstoque) object;
        if ((this.almoId == null && other.almoId != null) || (this.almoId != null && !this.almoId.equals(other.almoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "codemarket.model.pojo.TbAlmoxarifadoHasEstoque[ almoId=" + almoId + " ]";
    }
    
}
