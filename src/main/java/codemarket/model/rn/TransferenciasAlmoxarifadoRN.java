package codemarket.model.rn;
import codemarket.model.dao.GenericDAO;
import codemarket.model.vo.TbTransferenciasAlmoxarifado;
import java.util.List;;

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
    public List buscarTodos() {
        List<TbTransferenciasAlmoxarifado> TransferenciasAlmoxarifados = genericDao.listarTodos(TbTransferenciasAlmoxarifado.class);
        return TransferenciasAlmoxarifados;
    }
    public TbTransferenciasAlmoxarifado listaUm(String pesquisa, String valor, Class classe) {
        String jpql = "SELECT t FROM " + classe.getTypeName() + "t where t." + pesquisa + " = '" + valor + "'";
        TbTransferenciasAlmoxarifado obj = genericDao.listarUm(pesquisa, valor, classe);
        return obj;
    }
}
