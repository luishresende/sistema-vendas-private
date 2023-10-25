package codemarket.model.rn;
import codemarket.model.dao.GenericDAO;
import codemarket.model.vo.TbTipoPagamento;
import java.util.List;;

public class TipoPagamentoRN {

    private GenericDAO<TbTipoPagamento> genericDao;

    public TipoPagamentoRN() {
        genericDao = new GenericDAO<>();
    }

    public void salvar(TbTipoPagamento TipoPagamento) {
        genericDao.salvar(TipoPagamento);
    }

    public void atualizar(TbTipoPagamento TipoPagamento) {
        genericDao.atualizar(TipoPagamento);
    }

    public void excluir(TbTipoPagamento TipoPagamento) {
        genericDao.excluir(TipoPagamento);
    }
    public List buscarTodos() {
        List<TbTipoPagamento> TipoPagamentos = genericDao.listarTodos(TbTipoPagamento.class);
        return TipoPagamentos;
    }
}
