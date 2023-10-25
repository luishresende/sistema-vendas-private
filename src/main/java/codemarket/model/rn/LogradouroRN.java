package codemarket.model.rn;
import codemarket.model.dao.GenericDAO;
import codemarket.model.vo.TbLogradouro;
import java.util.List;;

public class LogradouroRN {

    private GenericDAO<TbLogradouro> genericDao;

    public LogradouroRN() {
        genericDao = new GenericDAO<>();
    }

    public void salvar(TbLogradouro Logradouro) {
        genericDao.salvar(Logradouro);
    }

    public void atualizar(TbLogradouro Logradouro) {
        genericDao.atualizar(Logradouro);
    }

    public void excluir(TbLogradouro Logradouro) {
        genericDao.excluir(Logradouro);
    }
    public List buscarTodos() {
        List<TbLogradouro> Logradouros = genericDao.listarTodos(TbLogradouro.class);
        return Logradouros;
    }
}
