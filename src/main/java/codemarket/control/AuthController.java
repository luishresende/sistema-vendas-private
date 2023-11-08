package codemarket.control;

import codemarket.model.rn.UsuarioRN;
import codemarket.model.vo.TbUsuario;
import java.util.List;

public class AuthController {
    private String username;
    private String password;

    public AuthController(String username, String password) {
        this.username = username;
        this.password = password;
    }

    private String getUsername() {
        return username;
    }

    private void setUsername(String username) {
        this.username = username;
    }

    private String getPassword() {
        return password;
    }

    private void setPassword(String password) {
        this.password = password;
    }
    
    public TbUsuario authenticate(){
        UsuarioRN userRN = new UsuarioRN();
        //" + getUsername() + "' AND t.usuSenha='" + getPassword() + "'
        List user = userRN.pesquisar("SELECT t FROM TbUsuario t WHERE t.usuUsuario='" + getUsername() + "' AND t.usuSenha='" + getPassword() + "'");
        if(user.isEmpty()){
            return null;
        }
        System.out.println("Consulta feita com sucesso! Retornou resultado.");
        return (TbUsuario) user.get(0);
    }
}
