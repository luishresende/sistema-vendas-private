package codemarket.model.rn;
import codemarket.model.dao.GenericDAO;
import codemarket.model.vo.TbPedidoPK;

public class PedidoPKRN {

    private GenericDAO<TbPedidoPK> genericDao;

    public PedidoPKRN() {
        genericDao = new GenericDAO<>();
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
