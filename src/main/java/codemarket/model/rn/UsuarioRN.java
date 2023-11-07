package codemarket.model.rn;
import codemarket.model.dao.GenericDAO;
import codemarket.model.vo.TbUsuario;
import java.util.List;;

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
    public List buscarTodos(String coluna) {
        List<TbUsuario> Usuarios = genericDao.listarTodos(TbUsuario.class, coluna);
        return Usuarios;
    }
    public TbUsuario listaUm(String pesquisa, String valor, Class classe) {
        String jpql = "SELECT t FROM " + classe.getTypeName() + "t where t." + pesquisa + " = '" + valor + "'";
        TbUsuario obj = genericDao.listarUm(pesquisa, valor, classe);
        return obj;
    }
}
