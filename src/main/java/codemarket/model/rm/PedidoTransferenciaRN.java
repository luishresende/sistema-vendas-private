package codemarket.model.rm;
import codemarket.model.dao.PedidoTransferenciaDAO;
import codemarket.model.dao.PedidoTransferenciaDAOImpl;
import codemarket.model.pojo.TbPedidoTransferencia;

public class PedidoTransferenciaRN {

    private PedidoTransferenciaDAO genericDao;

    public PedidoTransferenciaRN() {
        genericDao = new PedidoTransferenciaDAOImpl();
    }

    public void salvar(TbPedidoTransferencia PedidoTransferencia) {
        genericDao.salvar(PedidoTransferencia);
    }

    public void atualizar(TbPedidoTransferencia PedidoTransferencia) {
        genericDao.atualizar(PedidoTransferencia);
    }

    public void excluir(TbPedidoTransferencia PedidoTransferencia) {
        genericDao.excluir(PedidoTransferencia);
    }
}
