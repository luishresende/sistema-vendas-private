/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codemarket.model.dao;

import codemarket.model.pojo.TbPais;
import java.util.List;

/**
 *
 * @author kauan
 */
public interface PaisDAO {
    void salvar(TbPais pais);
    void atualizar(TbPais pais);
    void excluir(TbPais pais);
    List<TbPais> listarTodos();
    TbPais listarUm(int id);    
}
