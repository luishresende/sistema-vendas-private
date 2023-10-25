package codemarket.model.rn;
import codemarket.model.dao.GenericDAO;
import codemarket.model.vo.TbPedido;

public class PedidoRN {

    private GenericDAO<TbPedido> genericDao;

    public PedidoRN() {
        genericDao = new GenericDAO<>();
    }

    public void salvar(TbPedido Pedido) {
        genericDao.salvar(Pedido);
    }

    public void atualizar(TbPedido Pedido) {
        genericDao.atualizar(Pedido);
    }

    public void excluir(TbPedido Pedido) {
        genericDao.excluir(Pedido);
    }
}
