package codemarket.model.rn;
import codemarket.model.dao.GenericDAO;
import codemarket.model.utils.DisplayDialogScreen;
import codemarket.model.vo.TbEndPostal;
import codemarket.model.vo.TbSexo;
import java.util.ArrayList;
import java.util.List;import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyEvent;
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
    // Valida CEP
    public void validarCEP(KeyEvent event, TextField cep) {
        String texto = cep.getText();
        if (!texto.matches("[0-9]*")) {
            cep.setText(texto.replaceAll("[^0-9]", ""));
        }
        if (texto.length() == 8) {
            cep.setText(texto.substring(0, 5) + "-" + texto.substring(5, 8));
        }
        cep.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.length() > 9) {
                cep.setText(oldValue);
            }
        });
    }
    public void handleFocusLostCEP(InputEvent event, TextField cep) {
        // Chama o método existente para validar e formatar
        String texto = cep.getText();
        if (texto.length() != 9) {
            DisplayDialogScreen.getInstance().displayErrorScreen("Aviso", "Campo CEP", "Preencha corretamente o campo CEP.");
        }
    }
    public ArrayList<String> validarEnderecoPostal(TbEndPostal endereco) {
        ArrayList<String> errors = new ArrayList<String>();
        if(endereco.getEndPnomerua().isEmpty()){
            errors.add("Informe o endereço.");
        }
        if(!endereco.getEndCEP().isEmpty()){
            String cep = endereco.getEndCEP();
            if(cep.length() != 9){
                errors.add("Informe o CEP.");
            }
        } else {
            errors.add("Preencha o campo CEP.");
        }
        return errors;
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
