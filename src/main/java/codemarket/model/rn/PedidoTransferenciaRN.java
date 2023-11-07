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
    public List buscarTodos(String coluna) {
        List<TbPedidoTransferencia> PedidoTransferencias = genericDao.listarTodos(TbPedidoTransferencia.class, coluna);
        return PedidoTransferencias;
    }
    public TbPedidoTransferencia listaUm(String pesquisa, String valor, Class classe) {
        String jpql = "SELECT t FROM " + classe.getTypeName() + "t where t." + pesquisa + " = '" + valor + "'";
        TbPedidoTransferencia obj = genericDao.listarUm(pesquisa, valor, classe);
        return obj;
    }
}
