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
    public List buscarTodos(String coluna) {
        List<TbSexo> Sexos = genericDao.listarTodos(TbSexo.class, coluna);
        return Sexos;
    }
    public TbSexo listaUm(String pesquisa, String valor, Class classe) {
        String jpql = "SELECT t FROM " + classe.getTypeName() + "t where t." + pesquisa + " = '" + valor + "'";
        TbSexo obj = genericDao.listarUm(pesquisa, valor, classe);
        return obj;
    }
}
