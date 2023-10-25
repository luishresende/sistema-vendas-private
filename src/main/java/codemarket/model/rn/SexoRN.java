package codemarket.model.rn;
import codemarket.model.dao.GenericDAO;
import codemarket.model.vo.TbSexo;
import java.util.List;;

public class SexoRN {

    private GenericDAO<TbSexo> genericDao;

    public SexoRN() {
        genericDao = new GenericDAO<>();
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
    public List buscarTodos() {
        List<TbSexo> Sexos = genericDao.listarTodos(TbSexo.class);
        return Sexos;
    }
}
