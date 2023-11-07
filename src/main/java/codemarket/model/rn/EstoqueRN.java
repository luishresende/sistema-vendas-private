package codemarket.model.rn;
import codemarket.model.dao.GenericDAO;
import codemarket.model.vo.TbEstoque;
import java.util.List;;

public class EstoqueRN {

    private GenericDAO<TbEstoque> genericDao;

    public EstoqueRN() {
        genericDao = new GenericDAO<>();
    }

    public void salvar(TbEstoque Estoque) {
        genericDao.salvar(Estoque);
    }

    public void atualizar(TbEstoque Estoque) {
        genericDao.atualizar(Estoque);
    }

    public void excluir(TbEstoque Estoque) {
        genericDao.excluir(Estoque);
    }
    public List buscarTodos(String coluna) {
        List<TbEstoque> Estoques = genericDao.listarTodos(TbEstoque.class, coluna);
        return Estoques;
    }
    public TbEstoque listaUm(String pesquisa, String valor, Class classe) {
        String jpql = "SELECT t FROM " + classe.getTypeName() + "t where t." + pesquisa + " = '" + valor + "'";
        TbEstoque obj = genericDao.listarUm(pesquisa, valor, classe);
        return obj;
    }
}
