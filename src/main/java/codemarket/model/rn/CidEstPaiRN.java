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
}
