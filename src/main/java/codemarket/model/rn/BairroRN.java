package codemarket.model.rn;
import codemarket.model.dao.GenericDAO;
import codemarket.model.vo.TbBairro;
import java.util.List;;

public class BairroRN {

    private GenericDAO<TbBairro> genericDao;

    public BairroRN() {
        genericDao = new GenericDAO<>();
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
    public List buscarTodos() {
        List<TbBairro> Bairros = genericDao.listarTodos(TbBairro.class);
        return Bairros;
    }
}
