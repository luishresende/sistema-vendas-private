package codemarket.model.rn;
import codemarket.model.dao.GenericDAO;
import codemarket.model.vo.TbProduto;

public class ProdutoRN {

    private GenericDAO<TbProduto> genericDao;

    public ProdutoRN() {
        genericDao = new GenericDAO<>();
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
