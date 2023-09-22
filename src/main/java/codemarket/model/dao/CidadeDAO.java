/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codemarket.model.dao;

import codemarket.model.pojo.TbCidade;
import java.util.List;

/**
 *
 * @author kauan
 */
public interface CidadeDAO {
    void salvar(TbCidade cidade);
    void atualizar(TbCidade cidade);
    void excluir(TbCidade cidade);
    List<TbCidade> listarTodos();
    TbCidade listarUm(int id);    
}
