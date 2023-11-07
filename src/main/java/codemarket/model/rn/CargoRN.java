package codemarket.model.rn;
import codemarket.model.dao.GenericDAO;
import codemarket.model.vo.TbCargo;
import java.util.List;;

public class CargoRN {

    private GenericDAO<TbCargo> genericDao;

    public CargoRN() {
        genericDao = new GenericDAO<>();
    }

    public void salvar(TbCargo Cargo) {
        genericDao.salvar(Cargo);
    }

    public void atualizar(TbCargo Cargo) {
        genericDao.atualizar(Cargo);
    }

    public void excluir(TbCargo Cargo) {
        genericDao.excluir(Cargo);
    }
    public List buscarTodos(String coluna) {
        List<TbCargo> Cargos = genericDao.listarTodos(TbCargo.class, coluna);
        return Cargos;
    }
    public TbCargo listaUm(String pesquisa, String valor, Class classe) {
        String jpql = "SELECT t FROM " + classe.getTypeName() + "t where t." + pesquisa + " = '" + valor + "'";
        TbCargo obj = genericDao.listarUm(pesquisa, valor, classe);
        return obj;
    }
}
