package codemarket.model.rm;
import codemarket.model.dao.EstadoDAO;
import codemarket.model.dao.EstadoDAOImpl;
import codemarket.model.pojo.TbEstado;

public class EstadoRN {

    private EstadoDAO genericDao;

    public EstadoRN() {
        genericDao = new EstadoDAOImpl();
    }

    public void salvar(TbEstado Estado) {
        genericDao.salvar(Estado);
    }

    public void atualizar(TbEstado Estado) {
        genericDao.atualizar(Estado);
    }

    public void excluir(TbEstado Estado) {
        genericDao.excluir(Estado);
    }
}
