package codemarket.model.rm;
import codemarket.model.dao.EstoquePKDAO;
import codemarket.model.dao.EstoquePKDAOImpl;
import codemarket.model.pojo.TbEstoquePK;

public class EstoquePKRN {

    private EstoquePKDAO genericDao;

    public EstoquePKRN() {
        genericDao = new EstoquePKDAOImpl();
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
