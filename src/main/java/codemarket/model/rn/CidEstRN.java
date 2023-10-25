package codemarket.model.rn;
import codemarket.model.dao.GenericDAO;
import codemarket.model.vo.TbCidEst;

public class CidEstRN {

    private GenericDAO<TbCidEst> genericDao;

    public CidEstRN() {
        genericDao = new GenericDAO<>();
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
