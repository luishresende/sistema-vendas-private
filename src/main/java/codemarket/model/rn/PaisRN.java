package codemarket.model.rn;
import codemarket.model.dao.GenericDAO;
import codemarket.model.vo.TbPais;
import java.util.List;;

public class PaisRN {

    private GenericDAO<TbPais> genericDao;

    public PaisRN() {
        genericDao = new GenericDAO<>();
    }

    public void salvar(TbPais Pais) {
        genericDao.salvar(Pais);
    }

    public void atualizar(TbPais Pais) {
        genericDao.atualizar(Pais);
    }

    public void excluir(TbPais Pais) {
        genericDao.excluir(Pais);
    }
    public List buscarTodos() {
        List<TbPais> Paiss = genericDao.listarTodos(TbPais.class);
        return Paiss;
    }
    public TbPais listaUm(String pesquisa, String valor, Class classe) {
        String jpql = "SELECT t FROM " + classe.getTypeName() + "t where t." + pesquisa + " = '" + valor + "'";
        TbPais obj = genericDao.listarUm(pesquisa, valor, classe);
        return obj;
    }
}
