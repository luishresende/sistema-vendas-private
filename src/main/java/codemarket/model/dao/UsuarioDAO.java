package codemarket.model.dao;

import codemarket.model.pojo.TbUsuario;
import java.util.List;


public interface UsuarioDAO {
    void salvar(TbUsuario usuario);
    void atualizar(TbUsuario usuario);
    void excluir(TbUsuario usuario);
    List<TbUsuario> listarTodos();
    TbUsuario listarUm(String id);
}
