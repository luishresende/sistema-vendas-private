package codemarket.model.rn;
import codemarket.model.dao.GenericDAO;
import codemarket.model.vo.TbBairro;
import java.util.List;;

public class BairroRN {

    private GenericDAO<TbBairro> genericDao;

    public BairroRN() {
        genericDao = new GenericDAO<>();
    }

    public void salvar(TbBairro Bairro) {
        genericDao.salvar(Bairro);
    }

    public void atualizar(TbBairro Bairro) {
        genericDao.atualizar(Bairro);
    }

    public void excluir(TbBairro Bairro) {
        genericDao.excluir(Bairro);
    }
    public List buscarTodos(String coluna) {
        List<TbBairro> Bairros = genericDao.listarTodos(TbBairro.class, coluna);
        return Bairros;
    }
    public TbBairro listaUm(String pesquisa, String valor, Class classe) {
        String jpql = "SELECT t FROM " + classe.getTypeName() + "t where t." + pesquisa + " = '" + valor + "'";
        TbBairro obj = genericDao.listarUm(pesquisa, valor, classe);
        return obj;
    }
}
