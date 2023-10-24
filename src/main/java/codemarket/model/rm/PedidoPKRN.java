package codemarket.model.rm;
import codemarket.model.dao.PedidoPKDAO;
import codemarket.model.dao.PedidoPKDAOImpl;
import codemarket.model.pojo.TbPedidoPK;

public class PedidoPKRN {

    private PedidoPKDAO genericDao;

    public PedidoPKRN() {
        genericDao = new PedidoPKDAOImpl();
    }

    public void salvar(TbPedidoPK PedidoPK) {
        genericDao.salvar(PedidoPK);
    }

    public void atualizar(TbPedidoPK PedidoPK) {
        genericDao.atualizar(PedidoPK);
    }

    public void excluir(TbPedidoPK PedidoPK) {
        genericDao.excluir(PedidoPK);
    }
}
