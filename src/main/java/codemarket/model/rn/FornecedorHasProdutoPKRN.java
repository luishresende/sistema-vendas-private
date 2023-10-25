package codemarket.model.rn;
import codemarket.model.dao.GenericDAO;
import codemarket.model.vo.TbFornecedorHasProdutoPK;

public class FornecedorHasProdutoPKRN {

    private GenericDAO<TbFornecedorHasProdutoPK> genericDao;

    public FornecedorHasProdutoPKRN() {
        genericDao = new GenericDAO<>();
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
