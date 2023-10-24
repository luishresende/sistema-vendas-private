package codemarket.model.rm;
import codemarket.model.dao.ProdutoDAO;
import codemarket.model.dao.ProdutoDAOImpl;
import codemarket.model.pojo.TbProduto;

public class ProdutoRN {

    private ProdutoDAO genericDao;

    public ProdutoRN() {
        genericDao = new ProdutoDAOImpl();
    }

    public void salvar(TbProduto Produto) {
        genericDao.salvar(Produto);
    }

    public void atualizar(TbProduto Produto) {
        genericDao.atualizar(Produto);
    }

    public void excluir(TbProduto Produto) {
        genericDao.excluir(Produto);
    }
}
