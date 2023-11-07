package codemarket.model.rn;
import codemarket.model.dao.GenericDAO;
import codemarket.model.vo.TbEntrada;
import java.util.List;;

public class EntradaRN {

    private GenericDAO<TbEntrada> genericDao;

    public EntradaRN() {
        genericDao = new GenericDAO<>();
    }

    public void salvar(TbEntrada Entrada) {
        genericDao.salvar(Entrada);
    }

    public void atualizar(TbEntrada Entrada) {
        genericDao.atualizar(Entrada);
    }

    public void excluir(TbEntrada Entrada) {
        genericDao.excluir(Entrada);
    }
    public List buscarTodos(String coluna) {
        List<TbEntrada> Entradas = genericDao.listarTodos(TbEntrada.class, coluna);
        return Entradas;
    }
    public TbEntrada listaUm(String pesquisa, String valor, Class classe) {
        String jpql = "SELECT t FROM " + classe.getTypeName() + "t where t." + pesquisa + " = '" + valor + "'";
        TbEntrada obj = genericDao.listarUm(pesquisa, valor, classe);
        return obj;
    }
}
