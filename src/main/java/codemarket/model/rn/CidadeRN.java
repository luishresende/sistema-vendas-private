package codemarket.model.rn;
import codemarket.model.dao.GenericDAO;
import codemarket.model.vo.TbCidade;
import java.util.List;;

public class CidadeRN {

    private GenericDAO<TbCidade> genericDao;

    public CidadeRN() {
        genericDao = new GenericDAO<>();
    }

    public void salvar(TbCidade Cidade) {
        genericDao.salvar(Cidade);
    }

    public void atualizar(TbCidade Cidade) {
        genericDao.atualizar(Cidade);
    }

    public void excluir(TbCidade Cidade) {
        genericDao.excluir(Cidade);
    }
    public List buscarTodos(String coluna) {
        List<TbCidade> Cidades = genericDao.listarTodos(TbCidade.class, coluna);
        return Cidades;
    }
    public TbCidade listaUm(String pesquisa, String valor, Class classe) {
        String jpql = "SELECT t FROM " + classe.getTypeName() + "t where t." + pesquisa + " = '" + valor + "'";
        TbCidade obj = genericDao.listarUm(pesquisa, valor, classe);
        return obj;
    }
    public List pesquisar(String jpql) {
        List obj = genericDao.pesquisar(jpql);
        return obj;
    }
}
