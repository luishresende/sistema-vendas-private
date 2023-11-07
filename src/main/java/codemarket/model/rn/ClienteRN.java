package codemarket.model.rn;
import codemarket.model.dao.GenericDAO;
import codemarket.model.vo.TbCliente;
import java.util.List;;

public class ClienteRN {

    private GenericDAO<TbCliente> genericDao;

    public ClienteRN() {
        genericDao = new GenericDAO<>();
    }

    public void salvar(TbCliente Cliente) {
        genericDao.salvar(Cliente);
    }

    public void atualizar(TbCliente Cliente) {
        genericDao.atualizar(Cliente);
    }

    public void excluir(TbCliente Cliente) {
        genericDao.excluir(Cliente);
    }
    public List buscarTodos(String coluna) {
        List<TbCliente> Clientes = genericDao.listarTodos(TbCliente.class, coluna);
        return Clientes;
    }
    public TbCliente listaUm(String pesquisa, String valor, Class classe) {
        String jpql = "SELECT t FROM " + classe.getTypeName() + "t where t." + pesquisa + " = '" + valor + "'";
        TbCliente obj = genericDao.listarUm(pesquisa, valor, classe);
        return obj;
    }
}
