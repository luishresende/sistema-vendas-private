package codemarket.model.rn;
import codemarket.model.dao.GenericDAO;
import codemarket.model.vo.TbUnidadeMedida;
import java.util.List;;

public class UnidadeMedidaRN {

    private GenericDAO<TbUnidadeMedida> genericDao;

    public UnidadeMedidaRN() {
        genericDao = new GenericDAO<>();
    }

    public void salvar(TbUnidadeMedida UnidadeMedida) {
        genericDao.salvar(UnidadeMedida);
    }

    public void atualizar(TbUnidadeMedida UnidadeMedida) {
        genericDao.atualizar(UnidadeMedida);
    }

    public void excluir(TbUnidadeMedida UnidadeMedida) {
        genericDao.excluir(UnidadeMedida);
    }
    public List buscarTodos() {
        List<TbUnidadeMedida> UnidadeMedidas = genericDao.listarTodos(TbUnidadeMedida.class);
        return UnidadeMedidas;
    }
}
