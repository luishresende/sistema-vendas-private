package codemarket.model.rn;
import codemarket.model.dao.GenericDAO;
import codemarket.model.vo.TbCategoriaProduto;
import java.util.List;;

public class CategoriaProdutoRN {

    private GenericDAO<TbCategoriaProduto> genericDao;

    public CategoriaProdutoRN() {
        genericDao = new GenericDAO<>();
    }

    public void salvar(TbCategoriaProduto CategoriaProduto) {
        genericDao.salvar(CategoriaProduto);
    }

    public void atualizar(TbCategoriaProduto CategoriaProduto) {
        genericDao.atualizar(CategoriaProduto);
    }

    public void excluir(TbCategoriaProduto CategoriaProduto) {
        genericDao.excluir(CategoriaProduto);
    }
    public List buscarTodos() {
        List<TbCategoriaProduto> CategoriaProdutos = genericDao.listarTodos(TbCategoriaProduto.class);
        return CategoriaProdutos;
    }
    public TbCategoriaProduto listaUm(String pesquisa, String valor, Class classe) {
        String jpql = "SELECT t FROM " + classe.getTypeName() + "t where t." + pesquisa + " = '" + valor + "'";
        TbCategoriaProduto obj = genericDao.listarUm(pesquisa, valor, classe);
        return obj;
    }
}
