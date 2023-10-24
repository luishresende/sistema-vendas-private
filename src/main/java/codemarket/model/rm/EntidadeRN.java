package codemarket.model.rm;
import codemarket.model.dao.EntidadeDAO;
import codemarket.model.dao.EntidadeDAOImpl;
import codemarket.model.pojo.TbEntidade;

public class EntidadeRN {

    private EntidadeDAO genericDao;

    public EntidadeRN() {
        genericDao = new EntidadeDAOImpl();
    }

    public void salvar(TbEntidade Entidade) {
        genericDao.salvar(Entidade);
    }

    public void atualizar(TbEntidade Entidade) {
        genericDao.atualizar(Entidade);
    }

    public void excluir(TbEntidade Entidade) {
        genericDao.excluir(Entidade);
    }
}
