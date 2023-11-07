package codemarket.model.rn;
import codemarket.model.dao.GenericDAO;
import codemarket.model.vo.TbEntradaStatus;
import java.util.List;;

public class EntradaStatusRN {

    private GenericDAO<TbEntradaStatus> genericDao;

    public EntradaStatusRN() {
        genericDao = new GenericDAO<>();
    }

    public void salvar(TbEntradaStatus EntradaStatus) {
        genericDao.salvar(EntradaStatus);
    }

    public void atualizar(TbEntradaStatus EntradaStatus) {
        genericDao.atualizar(EntradaStatus);
    }

    public void excluir(TbEntradaStatus EntradaStatus) {
        genericDao.excluir(EntradaStatus);
    }
    public List buscarTodos(String coluna) {
        List<TbEntradaStatus> EntradaStatuss = genericDao.listarTodos(TbEntradaStatus.class, coluna);
        return EntradaStatuss;
    }
    public TbEntradaStatus listaUm(String pesquisa, String valor, Class classe) {
        String jpql = "SELECT t FROM " + classe.getTypeName() + "t where t." + pesquisa + " = '" + valor + "'";
        TbEntradaStatus obj = genericDao.listarUm(pesquisa, valor, classe);
        return obj;
    }
    public List pesquisar(String jpql) {
        List obj = genericDao.pesquisar(jpql);
        return obj;
    }
}
