/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codemarket.model.dao;

import codemarket.model.pojo.TbStatus;
import java.util.List;

/**
 *
 * @author kauan
 */
public interface StatusDAO {
    void salvar(TbStatus status);
    void atualizar(TbStatus status);
    void excluir(TbStatus status);
    List<TbStatus> listarTodos();
    TbStatus listarUm(int id);    
}
