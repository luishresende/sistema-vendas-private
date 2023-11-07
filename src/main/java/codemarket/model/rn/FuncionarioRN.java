package codemarket.model.rn;
import codemarket.model.dao.GenericDAO;
import codemarket.model.vo.TbFuncionario;
import java.util.List;;

public class FuncionarioRN {

    private GenericDAO<TbFuncionario> genericDao;

    public FuncionarioRN() {
        genericDao = new GenericDAO<>();
    }

    public void salvar(TbFuncionario Funcionario) {
        genericDao.salvar(Funcionario);
    }

    public void atualizar(TbFuncionario Funcionario) {
        genericDao.atualizar(Funcionario);
    }

    public void excluir(TbFuncionario Funcionario) {
        genericDao.excluir(Funcionario);
    }
    public List buscarTodos(String coluna) {
        List<TbFuncionario> Funcionarios = genericDao.listarTodos(TbFuncionario.class, coluna);
        return Funcionarios;
    }
    public TbFuncionario listaUm(String pesquisa, String valor, Class classe) {
        String jpql = "SELECT t FROM " + classe.getTypeName() + "t where t." + pesquisa + " = '" + valor + "'";
        TbFuncionario obj = genericDao.listarUm(pesquisa, valor, classe);
        return obj;
    }
}
