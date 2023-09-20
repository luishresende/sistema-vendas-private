package codemarket.model.pojo;
// Generated 20/09/2023 14:26:58 by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * TbCliente generated by hbm2java
 */
public class TbCliente  implements java.io.Serializable {


     private int cliId;
     private TbEntidade tbEntidade;
     private Set tbVendas = new HashSet(0);

    public TbCliente() {
    }

	
    public TbCliente(int cliId, TbEntidade tbEntidade) {
        this.cliId = cliId;
        this.tbEntidade = tbEntidade;
    }
    public TbCliente(int cliId, TbEntidade tbEntidade, Set tbVendas) {
       this.cliId = cliId;
       this.tbEntidade = tbEntidade;
       this.tbVendas = tbVendas;
    }
   
    public int getCliId() {
        return this.cliId;
    }
    
    public void setCliId(int cliId) {
        this.cliId = cliId;
    }
    public TbEntidade getTbEntidade() {
        return this.tbEntidade;
    }
    
    public void setTbEntidade(TbEntidade tbEntidade) {
        this.tbEntidade = tbEntidade;
    }
    public Set getTbVendas() {
        return this.tbVendas;
    }
    
    public void setTbVendas(Set tbVendas) {
        this.tbVendas = tbVendas;
    }




}


