package codemarket.model.pojo;
// Generated 20/09/2023 14:26:58 by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * TbPais generated by hbm2java
 */
public class TbPais  implements java.io.Serializable {


     private String paiSigla;
     private String paiDescricao;
     private Set tbCidEsts = new HashSet(0);

    public TbPais() {
    }

	
    public TbPais(String paiSigla, String paiDescricao) {
        this.paiSigla = paiSigla;
        this.paiDescricao = paiDescricao;
    }
    public TbPais(String paiSigla, String paiDescricao, Set tbCidEsts) {
       this.paiSigla = paiSigla;
       this.paiDescricao = paiDescricao;
       this.tbCidEsts = tbCidEsts;
    }
   
    public String getPaiSigla() {
        return this.paiSigla;
    }
    
    public void setPaiSigla(String paiSigla) {
        this.paiSigla = paiSigla;
    }
    public String getPaiDescricao() {
        return this.paiDescricao;
    }
    
    public void setPaiDescricao(String paiDescricao) {
        this.paiDescricao = paiDescricao;
    }
    public Set getTbCidEsts() {
        return this.tbCidEsts;
    }
    
    public void setTbCidEsts(Set tbCidEsts) {
        this.tbCidEsts = tbCidEsts;
    }




}


