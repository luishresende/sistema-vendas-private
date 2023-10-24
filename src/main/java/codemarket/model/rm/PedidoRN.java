package codemarket.model.rm;
import codemarket.model.dao.PedidoDAO;
import codemarket.model.dao.PedidoDAOImpl;
import codemarket.model.pojo.TbPedido;

public class PedidoRN {

    private PedidoDAO genericDao;

    public PedidoRN() {
        genericDao = new PedidoDAOImpl();
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
