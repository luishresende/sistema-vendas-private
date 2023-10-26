package codemarket.model.rn;
import codemarket.model.dao.GenericDAO;
import codemarket.model.vo.TbFornecedor;
import java.util.List;;

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
    public List buscarTodos() {
        List<TbFornecedor> Fornecedors = genericDao.listarTodos(TbFornecedor.class);
        return Fornecedors;
    }
    public TbFornecedor listaUm(String pesquisa, String valor, Class classe) {
        String jpql = "SELECT t FROM " + classe.getTypeName() + "t where t." + pesquisa + " = '" + valor + "'";
        TbFornecedor obj = genericDao.listarUm(pesquisa, valor, classe);
        return obj;
    }
}
