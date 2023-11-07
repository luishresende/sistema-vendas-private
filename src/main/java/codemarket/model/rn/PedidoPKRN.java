package codemarket.model.rn;
import codemarket.model.dao.GenericDAO;
import codemarket.model.vo.TbPedidoPK;
import java.util.List;;

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
    public List buscarTodos(String coluna) {
        List<TbPedidoPK> PedidoPKs = genericDao.listarTodos(TbPedidoPK.class, coluna);
        return PedidoPKs;
    }
    public TbPedidoPK listaUm(String pesquisa, String valor, Class classe) {
        String jpql = "SELECT t FROM " + classe.getTypeName() + "t where t." + pesquisa + " = '" + valor + "'";
        TbPedidoPK obj = genericDao.listarUm(pesquisa, valor, classe);
        return obj;
    }
}
