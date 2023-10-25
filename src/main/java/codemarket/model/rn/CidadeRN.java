package codemarket.model.rn;
import codemarket.model.dao.GenericDAO;
import codemarket.model.vo.TbCidade;

public class CidadeRN {

    private GenericDAO<TbCidade> genericDao;

    public CidadeRN() {
        genericDao = new GenericDAO<>();
    }

    public void salvar(TbCidade Cidade) {
        genericDao.salvar(Cidade);
    }

    public void atualizar(TbCidade Cidade) {
        genericDao.atualizar(Cidade);
    }

    public void excluir(TbCidade Cidade) {
        genericDao.excluir(Cidade);
    }
}
