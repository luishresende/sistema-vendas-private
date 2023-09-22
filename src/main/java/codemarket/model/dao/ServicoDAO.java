/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codemarket.model.dao;

import codemarket.model.pojo.TbServico;
import java.util.List;

/**
 *
 * @author kauan
 */
public interface ServicoDAO {
    void salvar(TbServico servico);
    void atualizar(TbServico servico);
    void excluir(TbServico servico);
    List<TbServico> listarTodos();
    TbServico listarUm(int id);   
}
