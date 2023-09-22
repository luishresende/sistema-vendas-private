/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codemarket.model.dao;

import codemarket.model.pojo.TbLogradouro;
import java.util.List;

/**
 *
 * @author kauan
 */
public interface LogradouroDAO {
    void salvar(TbLogradouro logradouro);
    void atualizar(TbLogradouro logradouro);
    void excluir(TbLogradouro logradouro);
    List<TbLogradouro> listarTodos();
    TbLogradouro listarUm(int id);    
}
