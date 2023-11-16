package codemarket.model.rn;
import codemarket.model.dao.GenericDAO;
import codemarket.model.vo.TbEndPostal;
import java.util.List;import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import static javafx.scene.paint.Color.BLACK;
import static javafx.scene.paint.Color.RED;
;

public class EndPostalRN {

    private GenericDAO<TbEndPostal> genericDao;

    public EndPostalRN() {
        genericDao = new GenericDAO<>();
    }

    public void salvar(TbEndPostal EndPostal) {
        genericDao.salvar(EndPostal);
    }

    public void atualizar(TbEndPostal EndPostal) {
        genericDao.atualizar(EndPostal);
    }

    public void excluir(TbEndPostal EndPostal) {
        genericDao.excluir(EndPostal);
    }
    public List buscarTodos(String coluna) {
        List<TbEndPostal> EndPostals = genericDao.listarTodos(TbEndPostal.class, coluna);
        return EndPostals;
    }
    public TbEndPostal listaUm(String pesquisa, String valor, Class classe) {
        String jpql = "SELECT t FROM " + classe.getTypeName() + "t where t." + pesquisa + " = '" + valor + "'";
        TbEndPostal obj = genericDao.listarUm(pesquisa, valor, classe);
        return obj;
    }
    public List pesquisar(String jpql) {
        List obj = genericDao.pesquisar(jpql);
        return obj;
    }
    public boolean validarCampoNomeRua(TextField nomerua) {
        if (nomerua.getText().trim().isEmpty()) {
            return true;
        } else {
            
            return false;
        }
    }
    public boolean validarCampoCEP(TextField CEP) {
        if (CEP.getText().trim().isEmpty()) {
            return true;
        } else {
            
            return false;
        }
    }
}
