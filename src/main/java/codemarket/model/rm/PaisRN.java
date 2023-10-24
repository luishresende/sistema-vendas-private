package codemarket.model.rm;
import codemarket.model.dao.PaisDAO;
import codemarket.model.dao.PaisDAOImpl;
import codemarket.model.pojo.TbPais;

public class PaisRN {

    private PaisDAO genericDao;

    public PaisRN() {
        genericDao = new PaisDAOImpl();
    }

    public void salvar(TbPais Pais) {
        genericDao.salvar(Pais);
    }

    public void atualizar(TbPais Pais) {
        genericDao.atualizar(Pais);
    }

    public void excluir(TbPais Pais) {
        genericDao.excluir(Pais);
    }
}
