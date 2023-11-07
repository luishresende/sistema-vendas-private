package codemarket.model.rn;
import codemarket.model.dao.GenericDAO;
import codemarket.model.vo.TbEstado;
import java.util.List;;

public class EstadoRN {

    private GenericDAO<TbEstado> genericDao;

    public EstadoRN() {
        genericDao = new GenericDAO<>();
    }

    public void salvar(TbEstado Estado) {
        genericDao.salvar(Estado);
    }

    public void atualizar(TbEstado Estado) {
        genericDao.atualizar(Estado);
    }

    public void excluir(TbEstado Estado) {
        genericDao.excluir(Estado);
    }
    public List buscarTodos(String coluna) {
        List<TbEstado> Estados = genericDao.listarTodos(TbEstado.class, coluna);
        return Estados;
    }
    public TbEstado listaUm(String pesquisa, String valor, Class classe) {
        String jpql = "SELECT t FROM " + classe.getTypeName() + "t where t." + pesquisa + " = '" + valor + "'";
        TbEstado obj = genericDao.listarUm(pesquisa, valor, classe);
        return obj;
    }
}
