/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codemarket.model.dao;

import codemarket.model.pojo.TbEntradaEstoque;
import java.util.List;

/**
 *
 * @author kauan
 */
public interface EntradaEstoqueDAO {
    void salvar(TbEntradaEstoque entradaestoque);
    void atualizar(TbEntradaEstoque entradaestoque);
    void excluir(TbEntradaEstoque entradaestoque);
    List<TbEntradaEstoque> listarTodos();
    TbEntradaEstoque listarUm(int id);    
}
