package codemarket.model.rn;
import codemarket.model.dao.GenericDAO;
import codemarket.model.vo.TbEstoque;
import java.util.List;;

public class EstoqueRN {

    private GenericDAO<TbEstoque> genericDao;

    public EstoqueRN() {
        genericDao = new GenericDAO<>();
    }

    public void salvar(TbEstoque Estoque) {
        genericDao.salvar(Estoque);
    }

    public void atualizar(TbEstoque Estoque) {
        genericDao.atualizar(Estoque);
    }

    public void excluir(TbEstoque Estoque) {
        genericDao.excluir(Estoque);
    }
    public List buscarTodos() {
        List<TbEstoque> Estoques = genericDao.listarTodos(TbEstoque.class);
        return Estoques;
    }
}
