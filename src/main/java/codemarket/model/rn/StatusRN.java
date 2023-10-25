package codemarket.model.rn;
import codemarket.model.dao.GenericDAO;
import codemarket.model.vo.TbStatus;

public class StatusRN {

    private GenericDAO<TbStatus> genericDao;

    public StatusRN() {
        genericDao = new GenericDAO<>();
    }

    public void salvar(TbStatus Status) {
        genericDao.salvar(Status);
    }

    public void atualizar(TbStatus Status) {
        genericDao.atualizar(Status);
    }

    public void excluir(TbStatus Status) {
        genericDao.excluir(Status);
    }
}
