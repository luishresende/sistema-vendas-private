package codemarket.model.rn;
import codemarket.model.dao.GenericDAO;
import codemarket.model.vo.TbEndPostal;
import java.util.List;;

public class EndPostalRN {

    private GenericDAO<TbEndPostal> genericDao;

    public EndPostalRN() {
        genericDao = new GenericDAO<>();
    }

    public void salvar(TbEndPostal EndPostal) {
        genericDao.salvar(EndPostal);
    }

    public void atualizar(TbEndPostal EndPostal) {
        genericDao.atualizar(EndPostal);
    }

    public void excluir(TbEndPostal EndPostal) {
        genericDao.excluir(EndPostal);
    }
    public List buscarTodos(String coluna) {
        List<TbEndPostal> EndPostals = genericDao.listarTodos(TbEndPostal.class, coluna);
        return EndPostals;
    }
    public TbEndPostal listaUm(String pesquisa, String valor, Class classe) {
        String jpql = "SELECT t FROM " + classe.getTypeName() + "t where t." + pesquisa + " = '" + valor + "'";
        TbEndPostal obj = genericDao.listarUm(pesquisa, valor, classe);
        return obj;
    }
}
