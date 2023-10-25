package codemarket.model.rn;
import codemarket.model.dao.GenericDAO;
import codemarket.model.vo.TbEstoque;

public class EstoqueRN {

    private GenericDAO<TbEstoque> genericDao;

    public EstoqueRN() {
        genericDao = new GenericDAO<>();
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
