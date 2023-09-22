package codemarket.model.dao;

import codemarket.model.pojo.TbVenda;
import java.util.List;

public interface VendaDAO {
    void salvar(TbVenda venda);
    void atualizar(TbVenda venda);
    void excluir(TbVenda venda);
    List<TbVenda> listarTodos();
    TbVenda listarUm(int id);    
}
