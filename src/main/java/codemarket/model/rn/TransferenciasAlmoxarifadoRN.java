package codemarket.model.rn;
import codemarket.model.dao.GenericDAO;
import codemarket.model.vo.TbTransferenciasAlmoxarifado;

public class TransferenciasAlmoxarifadoRN {

    private GenericDAO<TbTransferenciasAlmoxarifado> genericDao;

    public TransferenciasAlmoxarifadoRN() {
        genericDao = new GenericDAO<>();
    }

    public void salvar(TbTransferenciasAlmoxarifado TransferenciasAlmoxarifado) {
        genericDao.salvar(TransferenciasAlmoxarifado);
    }

    public void atualizar(TbTransferenciasAlmoxarifado TransferenciasAlmoxarifado) {
        genericDao.atualizar(TransferenciasAlmoxarifado);
    }

    public void excluir(TbTransferenciasAlmoxarifado TransferenciasAlmoxarifado) {
        genericDao.excluir(TransferenciasAlmoxarifado);
    }
}
