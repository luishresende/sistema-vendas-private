package codemarket.model.rm;
import codemarket.model.dao.EndPostalDAO;
import codemarket.model.dao.EndPostalDAOImpl;
import codemarket.model.pojo.TbEndPostal;

public class EndPostalRN {

    private EndPostalDAO genericDao;

    public EndPostalRN() {
        genericDao = new EndPostalDAOImpl();
    }

    public void salvar(TbEndPostal EndPostal) {
        genericDao.salvar(EndPostal);
    }

    public void atualizar(TbEndPostal EndPostal) {
        genericDao.atualizar(EndPostal);
    }

    public void excluir(TbEndPostal EndPostal) {
        genericDao.excluir(EndPostal);
    }
}
