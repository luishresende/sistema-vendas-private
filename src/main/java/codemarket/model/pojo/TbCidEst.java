package codemarket.model.pojo;
// Generated 20/09/2023 14:26:58 by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * TbCidEst generated by hbm2java
 */
public class TbCidEst  implements java.io.Serializable {


     private TbCidEstId id;
     private TbEstado tbEstado;
     private TbCidade tbCidade;
     private TbPais tbPais;
     private Set tbEndPostals = new HashSet(0);

    public TbCidEst() {
    }

	
    public TbCidEst(TbCidEstId id, TbEstado tbEstado, TbCidade tbCidade, TbPais tbPais) {
        this.id = id;
        this.tbEstado = tbEstado;
        this.tbCidade = tbCidade;
        this.tbPais = tbPais;
    }
    public TbCidEst(TbCidEstId id, TbEstado tbEstado, TbCidade tbCidade, TbPais tbPais, Set tbEndPostals) {
       this.id = id;
       this.tbEstado = tbEstado;
       this.tbCidade = tbCidade;
       this.tbPais = tbPais;
       this.tbEndPostals = tbEndPostals;
    }
   
    public TbCidEstId getId() {
        return this.id;
    }
    
    public void setId(TbCidEstId id) {
        this.id = id;
    }
    public TbEstado getTbEstado() {
        return this.tbEstado;
    }
    
    public void setTbEstado(TbEstado tbEstado) {
        this.tbEstado = tbEstado;
    }
    public TbCidade getTbCidade() {
        return this.tbCidade;
    }
    
    public void setTbCidade(TbCidade tbCidade) {
        this.tbCidade = tbCidade;
    }
    public TbPais getTbPais() {
        return this.tbPais;
    }
    
    public void setTbPais(TbPais tbPais) {
        this.tbPais = tbPais;
    }
    public Set getTbEndPostals() {
        return this.tbEndPostals;
    }
    
    public void setTbEndPostals(Set tbEndPostals) {
        this.tbEndPostals = tbEndPostals;
    }




}


