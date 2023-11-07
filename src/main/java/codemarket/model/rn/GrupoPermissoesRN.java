package codemarket.model.rn;
import codemarket.model.dao.GenericDAO;
import codemarket.model.vo.TbGrupoPermissoes;
import java.util.List;;

public class GrupoPermissoesRN {

    private GenericDAO<TbGrupoPermissoes> genericDao;

    public GrupoPermissoesRN() {
        genericDao = new GenericDAO<>();
    }

    public void salvar(TbGrupoPermissoes GrupoPermissoes) {
        genericDao.salvar(GrupoPermissoes);
    }

    public void atualizar(TbGrupoPermissoes GrupoPermissoes) {
        genericDao.atualizar(GrupoPermissoes);
    }

    public void excluir(TbGrupoPermissoes GrupoPermissoes) {
        genericDao.excluir(GrupoPermissoes);
    }
    public List buscarTodos(String coluna) {
        List<TbGrupoPermissoes> GrupoPermissoess = genericDao.listarTodos(TbGrupoPermissoes.class, coluna);
        return GrupoPermissoess;
    }
    public TbGrupoPermissoes listaUm(String pesquisa, String valor, Class classe) {
        String jpql = "SELECT t FROM " + classe.getTypeName() + "t where t." + pesquisa + " = '" + valor + "'";
        TbGrupoPermissoes obj = genericDao.listarUm(pesquisa, valor, classe);
        return obj;
    }
}
