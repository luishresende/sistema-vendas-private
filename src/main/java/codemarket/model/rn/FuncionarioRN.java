package codemarket.model.rn;
import codemarket.model.dao.GenericDAO;
import codemarket.model.utils.DisplayDialogScreen;
import codemarket.model.vo.TbFuncionario;
import java.util.List;import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyEvent;
;

public class FuncionarioRN {

    private GenericDAO<TbFuncionario> genericDao;

    public FuncionarioRN() {
        genericDao = new GenericDAO<>();
    }

    public void salvar(TbFuncionario Funcionario) {
        genericDao.salvar(Funcionario);
    }

    public void atualizar(TbFuncionario Funcionario) {
        genericDao.atualizar(Funcionario);
    }

    public void excluir(TbFuncionario Funcionario) {
        genericDao.excluir(Funcionario);
    }
    public List buscarTodos(String coluna) {
        List<TbFuncionario> Funcionarios = genericDao.listarTodos(TbFuncionario.class, coluna);
        return Funcionarios;
    }
    public TbFuncionario listaUm(String pesquisa, String valor, Class classe) {
        String jpql = "SELECT t FROM " + classe.getTypeName() + "t where t." + pesquisa + " = '" + valor + "'";
        TbFuncionario obj = genericDao.listarUm(pesquisa, valor, classe);
        return obj;
    }
    public List pesquisar(String jpql) {
        List obj = genericDao.pesquisar(jpql);
        return obj;
    }
    
    public void validarCPF(KeyEvent event, TextField cpf) {
        String texto = cpf.getText();
        if (!texto.matches("[0-9]*")) {
            // Só aceita valores numéricos
            cpf.setText(texto.replaceAll("[^0-9]", ""));
        }
        if (texto.length() == 11) {
            // Formatação para CPF "999.999.999-99"
            cpf.setText(texto.substring(0, 3) + "." + texto.substring(3, 6) + "." + texto.substring(6, 9) + "-" + texto.substring(9, 11));
        }
    }
    public boolean validarCPF(TextField cpf) {
        String texto = cpf.getText();
        if (cpf.getText().trim().isEmpty() && texto.length() != 14) {
            return true;
        } else {
            return false;
        }
    }
    public void handleFocusLostCPFCNPJ(InputEvent event, TextField cpf) {
        String texto = cpf.getText();
        if(texto.length() != 14){
            DisplayDialogScreen.getInstance().displayErrorScreen("CPF", "Verifique os dados inseridos!", "Preencha corretamente o campo CPF.");
        }
    }
    
    public void handleFocusLostRG(InputEvent event, TextField rg) {
        String texto = rg.getText();
        if (texto.length() != 14) {
            DisplayDialogScreen.getInstance().displayErrorScreen("Inscrição Estadual", "Verifique os dados inseridos!", "Preencha corretamente o campo Inscrição Estadual.");
        }
    }
}
