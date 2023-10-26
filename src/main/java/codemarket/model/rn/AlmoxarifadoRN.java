package codemarket.model.rn;
import codemarket.model.dao.GenericDAO;
import codemarket.model.vo.TbAlmoxarifado;
import java.util.List;;

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
    public List buscarTodos() {
        List<TbAlmoxarifado> Almoxarifados = genericDao.listarTodos(TbAlmoxarifado.class);
        return Almoxarifados;
    }
    public TbAlmoxarifado listaUm(String pesquisa, String valor, Class classe) {
        String jpql = "SELECT t FROM " + classe.getTypeName() + "t where t." + pesquisa + " = '" + valor + "'";
        TbAlmoxarifado obj = genericDao.listarUm(pesquisa, valor, classe);
        return obj;
    }
}
