package codemarket.model.rn;
import codemarket.model.dao.GenericDAO;
import codemarket.model.vo.TbEntidade;
import java.util.List;;

public class EntidadeRN {

    private GenericDAO<TbEntidade> genericDao;

    public EntidadeRN() {
        genericDao = new GenericDAO<>();
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
    public List buscarTodos() {
        List<TbEntidade> Entidades = genericDao.listarTodos(TbEntidade.class);
        return Entidades;
    }
}
