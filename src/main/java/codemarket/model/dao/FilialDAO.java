/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codemarket.model.dao;

import codemarket.model.pojo.TbFilial;
import java.util.List;

/**
 *
 * @author kauan
 */
public interface FilialDAO {
    void salvar(TbFilial filial);
    void atualizar(TbFilial filial);
    void excluir(TbFilial filial);
    List<TbFilial> listarTodos();
    TbFilial listarUm(int id);    
}
