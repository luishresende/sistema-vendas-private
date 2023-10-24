package codemarket.model.rm;
import codemarket.model.dao.EstoqueDAO;
import codemarket.model.dao.EstoqueDAOImpl;
import codemarket.model.pojo.TbEstoque;

public class EstoqueRN {

    private EstoqueDAO genericDao;

    public EstoqueRN() {
        genericDao = new EstoqueDAOImpl();
    }

    public void salvar(TbEstoque Estoque) {
        genericDao.salvar(Estoque);
    }

    public void atualizar(TbEstoque Estoque) {
        genericDao.atualizar(Estoque);
    }

    public void excluir(TbEstoque Estoque) {
        genericDao.excluir(Estoque);
    }
}
