package codemarket.model.rm;
import codemarket.model.dao.TransferenciasAlmoxarifadoDAO;
import codemarket.model.dao.TransferenciasAlmoxarifadoDAOImpl;
import codemarket.model.pojo.TbTransferenciasAlmoxarifado;

public class TransferenciasAlmoxarifadoRN {

    private TransferenciasAlmoxarifadoDAO genericDao;

    public TransferenciasAlmoxarifadoRN() {
        genericDao = new TransferenciasAlmoxarifadoDAOImpl();
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
