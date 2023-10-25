package codemarket.model.rn;
import codemarket.model.dao.GenericDAO;
import codemarket.model.vo.TbServico;
import java.util.List;;

public class ServicoRN {

    private GenericDAO<TbServico> genericDao;

    public ServicoRN() {
        genericDao = new GenericDAO<>();
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
    public List buscarTodos() {
        List<TbServico> Servicos = genericDao.listarTodos(TbServico.class);
        return Servicos;
    }
}
