package codemarket.model.rm;
import codemarket.model.dao.FilialDAO;
import codemarket.model.dao.FilialDAOImpl;
import codemarket.model.pojo.TbFilial;

public class FilialRN {

    private FilialDAO genericDao;

    public FilialRN() {
        genericDao = new FilialDAOImpl();
    }

    public void salvar(TbFilial Filial) {
        genericDao.salvar(Filial);
    }

    public void atualizar(TbFilial Filial) {
        genericDao.atualizar(Filial);
    }

    public void excluir(TbFilial Filial) {
        genericDao.excluir(Filial);
    }
}
