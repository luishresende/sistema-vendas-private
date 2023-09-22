package codemarket.model.dao;

import codemarket.model.pojo.TbEstado;
import java.util.List;

public interface EstadoDAO {
    void salvar(TbEstado estado);
    void atualizar(TbEstado estado);
    void excluir(TbEstado estado);
    List<TbEstado> listarTodos();
    TbEstado listarUm(int id);
}
