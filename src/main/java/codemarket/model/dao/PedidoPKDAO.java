/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codemarket.model.dao;

import codemarket.model.pojo.TbPedidoPK;
import java.util.List;

/**
 *
 * @author kauan
 */
public interface PedidoPKDAO {
    void salvar(TbPedidoPK pedidopk);
    void atualizar(TbPedidoPK pedidopk);
    void excluir(TbPedidoPK pedidopk);
    List<TbPedidoPK> listarTodos();
    TbPedidoPK listarUm(int id);    
}
