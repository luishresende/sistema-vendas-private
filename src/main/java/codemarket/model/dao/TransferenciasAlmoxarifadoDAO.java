package codemarket.model.dao;

import codemarket.model.pojo.TbTransferenciasAlmoxarifado;
import java.util.List;

public interface TransferenciasAlmoxarifadoDAO {
    void salvar(TbTransferenciasAlmoxarifado transferencias);
    void atualizar(TbTransferenciasAlmoxarifado transferencias);
    void excluir(TbTransferenciasAlmoxarifado transferencias);
    List<TbTransferenciasAlmoxarifado> listarTodos();
    TbTransferenciasAlmoxarifado listarUm(int id);
}
