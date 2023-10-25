package codemarket.model.rn;
import codemarket.model.dao.GenericDAO;
import codemarket.model.vo.TbPedidoTransferencia;

public class PedidoTransferenciaRN {

    private GenericDAO<TbPedidoTransferencia> genericDao;

    public PedidoTransferenciaRN() {
        genericDao = new GenericDAO<>();
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
