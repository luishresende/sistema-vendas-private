package codemarket.model.rn;
import codemarket.model.dao.GenericDAO;
import codemarket.model.vo.TbCliente;

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
}
