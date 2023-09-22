/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codemarket.model.dao;

import codemarket.model.pojo.TbSexo;
import java.util.List;

/**
 *
 * @author kauan
 */
public interface SexoDAO {
    void salvar(TbSexo sexo);
    void atualizar(TbSexo sexo);
    void excluir(TbSexo sexo);
    List<TbSexo> listarTodos();
    TbSexo listarUm(int id);    
}
