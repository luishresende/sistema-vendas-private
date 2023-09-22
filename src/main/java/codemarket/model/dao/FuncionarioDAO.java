/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codemarket.model.dao;

import codemarket.model.pojo.TbFuncionario;
import java.util.List;

/**
 *
 * @author kauan
 */
public interface FuncionarioDAO {
    void salvar(TbFuncionario funcionario);
    void atualizar(TbFuncionario funcionario);
    void excluir(TbFuncionario funcionario);
    List<TbFuncionario> listarTodos();
    TbFuncionario listarUm(int id);    
}
