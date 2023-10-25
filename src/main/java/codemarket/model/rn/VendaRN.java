package codemarket.model.rn;
import codemarket.model.dao.GenericDAO;
import codemarket.model.vo.TbVenda;
import java.util.List;;

public class VendaRN {

    private GenericDAO<TbVenda> genericDao;

    public VendaRN() {
        genericDao = new GenericDAO<>();
    }

    public void salvar(TbVenda Venda) {
        genericDao.salvar(Venda);
    }

    public void atualizar(TbVenda Venda) {
        genericDao.atualizar(Venda);
    }

    public void excluir(TbVenda Venda) {
        genericDao.excluir(Venda);
    }
    public List buscarTodos() {
        List<TbVenda> Vendas = genericDao.listarTodos(TbVenda.class);
        return Vendas;
    }
}
