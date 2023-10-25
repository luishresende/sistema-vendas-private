package codemarket.model.rn;
import codemarket.model.dao.GenericDAO;
import codemarket.model.vo.TbEstado;
import java.util.List;;

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
    public List buscarTodos() {
        List<TbEstado> Estados = genericDao.listarTodos(TbEstado.class);
        return Estados;
    }
}
