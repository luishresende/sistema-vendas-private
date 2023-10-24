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
@Table(name = "tb_cargo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbCargo.findAll", query = "SELECT t FROM TbCargo t")})
public class TbCargo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "car_id")
    private Integer carId;
    @Basic(optional = false)
    @Column(name = "car_descricao")
    private String carDescricao;
    @Basic(optional = false)
    @Column(name = "car_salarioBase")
    private double carsalarioBase;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "funcCargo")
    private List<TbFuncionario> tbFuncionarioList;

    public TbCargo() {
    }

    public TbCargo(Integer carId) {
        this.carId = carId;
    }

    public TbCargo(Integer carId, String carDescricao, double carsalarioBase) {
        this.carId = carId;
        this.carDescricao = carDescricao;
        this.carsalarioBase = carsalarioBase;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getCarDescricao() {
        return carDescricao;
    }

    public void setCarDescricao(String carDescricao) {
        this.carDescricao = carDescricao;
    }

    public double getCarsalarioBase() {
        return carsalarioBase;
    }

    public void setCarsalarioBase(double carsalarioBase) {
        this.carsalarioBase = carsalarioBase;
    }

    @XmlTransient
    public List<TbFuncionario> getTbFuncionarioList() {
        return tbFuncionarioList;
    }

    public void setTbFuncionarioList(List<TbFuncionario> tbFuncionarioList) {
        this.tbFuncionarioList = tbFuncionarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (carId != null ? carId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbCargo)) {
            return false;
        }
        TbCargo other = (TbCargo) object;
        if ((this.carId == null && other.carId != null) || (this.carId != null && !this.carId.equals(other.carId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "codemarket.model.pojo.TbCargo[ carId=" + carId + " ]";
    }
    
}
