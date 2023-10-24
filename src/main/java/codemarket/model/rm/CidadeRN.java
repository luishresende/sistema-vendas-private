package codemarket.model.rm;
import codemarket.model.dao.CidadeDAO;
import codemarket.model.dao.CidadeDAOImpl;
import codemarket.model.pojo.TbCidade;

public class CidadeRN {

    private CidadeDAO genericDao;

    public CidadeRN() {
        genericDao = new CidadeDAOImpl();
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
