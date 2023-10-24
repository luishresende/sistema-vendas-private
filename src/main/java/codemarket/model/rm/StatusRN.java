package codemarket.model.rm;
import codemarket.model.dao.StatusDAO;
import codemarket.model.dao.StatusDAOImpl;
import codemarket.model.pojo.TbStatus;

public class StatusRN {

    private StatusDAO genericDao;

    public StatusRN() {
        genericDao = new StatusDAOImpl();
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
