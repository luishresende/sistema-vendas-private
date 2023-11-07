package codemarket.model.rn;
import codemarket.model.dao.GenericDAO;
import codemarket.model.vo.TbProduto;
import java.util.List;;

public class ProdutoRN {

    private GenericDAO<TbProduto> genericDao;

    public ProdutoRN() {
        genericDao = new GenericDAO<>();
    }

    public void salvar(TbProduto Produto) {
        genericDao.salvar(Produto);
    }

    public void atualizar(TbProduto Produto) {
        genericDao.atualizar(Produto);
    }

    public void excluir(TbProduto Produto) {
        genericDao.excluir(Produto);
    }
    public List buscarTodos(String coluna) {
        List<TbProduto> Produtos = genericDao.listarTodos(TbProduto.class, coluna);
        return Produtos;
    }
    public TbProduto listaUm(String pesquisa, String valor, Class classe) {
        String jpql = "SELECT t FROM " + classe.getTypeName() + "t where t." + pesquisa + " = '" + valor + "'";
        TbProduto obj = genericDao.listarUm(pesquisa, valor, classe);
        return obj;
    }
    public List pesquisar(String jpql) {
        List obj = genericDao.pesquisar(jpql);
        return obj;
    }
}
