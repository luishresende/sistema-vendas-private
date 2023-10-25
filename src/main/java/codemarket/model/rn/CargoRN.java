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
    public List buscarTodos() {
        List<TbCargo> Cargos = genericDao.listarTodos(TbCargo.class);
        return Cargos;
    }
}
