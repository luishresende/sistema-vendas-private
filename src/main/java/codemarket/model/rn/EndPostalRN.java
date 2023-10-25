package codemarket.model.rn;
import codemarket.model.dao.GenericDAO;
import codemarket.model.vo.TbEndPostal;
import java.util.List;;

public class EndPostalRN {

    private GenericDAO<TbEndPostal> genericDao;

    public EndPostalRN() {
        genericDao = new GenericDAO<>();
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
    public List buscarTodos() {
        List<TbEndPostal> EndPostals = genericDao.listarTodos(TbEndPostal.class);
        return EndPostals;
    }
}
