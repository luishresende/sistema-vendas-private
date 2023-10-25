package codemarket.model.rn;
import codemarket.model.dao.GenericDAO;
import codemarket.model.vo.TbPedidoTransferencia;
import java.util.List;;

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
    public List buscarTodos() {
        List<TbPedidoTransferencia> PedidoTransferencias = genericDao.listarTodos(TbPedidoTransferencia.class);
        return PedidoTransferencias;
    }
}
