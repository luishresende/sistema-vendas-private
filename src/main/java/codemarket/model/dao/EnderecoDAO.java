/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codemarket.model.dao;

import codemarket.model.pojo.TbEndereco;
import java.util.List;

/**
 *
 * @author kauan
 */
public interface EnderecoDAO {
    void salvar(TbEndereco endereco);
    void atualizar(TbEndereco endereco);
    void excluir(TbEndereco endereco);
    List<TbEndereco> listarTodos();
    TbEndereco listarUm(int id);    
}
