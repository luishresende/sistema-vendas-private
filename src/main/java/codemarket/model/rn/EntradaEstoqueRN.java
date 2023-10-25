package codemarket.model.rn;
import codemarket.model.dao.GenericDAO;
import codemarket.model.vo.TbEntradaEstoque;
import java.util.List;;

public class EntradaEstoqueRN {

    private GenericDAO<TbEntradaEstoque> genericDao;

    public EntradaEstoqueRN() {
        genericDao = new GenericDAO<>();
    }

    public void salvar(TbEntradaEstoque EntradaEstoque) {
        genericDao.salvar(EntradaEstoque);
    }

    public void atualizar(TbEntradaEstoque EntradaEstoque) {
        genericDao.atualizar(EntradaEstoque);
    }

    public void excluir(TbEntradaEstoque EntradaEstoque) {
        genericDao.excluir(EntradaEstoque);
    }
    public List buscarTodos() {
        List<TbEntradaEstoque> EntradaEstoques = genericDao.listarTodos(TbEntradaEstoque.class);
        return EntradaEstoques;
    }
}
