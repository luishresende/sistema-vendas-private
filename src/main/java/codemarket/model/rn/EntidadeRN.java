package codemarket.model.rn;
import codemarket.model.dao.GenericDAO;
import codemarket.model.vo.TbEntidade;
import java.util.List;;

public class EntidadeRN {

    private GenericDAO<TbEntidade> genericDao;

    public EntidadeRN() {
        genericDao = new GenericDAO<>();
    }

    public void salvar(TbEntidade Entidade) {
        genericDao.salvar(Entidade);
    }

    public void atualizar(TbEntidade Entidade) {
        genericDao.atualizar(Entidade);
    }

    public void excluir(TbEntidade Entidade) {
        genericDao.excluir(Entidade);
    }
    public List buscarTodos(String coluna) {
        List<TbEntidade> Entidades = genericDao.listarTodos(TbEntidade.class, coluna);
        return Entidades;
    }
    public TbEntidade listaUm(String pesquisa, String valor, Class classe) {
        String jpql = "SELECT t FROM " + classe.getTypeName() + "t where t." + pesquisa + " = '" + valor + "'";
        TbEntidade obj = genericDao.listarUm(pesquisa, valor, classe);
        return obj;
    }
    public List pesquisar(String jpql) {
        List obj = genericDao.pesquisar(jpql);
        return obj;
    }
}
