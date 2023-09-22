package codemarket.model.dao;

import codemarket.model.pojo.TbBairro;
import java.util.List;

public interface BairroDAO {
    void salvar(TbBairro bairro);
    void atualizar(TbBairro bairro);
    void excluir(TbBairro bairro);
    List<TbBairro> listarTodos();
    TbBairro listarUm(int id);
}
