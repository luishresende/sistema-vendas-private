package codemarket.model.rm;
import codemarket.model.dao.CidEstDAO;
import codemarket.model.dao.CidEstDAOImpl;
import codemarket.model.pojo.TbCidEst;

public class CidEstRN {

    private CidEstDAO genericDao;

    public CidEstRN() {
        genericDao = new CidEstDAOImpl();
    }

    public void salvar(TbCidEst CidEst) {
        genericDao.salvar(CidEst);
    }

    public void atualizar(TbCidEst CidEst) {
        genericDao.atualizar(CidEst);
    }

    public void excluir(TbCidEst CidEst) {
        genericDao.excluir(CidEst);
    }
}
