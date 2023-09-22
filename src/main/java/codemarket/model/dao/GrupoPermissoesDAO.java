/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codemarket.model.dao;

import codemarket.model.pojo.TbGrupoPermissoes;
import java.util.List;

/**
 *
 * @author kauan
 */
public interface GrupoPermissoesDAO {
    void salvar(TbGrupoPermissoes grupopermissoes);
    void atualizar(TbGrupoPermissoes grupopermissoes);
    void excluir(TbGrupoPermissoes grupopermissoes);
    List<TbGrupoPermissoes> listarTodos();
    TbGrupoPermissoes listarUm(int id);    
}
