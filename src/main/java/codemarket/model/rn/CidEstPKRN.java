package codemarket.model.rn;
import codemarket.model.dao.GenericDAO;
import codemarket.model.vo.TbCidEstPK;

public class CidEstPKRN {

    private GenericDAO<TbCidEstPK> genericDao;

    public CidEstPKRN() {
        genericDao = new GenericDAO<>();
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
