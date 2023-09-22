/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codemarket.model.dao;

import codemarket.model.pojo.TbPedido;
import java.util.List;

/**
 *
 * @author kauan
 */
public interface PedidoDAO {
    void salvar(TbPedido pedido);
    void atualizar(TbPedido pedido);
    void excluir(TbPedido pedido);
    List<TbPedido> listarTodos();
    TbPedido listarUm(int id);    
}
