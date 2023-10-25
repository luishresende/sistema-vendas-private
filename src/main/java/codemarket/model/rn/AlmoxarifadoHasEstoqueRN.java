package codemarket.model.rn;
import codemarket.model.dao.GenericDAO;
import codemarket.model.vo.TbAlmoxarifadoHasEstoque;

public class AlmoxarifadoHasEstoqueRN {

    private GenericDAO<TbAlmoxarifadoHasEstoque> genericDao;

    public AlmoxarifadoHasEstoqueRN() {
        genericDao = new GenericDAO<>();
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
