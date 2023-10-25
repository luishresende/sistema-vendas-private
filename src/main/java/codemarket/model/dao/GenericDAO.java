/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codemarket.model.dao;

import codemarket.model.conexao.ConexaoHibernate;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Iuri Pereira
 */
public class GenericDAO<Tabela> implements iGenericDAO<Tabela> {
    
    EntityManager manager = ConexaoHibernate.getInstance();
    
    public void commit(){
        manager.getTransaction().commit();
    }
    
    @Override
    public void salvar(Tabela objeto) {
        manager.getTransaction().begin();
        manager.persist(objeto);
        manager.getTransaction().commit();
        System.out.println("Salvo com sucesso!!");
    }

    @Override
    public void atualizar(Tabela objeto) {
        manager.getTransaction().begin();
        manager.merge(objeto);
        manager.getTransaction().commit();    }

    @Override
    public void excluir(Tabela objeto) {
        manager.getTransaction().begin();
        manager.remove(objeto);
        manager.getTransaction().commit();    }
    
    @Override
    public List listarTodos(Class classe) {
        String jpql = " SELECT t FROM " + classe.getTypeName() + " t";
        Query query = manager.createQuery(jpql);
        List<Tabela> objeto = query.getResultList();
        return objeto;    
    }

    @Override
    public Tabela listarUm(String name, int value, Class classe) {
        String jpql = " SELECT t FROM " + classe.getTypeName() + " t WHERE t." + name + " = " + value;
        Query query = manager.createQuery (jpql);
        Object obj = query.getSingleResult();
        return (Tabela) obj;    
    }
}
