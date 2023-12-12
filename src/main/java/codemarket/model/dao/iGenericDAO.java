package codemarket.model.dao;

import java.util.List;


public interface iGenericDAO<Tabela> {
    public void salvar(Tabela objeto);
    public void excluir(Tabela objeto);
    public void atualizar(Tabela objeto);
    public List listarTodos(Class object, String coluna);
    public Tabela listarUm(String name, String value, Class classe);
    public List pesquisar(String jpql);
}
