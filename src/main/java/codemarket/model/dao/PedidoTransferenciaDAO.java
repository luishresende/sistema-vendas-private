/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codemarket.model.dao;

import codemarket.model.pojo.TbPedidoTransferencia;
import java.util.List;

/**
 *
 * @author kauan
 */
public interface PedidoTransferenciaDAO {
    void salvar(TbPedidoTransferencia pedidotransferencia);
    void atualizar(TbPedidoTransferencia pedidotransferencia);
    void excluir(TbPedidoTransferencia pedidotransferencia);
    List<TbPedidoTransferencia> listarTodos();
    TbPedidoTransferencia listarUm(int id);    
}
