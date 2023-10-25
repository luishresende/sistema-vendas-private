package codemarket.model.rn;
import codemarket.model.dao.GenericDAO;
import codemarket.model.vo.TbOrdemServico;
import java.util.List;;

public class OrdemServicoRN {

    private GenericDAO<TbOrdemServico> genericDao;

    public OrdemServicoRN() {
        genericDao = new GenericDAO<>();
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
    public List buscarTodos() {
        List<TbOrdemServico> OrdemServicos = genericDao.listarTodos(TbOrdemServico.class);
        return OrdemServicos;
    }
}
