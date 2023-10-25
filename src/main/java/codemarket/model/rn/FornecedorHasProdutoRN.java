package codemarket.model.rn;
import codemarket.model.dao.GenericDAO;
import codemarket.model.vo.TbFornecedorHasProduto;

public class FornecedorHasProdutoRN {

    private GenericDAO<TbFornecedorHasProduto> genericDao;

    public FornecedorHasProdutoRN() {
        genericDao = new GenericDAO<>();
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
