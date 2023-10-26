package codemarket.model.rn;
import codemarket.model.dao.GenericDAO;
import codemarket.model.vo.TbPedido;
import java.util.List;;

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
    public List buscarTodos() {
        List<TbPedido> Pedidos = genericDao.listarTodos(TbPedido.class);
        return Pedidos;
    }
    public TbPedido listaUm(String pesquisa, String valor, Class classe) {
        String jpql = "SELECT t FROM " + classe.getTypeName() + "t where t." + pesquisa + " = '" + valor + "'";
        TbPedido obj = genericDao.listarUm(pesquisa, valor, classe);
        return obj;
    }
}
