package codemarket.model.rn;
import codemarket.model.dao.GenericDAO;
import codemarket.model.vo.TbCategoriaProduto;

public class CategoriaProdutoRN {

    private GenericDAO<TbCategoriaProduto> genericDao;

    public CategoriaProdutoRN() {
        genericDao = new GenericDAO<>();
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
