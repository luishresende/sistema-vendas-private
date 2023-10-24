package codemarket.model.rm;
import codemarket.model.dao.EntradaEstoqueDAO;
import codemarket.model.dao.EntradaEstoqueDAOImpl;
import codemarket.model.pojo.TbEntradaEstoque;

public class EntradaEstoqueRN {

    private EntradaEstoqueDAO genericDao;

    public EntradaEstoqueRN() {
        genericDao = new EntradaEstoqueDAOImpl();
    }

    public void salvar(TbEntradaEstoque EntradaEstoque) {
        genericDao.salvar(EntradaEstoque);
    }

    public void atualizar(TbEntradaEstoque EntradaEstoque) {
        genericDao.atualizar(EntradaEstoque);
    }

    public void excluir(TbEntradaEstoque EntradaEstoque) {
        genericDao.excluir(EntradaEstoque);
    }
}
