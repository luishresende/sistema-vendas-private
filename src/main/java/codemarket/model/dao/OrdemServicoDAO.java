/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codemarket.model.dao;

import codemarket.model.pojo.TbOrdemServico;
import java.util.List;

/**
 *
 * @author kauan
 */
public interface OrdemServicoDAO {
    void salvar(TbOrdemServico ordemservico);
    void atualizar(TbOrdemServico ordemservico);
    void excluir(TbOrdemServico ordemservico);
    List<TbOrdemServico> listarTodos();
    TbOrdemServico listarUm(int id);    
}
