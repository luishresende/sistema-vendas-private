package codemarket.model.rn;
import codemarket.model.dao.GenericDAO;
import codemarket.model.vo.TbAlmoxarifado;

public class AlmoxarifadoRN {

    private GenericDAO<TbAlmoxarifado> genericDao;

    public AlmoxarifadoRN() {
        genericDao = new GenericDAO<>();
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
