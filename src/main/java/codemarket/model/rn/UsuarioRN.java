package codemarket.model.rn;
import codemarket.model.dao.GenericDAO;
import codemarket.model.vo.TbUsuario;

public class UsuarioRN {

    private GenericDAO<TbUsuario> genericDao;

    public UsuarioRN() {
        genericDao = new GenericDAO<>();
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
