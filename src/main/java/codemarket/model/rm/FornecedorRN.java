package codemarket.model.rm;
import codemarket.model.dao.FornecedorDAO;
import codemarket.model.dao.FornecedorDAOImpl;
import codemarket.model.pojo.TbFornecedor;

public class FornecedorRN {

    private FornecedorDAO genericDao;

    public FornecedorRN() {
        genericDao = new FornecedorDAOImpl();
    }

    public void salvar(TbFornecedor Fornecedor) {
        genericDao.salvar(Fornecedor);
    }

    public void atualizar(TbFornecedor Fornecedor) {
        genericDao.atualizar(Fornecedor);
    }

    public void excluir(TbFornecedor Fornecedor) {
        genericDao.excluir(Fornecedor);
    }
}
