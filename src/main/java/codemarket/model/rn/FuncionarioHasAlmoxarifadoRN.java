package codemarket.model.rn;
import codemarket.model.dao.GenericDAO;
import codemarket.model.vo.TbFuncionarioHasAlmoxarifado;
import java.util.List;;

public class FuncionarioHasAlmoxarifadoRN {

    private GenericDAO<TbFuncionarioHasAlmoxarifado> genericDao;

    public FuncionarioHasAlmoxarifadoRN() {
        genericDao = new GenericDAO<>();
    }

    public void salvar(TbFuncionarioHasAlmoxarifado FuncionarioHasAlmoxarifado) {
        genericDao.salvar(FuncionarioHasAlmoxarifado);
    }

    public void atualizar(TbFuncionarioHasAlmoxarifado FuncionarioHasAlmoxarifado) {
        genericDao.atualizar(FuncionarioHasAlmoxarifado);
    }

    public void excluir(TbFuncionarioHasAlmoxarifado FuncionarioHasAlmoxarifado) {
        genericDao.excluir(FuncionarioHasAlmoxarifado);
    }
    public List buscarTodos(String coluna) {
        List<TbFuncionarioHasAlmoxarifado> FuncionarioHasAlmoxarifados = genericDao.listarTodos(TbFuncionarioHasAlmoxarifado.class, coluna);
        return FuncionarioHasAlmoxarifados;
    }
    public TbFuncionarioHasAlmoxarifado listaUm(String pesquisa, String valor, Class classe) {
        String jpql = "SELECT t FROM " + classe.getTypeName() + "t where t." + pesquisa + " = '" + valor + "'";
        TbFuncionarioHasAlmoxarifado obj = genericDao.listarUm(pesquisa, valor, classe);
        return obj;
    }
    public List pesquisar(String jpql) {
        List obj = genericDao.pesquisar(jpql);
        return obj;
    }
}
