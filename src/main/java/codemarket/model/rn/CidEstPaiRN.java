package codemarket.model.rn;
import codemarket.model.dao.GenericDAO;
import codemarket.model.vo.TbCidEstPai;
import java.util.List;import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import static javafx.scene.paint.Color.BLACK;
import static javafx.scene.paint.Color.RED;
;

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
    public List buscarTodos(String coluna) {
        List<TbCidEstPai> CidEstPais = genericDao.listarTodos(TbCidEstPai.class, coluna);
        return CidEstPais;
    }
    public TbCidEstPai listaUm(String pesquisa, String valor, Class classe) {
        String jpql = "SELECT t FROM " + classe.getTypeName() + "t where t." + pesquisa + " = '" + valor + "'";
        TbCidEstPai obj = genericDao.listarUm(pesquisa, valor, classe);
        return obj;
    }
    public List pesquisar(String jpql) {
        List obj = genericDao.pesquisar(jpql);
        return obj;
    }
    public boolean validarCampoPais(ComboBox<String> pais) {
        if (pais.getValue() == null) {
            return true;
        } else {
            return false;
        }
    }
    public boolean validarCampoEstado(ComboBox<String> estado) {
        if (estado.getValue() == null) {
            return true;
        } else {
            return false;
        }
    }
    public boolean validarCampoCidade(ComboBox<String> cidade) {
        if (cidade.getValue() == null) {
            return true;
        } else {
            return false;
        }
    }
}
