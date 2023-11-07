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
    public List buscarTodos(String coluna) {
        List<TbTipoPagamento> TipoPagamentos = genericDao.listarTodos(TbTipoPagamento.class, coluna);
        return TipoPagamentos;
    }
    public TbTipoPagamento listaUm(String pesquisa, String valor, Class classe) {
        String jpql = "SELECT t FROM " + classe.getTypeName() + "t where t." + pesquisa + " = '" + valor + "'";
        TbTipoPagamento obj = genericDao.listarUm(pesquisa, valor, classe);
        return obj;
    }
    public List pesquisar(String jpql) {
        List obj = genericDao.pesquisar(jpql);
        return obj;
    }
}
