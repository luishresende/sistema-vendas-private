/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codemarket.model.dao;

import codemarket.model.pojo.TbEntrada;
import java.util.List;

/**
 *
 * @author kauan
 */
public interface EntradaDAO {
    void salvar(TbEntrada entrada);
    void atualizar(TbEntrada entrada);
    void excluir(TbEntrada entrada);
    List<TbEntrada> listarTodos();
    TbEntrada listarUm(int id);    
}
