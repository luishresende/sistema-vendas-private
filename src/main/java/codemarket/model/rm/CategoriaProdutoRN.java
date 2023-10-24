package codemarket.model.rm;
import codemarket.model.dao.CategoriaProdutoDAO;
import codemarket.model.dao.CategoriaProdutoDAOImpl;
import codemarket.model.pojo.TbCategoriaProduto;

public class CategoriaProdutoRN {

    private CategoriaProdutoDAO genericDao;

    public CategoriaProdutoRN() {
        genericDao = new CategoriaProdutoDAOImpl();
    }

    public void salvar(TbCategoriaProduto CategoriaProduto) {
        genericDao.salvar(CategoriaProduto);
    }

    public void atualizar(TbCategoriaProduto CategoriaProduto) {
        genericDao.atualizar(CategoriaProduto);
    }

    public void excluir(TbCategoriaProduto CategoriaProduto) {
        genericDao.excluir(CategoriaProduto);
    }
}
