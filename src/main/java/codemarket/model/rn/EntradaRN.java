package codemarket.model.rn;
import codemarket.model.dao.GenericDAO;
import codemarket.model.vo.TbEntrada;
import java.util.List;;

public class EntradaRN {

    private GenericDAO<TbEntrada> genericDao;

    public EntradaRN() {
        genericDao = new GenericDAO<>();
    }

    public void salvar(TbEntrada Entrada) {
        genericDao.salvar(Entrada);
    }

    public void atualizar(TbEntrada Entrada) {
        genericDao.atualizar(Entrada);
    }

    public void excluir(TbEntrada Entrada) {
        genericDao.excluir(Entrada);
    }
    public List buscarTodos() {
        List<TbEntrada> Entradas = genericDao.listarTodos(TbEntrada.class);
        return Entradas;
    }
}
