package codemarket.model.rn;
import codemarket.model.dao.GenericDAO;
import codemarket.model.vo.TbEstoquePK;

public class EstoquePKRN {

    private GenericDAO<TbEstoquePK> genericDao;

    public EstoquePKRN() {
        genericDao = new GenericDAO<>();
    }

    public void salvar(TbEstoquePK EstoquePK) {
        genericDao.salvar(EstoquePK);
    }

    public void atualizar(TbEstoquePK EstoquePK) {
        genericDao.atualizar(EstoquePK);
    }

    public void excluir(TbEstoquePK EstoquePK) {
        genericDao.excluir(EstoquePK);
    }
}
