package codemarket.model.rn;
import codemarket.model.dao.GenericDAO;
import codemarket.model.vo.TbStatus;
import java.util.List;;

public class StatusRN {

    private GenericDAO<TbStatus> genericDao;

    public StatusRN() {
        genericDao = new GenericDAO<>();
    }

    public void salvar(TbStatus Status) {
        genericDao.salvar(Status);
    }

    public void atualizar(TbStatus Status) {
        genericDao.atualizar(Status);
    }

    public void excluir(TbStatus Status) {
        genericDao.excluir(Status);
    }
    public List buscarTodos(String coluna) {
        List<TbStatus> Statuss = genericDao.listarTodos(TbStatus.class, coluna);
        return Statuss;
    }
    public TbStatus listaUm(String pesquisa, String valor, Class classe) {
        String jpql = "SELECT t FROM " + classe.getTypeName() + "t where t." + pesquisa + " = '" + valor + "'";
        TbStatus obj = genericDao.listarUm(pesquisa, valor, classe);
        return obj;
    }
}
