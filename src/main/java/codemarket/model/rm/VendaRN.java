package codemarket.model.rm;
import codemarket.model.dao.VendaDAO;
import codemarket.model.dao.VendaDAOImpl;
import codemarket.model.pojo.TbVenda;

public class VendaRN {

    private VendaDAO genericDao;

    public VendaRN() {
        genericDao = new VendaDAOImpl();
    }

    public void salvar(TbVenda Venda) {
        genericDao.salvar(Venda);
    }

    public void atualizar(TbVenda Venda) {
        genericDao.atualizar(Venda);
    }

    public void excluir(TbVenda Venda) {
        genericDao.excluir(Venda);
    }
}
