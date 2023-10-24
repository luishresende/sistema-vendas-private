package codemarket.model.rm;
import codemarket.model.dao.ClienteDAO;
import codemarket.model.dao.ClienteDAOImpl;
import codemarket.model.pojo.TbCliente;

public class ClienteRN {

    private ClienteDAO genericDao;

    public ClienteRN() {
        genericDao = new ClienteDAOImpl();
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
}
