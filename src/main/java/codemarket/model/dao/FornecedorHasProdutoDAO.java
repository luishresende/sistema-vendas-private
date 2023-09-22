/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codemarket.model.dao;

import codemarket.model.pojo.TbFornecedorHasProduto;
import java.util.List;

/**
 *
 * @author kauan
 */
public interface FornecedorHasProdutoDAO {
    void salvar(TbFornecedorHasProduto fornecedorhasproduto);
    void atualizar(TbFornecedorHasProduto fornecedorhasproduto);
    void excluir(TbFornecedorHasProduto fornecedorhasproduto);
    List<TbFornecedorHasProduto> listarTodos();
    TbFornecedorHasProduto listarUm(int id);    
}
