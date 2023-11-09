package codemarket.control;

import codemarket.model.rn.UsuarioRN;
import codemarket.model.vo.TbUsuario;
import java.util.List;

public class AuthController {

    private TbUsuario user;
    private static AuthController auth;

    // Aplicação do modelo Skeleton, para ser utilizada a mesma instância afim de obter o usuário que logou no sistema
    public static AuthController getInstance() {
        if (auth == null) {
            synchronized (AuthController.class) {
                if (auth == null) {
                    AuthController.auth = new AuthController();
                }
            }
        }
        return auth;
    }

    public boolean authenticate(String username, String password) {
        UsuarioRN userRN = new UsuarioRN();
        // Verifico se existe um usuário com as credenciais informados, considerando diferença entre letras maiusculas e minusculas
        List userList = userRN.pesquisar("SELECT t FROM TbUsuario t WHERE FUNCTION('BINARY', t.usuUsuario)='" + username + "' AND FUNCTION('BINARY', t.usuSenha)='" + password + "'");
        if (userList.isEmpty()) {
            return false;
        }

        setUser((TbUsuario) userList.get(0));
        return true;
    }

    public TbUsuario getUser() {
        return user;
    }

    public void setUser(TbUsuario user) {
        this.user = user;
    }

}
