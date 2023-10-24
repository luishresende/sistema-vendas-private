package codemarket.model.rm;
import codemarket.model.dao.AlmoxarifadoHasEstoqueDAO;
import codemarket.model.dao.AlmoxarifadoHasEstoqueDAOImpl;
import codemarket.model.pojo.TbAlmoxarifadoHasEstoque;

public class AlmoxarifadoHasEstoqueRN {

    private AlmoxarifadoHasEstoqueDAO genericDao;

    public AlmoxarifadoHasEstoqueRN() {
        genericDao = new AlmoxarifadoHasEstoqueDAOImpl();
    }

    public void salvar(TbAlmoxarifadoHasEstoque AlmoxarifadoHasEstoque) {
        genericDao.salvar(AlmoxarifadoHasEstoque);
    }

    public void atualizar(TbAlmoxarifadoHasEstoque AlmoxarifadoHasEstoque) {
        genericDao.atualizar(AlmoxarifadoHasEstoque);
    }

    public void excluir(TbAlmoxarifadoHasEstoque AlmoxarifadoHasEstoque) {
        genericDao.excluir(AlmoxarifadoHasEstoque);
    }
}
