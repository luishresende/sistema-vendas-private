package codemarket.model.rm;
import codemarket.model.dao.GrupoPermissoesDAO;
import codemarket.model.dao.GrupoPermissoesDAOImpl;
import codemarket.model.pojo.TbGrupoPermissoes;

public class GrupoPermissoesRN {

    private GrupoPermissoesDAO genericDao;

    public GrupoPermissoesRN() {
        genericDao = new GrupoPermissoesDAOImpl();
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
}
