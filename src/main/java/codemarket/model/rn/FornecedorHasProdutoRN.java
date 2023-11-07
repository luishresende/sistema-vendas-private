package codemarket.model.rn;
import codemarket.model.dao.GenericDAO;
import codemarket.model.vo.TbFornecedorHasProduto;
import java.util.List;;

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
    public List buscarTodos(String coluna) {
        List<TbFornecedorHasProduto> FornecedorHasProdutos = genericDao.listarTodos(TbFornecedorHasProduto.class, coluna);
        return FornecedorHasProdutos;
    }
    public TbFornecedorHasProduto listaUm(String pesquisa, String valor, Class classe) {
        String jpql = "SELECT t FROM " + classe.getTypeName() + "t where t." + pesquisa + " = '" + valor + "'";
        TbFornecedorHasProduto obj = genericDao.listarUm(pesquisa, valor, classe);
        return obj;
    }
    public List pesquisar(String jpql) {
        List obj = genericDao.pesquisar(jpql);
        return obj;
    }
}
