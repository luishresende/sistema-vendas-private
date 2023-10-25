package codemarket.model.rn;
import codemarket.model.dao.GenericDAO;
import codemarket.model.vo.TbEstado;

public class EstadoRN {

    private GenericDAO<TbEstado> genericDao;

    public EstadoRN() {
        genericDao = new GenericDAO<>();
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
