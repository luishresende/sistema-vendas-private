package codemarket.model.rm;
import codemarket.model.dao.ServicoDAO;
import codemarket.model.dao.ServicoDAOImpl;
import codemarket.model.pojo.TbServico;

public class ServicoRN {

    private ServicoDAO genericDao;

    public ServicoRN() {
        genericDao = new ServicoDAOImpl();
    }

    public void salvar(TbServico Servico) {
        genericDao.salvar(Servico);
    }

    public void atualizar(TbServico Servico) {
        genericDao.atualizar(Servico);
    }

    public void excluir(TbServico Servico) {
        genericDao.excluir(Servico);
    }
}
