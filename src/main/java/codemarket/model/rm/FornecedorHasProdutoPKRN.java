package codemarket.model.rm;
import codemarket.model.dao.FornecedorHasProdutoPKDAO;
import codemarket.model.dao.FornecedorHasProdutoPKDAOImpl;
import codemarket.model.pojo.TbFornecedorHasProdutoPK;

public class FornecedorHasProdutoPKRN {

    private FornecedorHasProdutoPKDAO genericDao;

    public FornecedorHasProdutoPKRN() {
        genericDao = new FornecedorHasProdutoPKDAOImpl();
    }

    public void salvar(TbFornecedorHasProdutoPK FornecedorHasProdutoPK) {
        genericDao.salvar(FornecedorHasProdutoPK);
    }

    public void atualizar(TbFornecedorHasProdutoPK FornecedorHasProdutoPK) {
        genericDao.atualizar(FornecedorHasProdutoPK);
    }

    public void excluir(TbFornecedorHasProdutoPK FornecedorHasProdutoPK) {
        genericDao.excluir(FornecedorHasProdutoPK);
    }
}
