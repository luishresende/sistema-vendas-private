/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codemarket.model.dao;

import codemarket.model.pojo.TbAlmoxarifadoHasEstoque;
import java.util.List;

/**
 *
 * @author kauan
 */
public interface AlmoxarifadoHasEstoqueDAO {
    void salvar(TbAlmoxarifadoHasEstoque almoxarifadohasestoque);
    void atualizar(TbAlmoxarifadoHasEstoque almoxarifadohasestoque);
    void excluir(TbAlmoxarifadoHasEstoque almoxarifadohasestoque);
    List<TbAlmoxarifadoHasEstoque> listarTodos();
    TbAlmoxarifadoHasEstoque listarUm(int id);   
}
