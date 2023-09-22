/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codemarket.model.dao;

import codemarket.model.pojo.TbFornecedorHasProdutoPK;
import java.util.List;

/**
 *
 * @author kauan
 */
public interface FornecedorHasProdutoPKDAO {
    void salvar(TbFornecedorHasProdutoPK fornecedorhasprodutopk);
    void atualizar(TbFornecedorHasProdutoPK fornecedorhasprodutopk);
    void excluir(TbFornecedorHasProdutoPK fornecedorhasprodutopk);
    List<TbFornecedorHasProdutoPK> listarTodos();
    TbFornecedorHasProdutoPK listarUm(int id);    
}
