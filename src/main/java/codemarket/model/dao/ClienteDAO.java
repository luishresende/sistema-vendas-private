/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codemarket.model.dao;

import codemarket.model.pojo.TbCliente;
import java.util.List;

/**
 *
 * @author kauan
 */
public interface ClienteDAO {
    void salvar(TbCliente cliente);
    void atualizar(TbCliente cliente);
    void excluir(TbCliente cliente);
    List<TbCliente> listarTodos();
    TbCliente listarUm(int id);    
}
