package codemarket.model.rn;
import codemarket.model.dao.GenericDAO;
import codemarket.model.vo.TbTipoEndereco;
import java.util.List;
;

public class TipoEnderecoRN {

    private GenericDAO<TbTipoEndereco> genericDao;

    public TipoEnderecoRN() {
        genericDao = new GenericDAO<>();
    }

    public void salvar(TbTipoEndereco tipoend) {
        genericDao.salvar(tipoend);
    }

    public void atualizar(TbTipoEndereco tipoend) {
        genericDao.atualizar(tipoend);
    }

    public void excluir(TbTipoEndereco tipoend) {
        genericDao.excluir(tipoend);
    }
    public List buscarTodos(String coluna) {
        List<TbTipoEndereco> tipoends = genericDao.listarTodos(TbTipoEndereco.class, coluna);
        return tipoends;
    }
    public TbTipoEndereco listaUm(String pesquisa, String valor, Class classe) {
        String jpql = "SELECT t FROM " + classe.getTypeName() + "t where t." + pesquisa + " = '" + valor + "'";
        TbTipoEndereco obj = genericDao.listarUm(pesquisa, valor, classe);
        return obj;
    }
    public List pesquisar(String jpql) {
        List obj = genericDao.pesquisar(jpql);
        return obj;
    }
}
