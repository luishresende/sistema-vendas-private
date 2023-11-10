/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codemarket.model.dao;

import codemarket.model.conexao.HibernateConnection;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import org.hibernate.HibernateException;

/**
 *
 * @author Iuri Pereira
 */
public class GenericDAO<Tabela> implements iGenericDAO<Tabela> {

    EntityManager manager = HibernateConnection.getInstance();

    public void commit() {
        manager.getTransaction().commit();
    }

    @Override
    public void salvar(Tabela objeto) {
        manager.getTransaction().begin();
        try {
            manager.persist(objeto);
        } catch (RuntimeException e) {
            manager.getTransaction().rollback();
        }
        manager.getTransaction().commit();
        System.out.println("Salvo com sucesso!!");
    }

    @Override
    public void atualizar(Tabela objeto) {
        manager.getTransaction().begin();
        manager.merge(objeto);
        manager.getTransaction().commit();
    }

    @Override
    public void excluir(Tabela objeto) {
        manager.getTransaction().begin();
        manager.remove(objeto);
        manager.getTransaction().commit();
    }

    @Override
    public List listarTodos(Class classe, String coluna) {
        String jpql = " SELECT t." + coluna + " FROM " + classe.getTypeName() + " t";
        Query query = manager.createQuery(jpql);
        List<Tabela> objeto = query.getResultList();
        return objeto;
    }

    @Override
    public Tabela listarUm(String name, String value, Class classe) {
        String jpql = " SELECT t FROM " + classe.getTypeName() + " t WHERE t." + name + " = '" + value + "'";
        Query query = manager.createQuery(jpql);
        Object obj = query.getSingleResult();
        return (Tabela) obj;
    }

    @Override
    public List pesquisar(String jpql) {
        Query query = manager.createQuery(jpql);
        List<Tabela> objeto = query.getResultList();
        return objeto;
    }
}
