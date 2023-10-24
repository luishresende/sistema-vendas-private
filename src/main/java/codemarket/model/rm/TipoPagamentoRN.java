package codemarket.model.rm;
import codemarket.model.dao.TipoPagamentoDAO;
import codemarket.model.dao.TipoPagamentoDAOImpl;
import codemarket.model.pojo.TbTipoPagamento;

public class TipoPagamentoRN {

    private TipoPagamentoDAO genericDao;

    public TipoPagamentoRN() {
        genericDao = new TipoPagamentoDAOImpl();
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
}
