/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codemarket.model.dao;

import codemarket.model.pojo.TbProduto;
import java.util.List;

/**
 *
 * @author kauan
 */
public interface ProdutoDAO {
    void salvar(TbProduto produto);
    void atualizar(TbProduto produto);
    void excluir(TbProduto produto);
    List<TbProduto> listarTodos();
    TbProduto listarUm(int id);
}
