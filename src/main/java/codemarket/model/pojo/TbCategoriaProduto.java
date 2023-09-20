package codemarket.model.pojo;
// Generated 20/09/2023 14:26:58 by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * TbCategoriaProduto generated by hbm2java
 */
public class TbCategoriaProduto  implements java.io.Serializable {


     private int catpId;
     private String catpDescricao;
     private Set tbProdutos = new HashSet(0);

    public TbCategoriaProduto() {
    }

	
    public TbCategoriaProduto(int catpId, String catpDescricao) {
        this.catpId = catpId;
        this.catpDescricao = catpDescricao;
    }
    public TbCategoriaProduto(int catpId, String catpDescricao, Set tbProdutos) {
       this.catpId = catpId;
       this.catpDescricao = catpDescricao;
       this.tbProdutos = tbProdutos;
    }
   
    public int getCatpId() {
        return this.catpId;
    }
    
    public void setCatpId(int catpId) {
        this.catpId = catpId;
    }
    public String getCatpDescricao() {
        return this.catpDescricao;
    }
    
    public void setCatpDescricao(String catpDescricao) {
        this.catpDescricao = catpDescricao;
    }
    public Set getTbProdutos() {
        return this.tbProdutos;
    }
    
    public void setTbProdutos(Set tbProdutos) {
        this.tbProdutos = tbProdutos;
    }




}


