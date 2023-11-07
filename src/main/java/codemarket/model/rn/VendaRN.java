package codemarket.model.rn;
import codemarket.model.dao.GenericDAO;
import codemarket.model.vo.TbVenda;
import java.util.List;;

public class VendaRN {

    private GenericDAO<TbVenda> genericDao;

    public VendaRN() {
        genericDao = new GenericDAO<>();
    }

    public void salvar(TbVenda Venda) {
        genericDao.salvar(Venda);
    }

    public void atualizar(TbVenda Venda) {
        genericDao.atualizar(Venda);
    }

    public void excluir(TbVenda Venda) {
        genericDao.excluir(Venda);
    }
    public List buscarTodos(String coluna) {
        List<TbVenda> Vendas = genericDao.listarTodos(TbVenda.class, coluna);
        return Vendas;
    }
    public TbVenda listaUm(String pesquisa, String valor, Class classe) {
        String jpql = "SELECT t FROM " + classe.getTypeName() + "t where t." + pesquisa + " = '" + valor + "'";
        TbVenda obj = genericDao.listarUm(pesquisa, valor, classe);
        return obj;
    }
    public List pesquisar(String jpql) {
        List obj = genericDao.pesquisar(jpql);
        return obj;
    }
}
