package codemarket.model.rm;
import codemarket.model.dao.AlmoxarifadoDAO;
import codemarket.model.dao.AlmoxarifadoDAOImpl;
import codemarket.model.pojo.TbAlmoxarifado;

public class AlmoxarifadoRN {

    private AlmoxarifadoDAO genericDao;

    public AlmoxarifadoRN() {
        genericDao = new AlmoxarifadoDAOImpl();
    }

    public void salvar(TbAlmoxarifado Almoxarifado) {
        genericDao.salvar(Almoxarifado);
    }

    public void atualizar(TbAlmoxarifado Almoxarifado) {
        genericDao.atualizar(Almoxarifado);
    }

    public void excluir(TbAlmoxarifado Almoxarifado) {
        genericDao.excluir(Almoxarifado);
    }
}
