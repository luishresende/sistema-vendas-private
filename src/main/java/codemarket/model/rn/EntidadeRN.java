package codemarket.model.rn;
import codemarket.model.dao.GenericDAO;
import codemarket.model.vo.TbEntidade;

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
}
