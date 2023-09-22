package codemarket.model.dao;

import codemarket.model.pojo.TbUnidadeMedida;
import java.util.List;

public interface UnidadeMedidaDAO {
    void salvar(TbUnidadeMedida unidademedida);
    void atualizar(TbUnidadeMedida unidademedida);
    void excluir(TbUnidadeMedida unidademedida);
    List<TbUnidadeMedida> listarTodos();
    TbUnidadeMedida listarUm(int id);
}
