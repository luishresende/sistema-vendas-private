package codemarket.model.rn;
import codemarket.model.dao.GenericDAO;
import codemarket.model.vo.TbEstoquePK;
import java.util.List;;

public class EstoquePKRN {

    private GenericDAO<TbEstoquePK> genericDao;

    public EstoquePKRN() {
        genericDao = new GenericDAO<>();
    }

    public void salvar(TbEstoquePK EstoquePK) {
        genericDao.salvar(EstoquePK);
    }

    public void atualizar(TbEstoquePK EstoquePK) {
        genericDao.atualizar(EstoquePK);
    }

    public void excluir(TbEstoquePK EstoquePK) {
        genericDao.excluir(EstoquePK);
    }
    public List buscarTodos(String coluna) {
        List<TbEstoquePK> EstoquePKs = genericDao.listarTodos(TbEstoquePK.class, coluna);
        return EstoquePKs;
    }
    public TbEstoquePK listaUm(String pesquisa, String valor, Class classe) {
        String jpql = "SELECT t FROM " + classe.getTypeName() + "t where t." + pesquisa + " = '" + valor + "'";
        TbEstoquePK obj = genericDao.listarUm(pesquisa, valor, classe);
        return obj;
    }
    public List pesquisar(String jpql) {
        List obj = genericDao.pesquisar(jpql);
        return obj;
    }
}
