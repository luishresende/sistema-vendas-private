package codemarket.model.rm;
import codemarket.model.dao.UsuarioDAO;
import codemarket.model.dao.UsuarioDAOImpl;
import codemarket.model.pojo.TbUsuario;

public class UsuarioRN {

    private UsuarioDAO genericDao;

    public UsuarioRN() {
        genericDao = new UsuarioDAOImpl();
    }

    public void salvar(TbUsuario Usuario) {
        genericDao.salvar(Usuario);
    }

    public void atualizar(TbUsuario Usuario) {
        genericDao.atualizar(Usuario);
    }

    public void excluir(TbUsuario Usuario) {
        genericDao.excluir(Usuario);
    }
}
