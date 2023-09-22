/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codemarket.model.dao;

import codemarket.model.pojo.TbEndPostal;
import java.util.List;

/**
 *
 * @author kauan
 */
public interface EndPostalDAO {
    void salvar(TbEndPostal endpostal);
    void atualizar(TbEndPostal endpostal);
    void excluir(TbEndPostal endpostal);
    List<TbEndPostal> listarTodos();
    TbEndPostal listarUm(int id);    
}
