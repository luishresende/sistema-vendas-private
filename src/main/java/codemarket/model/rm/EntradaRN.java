package codemarket.model.rm;
import codemarket.model.dao.EntradaDAO;
import codemarket.model.dao.EntradaDAOImpl;
import codemarket.model.pojo.TbEntrada;

public class EntradaRN {

    private EntradaDAO genericDao;

    public EntradaRN() {
        genericDao = new EntradaDAOImpl();
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
}
