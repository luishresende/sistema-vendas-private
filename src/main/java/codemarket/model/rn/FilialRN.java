package codemarket.model.rn;
import codemarket.model.dao.GenericDAO;
import codemarket.model.vo.TbFilial;
import java.util.List;;

public class FilialRN {

    private GenericDAO<TbFilial> genericDao;

    public FilialRN() {
        genericDao = new GenericDAO<>();
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
    public List buscarTodos() {
        List<TbFilial> Filials = genericDao.listarTodos(TbFilial.class);
        return Filials;
    }
}
