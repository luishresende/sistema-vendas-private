package codemarket.model.dao;

import codemarket.model.pojo.TbCidEst;
import java.util.List;

public interface CidEstDAO {
    void salvar(TbCidEst cidest);
    void atualizar(TbCidEst cidest);
    void excluir(TbCidEst cidest);
    List<TbCidEst> listarTodos();
    TbCidEst listarUm(int id);
}
