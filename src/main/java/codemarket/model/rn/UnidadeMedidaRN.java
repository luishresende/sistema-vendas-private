package codemarket.model.rn;
import codemarket.model.dao.GenericDAO;
import codemarket.model.vo.TbUnidadeMedida;
import java.util.List;;

public class UnidadeMedidaRN {

    private GenericDAO<TbUnidadeMedida> genericDao;

    public UnidadeMedidaRN() {
        genericDao = new GenericDAO<>();
    }

    public void salvar(TbUnidadeMedida UnidadeMedida) {
        genericDao.salvar(UnidadeMedida);
    }

    public void atualizar(TbUnidadeMedida UnidadeMedida) {
        genericDao.atualizar(UnidadeMedida);
    }

    public void excluir(TbUnidadeMedida UnidadeMedida) {
        genericDao.excluir(UnidadeMedida);
    }
    public List buscarTodos() {
        List<TbUnidadeMedida> UnidadeMedidas = genericDao.listarTodos(TbUnidadeMedida.class);
        return UnidadeMedidas;
    }
    public TbUnidadeMedida listaUm(String pesquisa, String valor, Class classe) {
        String jpql = "SELECT t FROM " + classe.getTypeName() + "t where t." + pesquisa + " = '" + valor + "'";
        TbUnidadeMedida obj = genericDao.listarUm(pesquisa, valor, classe);
        return obj;
    }
}
