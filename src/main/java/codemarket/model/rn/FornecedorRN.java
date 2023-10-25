package codemarket.model.rn;
import codemarket.model.dao.GenericDAO;
import codemarket.model.vo.TbFornecedor;

public class FornecedorRN {

    private GenericDAO<TbFornecedor> genericDao;

    public FornecedorRN() {
        genericDao = new GenericDAO<>();
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
