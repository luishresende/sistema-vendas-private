package codemarket.model.dao;

import codemarket.model.pojo.TbTipoPagamento;
import java.util.List;

public interface TipoPagamentoDAO {
    void salvar(TbTipoPagamento tipopagamento);
    void atualizar(TbTipoPagamento tipopagamento);
    void excluir(TbTipoPagamento tipopagamento);
    List<TbTipoPagamento> listarTodos();
    TbTipoPagamento listarUm(int id);    
}
