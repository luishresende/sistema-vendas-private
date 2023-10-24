package codemarket.model.rm;
import codemarket.model.dao.OrdemServicoDAO;
import codemarket.model.dao.OrdemServicoDAOImpl;
import codemarket.model.pojo.TbOrdemServico;

public class OrdemServicoRN {

    private OrdemServicoDAO genericDao;

    public OrdemServicoRN() {
        genericDao = new OrdemServicoDAOImpl();
    }

    public void salvar(TbOrdemServico OrdemServico) {
        genericDao.salvar(OrdemServico);
    }

    public void atualizar(TbOrdemServico OrdemServico) {
        genericDao.atualizar(OrdemServico);
    }

    public void excluir(TbOrdemServico OrdemServico) {
        genericDao.excluir(OrdemServico);
    }
}
