package codemarket.model.rm;
import codemarket.model.dao.LogradouroDAO;
import codemarket.model.dao.LogradouroDAOImpl;
import codemarket.model.pojo.TbLogradouro;

public class LogradouroRN {

    private LogradouroDAO genericDao;

    public LogradouroRN() {
        genericDao = new LogradouroDAOImpl();
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
}
