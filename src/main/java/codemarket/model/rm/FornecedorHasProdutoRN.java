package codemarket.model.rm;
import codemarket.model.dao.FornecedorHasProdutoDAO;
import codemarket.model.dao.FornecedorHasProdutoDAOImpl;
import codemarket.model.pojo.TbFornecedorHasProduto;

public class FornecedorHasProdutoRN {

    private FornecedorHasProdutoDAO genericDao;

    public FornecedorHasProdutoRN() {
        genericDao = new FornecedorHasProdutoDAOImpl();
    }

    public void salvar(TbFornecedorHasProduto FornecedorHasProduto) {
        genericDao.salvar(FornecedorHasProduto);
    }

    public void atualizar(TbFornecedorHasProduto FornecedorHasProduto) {
        genericDao.atualizar(FornecedorHasProduto);
    }

    public void excluir(TbFornecedorHasProduto FornecedorHasProduto) {
        genericDao.excluir(FornecedorHasProduto);
    }
}
