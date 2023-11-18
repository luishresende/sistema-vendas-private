package codemarket.model.rn;
import codemarket.model.dao.GenericDAO;
import codemarket.model.vo.TbCidEstPai;
import codemarket.model.vo.TbLogradouro;
import java.util.ArrayList;
import java.util.List;import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import static javafx.scene.paint.Color.BLACK;
import static javafx.scene.paint.Color.RED;
;

public class LogradouroRN {

    private GenericDAO<TbLogradouro> genericDao;

    public LogradouroRN() {
        genericDao = new GenericDAO<>();
    }

    public void salvar(TbLogradouro Logradouro) {
        genericDao.salvar(Logradouro);
    }

    public void atualizar(TbLogradouro Logradouro) {
        genericDao.atualizar(Logradouro);
    }

    public void excluir(TbLogradouro Logradouro) {
        genericDao.excluir(Logradouro);
    }
    public List buscarTodos(String coluna) {
        List<TbLogradouro> Logradouros = genericDao.listarTodos(TbLogradouro.class, coluna);
        return Logradouros;
    }
    public TbLogradouro listaUm(String pesquisa, String valor, Class classe) {
        String jpql = "SELECT t FROM " + classe.getTypeName() + "t where t." + pesquisa + " = '" + valor + "'";
        TbLogradouro obj = genericDao.listarUm(pesquisa, valor, classe);
        return obj;
    }
    public List pesquisar(String jpql) {
        List obj = genericDao.pesquisar(jpql);
        return obj;
    }
    public ArrayList<String> validarLogradouro(TbLogradouro logradouro) {
        ArrayList<String> errors = new ArrayList<String>();
        if(logradouro.getLogDescricao().isEmpty()){
            errors.add("Selecione o logradouro.");
        }
        return errors;
    }
    public boolean validarCampo(ComboBox<String> tipoLOG) {
        if (tipoLOG.getValue() == null) {
            return true;
        } else {
            return false;
        }
    }
}
