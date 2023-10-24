package codemarket.model.rm;
import codemarket.model.dao.CargoDAO;
import codemarket.model.dao.CargoDAOImpl;
import codemarket.model.pojo.TbCargo;

public class CargoRN {

    private CargoDAO genericDao;

    public CargoRN() {
        genericDao = new CargoDAOImpl();
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
}
