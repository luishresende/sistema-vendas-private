/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codemarket.model.dao;

import codemarket.model.pojo.TbCategoriaProduto;
import java.util.List;

/**
 *
 * @author kauan
 */
public interface CategoriaProdutoDAO {
    void salvar(TbCategoriaProduto categoriaproduto);
    void atualizar(TbCategoriaProduto categoriaproduto);
    void excluir(TbCategoriaProduto categoriaproduto);
    List<TbCategoriaProduto> listarTodos();
    TbCategoriaProduto listarUm(int id);    
}
