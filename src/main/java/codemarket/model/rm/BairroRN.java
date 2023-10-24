package codemarket.model.rm;
import codemarket.model.dao.BairroDAO;
import codemarket.model.dao.BairroDAOImpl;
import codemarket.model.pojo.TbBairro;

public class BairroRN {

    private BairroDAO genericDao;

    public BairroRN() {
        genericDao = new BairroDAOImpl();
    }

    public void salvar(TbBairro Bairro) {
        genericDao.salvar(Bairro);
    }

    public void atualizar(TbBairro Bairro) {
        genericDao.atualizar(Bairro);
    }

    public void excluir(TbBairro Bairro) {
        genericDao.excluir(Bairro);
    }
}
