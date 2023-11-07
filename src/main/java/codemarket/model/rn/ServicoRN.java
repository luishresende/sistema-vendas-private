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
    public List buscarTodos(String coluna) {
        List<TbServico> Servicos = genericDao.listarTodos(TbServico.class, coluna);
        return Servicos;
    }
    public TbServico listaUm(String pesquisa, String valor, Class classe) {
        String jpql = "SELECT t FROM " + classe.getTypeName() + "t where t." + pesquisa + " = '" + valor + "'";
        TbServico obj = genericDao.listarUm(pesquisa, valor, classe);
        return obj;
    }
}
