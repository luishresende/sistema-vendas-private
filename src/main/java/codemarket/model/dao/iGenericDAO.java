/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codemarket.model.dao;

import java.util.List;

/**
 *
 * @author Iuri Pereira
 */
public interface iGenericDAO<Tabela> {
    public void salvar(Tabela objeto);
    public void excluir(Tabela objeto);
    public void atualizar(Tabela objeto);
    public List listarTodos(Class object, String coluna);
    public Tabela listarUm(String name, String value, Class classe);
}
