package codemarket.model.rm;
import codemarket.model.dao.SexoDAO;
import codemarket.model.dao.SexoDAOImpl;
import codemarket.model.pojo.TbSexo;

public class SexoRN {

    private SexoDAO genericDao;

    public SexoRN() {
        genericDao = new SexoDAOImpl();
    }

    public void salvar(TbSexo Sexo) {
        genericDao.salvar(Sexo);
    }

    public void atualizar(TbSexo Sexo) {
        genericDao.atualizar(Sexo);
    }

    public void excluir(TbSexo Sexo) {
        genericDao.excluir(Sexo);
    }
}
