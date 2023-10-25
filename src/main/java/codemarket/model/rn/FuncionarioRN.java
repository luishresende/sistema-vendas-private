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
    public List buscarTodos() {
        List<TbFuncionario> Funcionarios = genericDao.listarTodos(TbFuncionario.class);
        return Funcionarios;
    }
}
