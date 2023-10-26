package codemarket.model.rn;
import codemarket.model.dao.GenericDAO;
import codemarket.model.vo.TbCidEstPai;
import java.util.List;;

public class CidEstPaiRN {

    private GenericDAO<TbCidEstPai> genericDao;

    public CidEstPaiRN() {
        genericDao = new GenericDAO<>();
    }

    public void salvar(TbCidEstPai CidEstPai) {
        genericDao.salvar(CidEstPai);
    }

    public void atualizar(TbCidEstPai CidEstPai) {
        genericDao.atualizar(CidEstPai);
    }

    public void excluir(TbCidEstPai CidEstPai) {
        genericDao.excluir(CidEstPai);
    }
    public List buscarTodos() {
        List<TbCidEstPai> CidEstPais = genericDao.listarTodos(TbCidEstPai.class);
        return CidEstPais;
    }
    public TbCidEstPai listaUm(String pesquisa, String valor, Class classe) {
        String jpql = "SELECT t FROM " + classe.getTypeName() + "t where t." + pesquisa + " = '" + valor + "'";
        TbCidEstPai obj = genericDao.listarUm(pesquisa, valor, classe);
        return obj;
    }
}
