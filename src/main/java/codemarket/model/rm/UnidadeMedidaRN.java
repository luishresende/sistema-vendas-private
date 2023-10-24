package codemarket.model.rm;
import codemarket.model.dao.UnidadeMedidaDAO;
import codemarket.model.dao.UnidadeMedidaDAOImpl;
import codemarket.model.pojo.TbUnidadeMedida;

public class UnidadeMedidaRN {

    private UnidadeMedidaDAO genericDao;

    public UnidadeMedidaRN() {
        genericDao = new UnidadeMedidaDAOImpl();
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
}
