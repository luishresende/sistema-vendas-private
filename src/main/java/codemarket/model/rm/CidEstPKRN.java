package codemarket.model.rm;
import codemarket.model.dao.CidEstPKDAO;
import codemarket.model.dao.CidEstPKDAOImpl;
import codemarket.model.pojo.TbCidEstPK;

public class CidEstPKRN {

    private CidEstPKDAO genericDao;

    public CidEstPKRN() {
        genericDao = new CidEstPKDAOImpl();
    }

    public void salvar(TbCidEstPK CidEstPK) {
        genericDao.salvar(CidEstPK);
    }

    public void atualizar(TbCidEstPK CidEstPK) {
        genericDao.atualizar(CidEstPK);
    }

    public void excluir(TbCidEstPK CidEstPK) {
        genericDao.excluir(CidEstPK);
    }
}
