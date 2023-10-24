package codemarket.model.rm;
import codemarket.model.dao.FuncionarioDAO;
import codemarket.model.dao.FuncionarioDAOImpl;
import codemarket.model.pojo.TbFuncionario;

public class FuncionarioRN {

    private FuncionarioDAO genericDao;

    public FuncionarioRN() {
        genericDao = new FuncionarioDAOImpl();
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
}
