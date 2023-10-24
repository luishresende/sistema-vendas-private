package codemarket.model.dao;

import codemarket.model.pojo.TbCargo;
import codemarket.model.pojo.TbEstado;
import java.util.List;

public interface CargoDAO {
    public void salvar(TbCargo cargo);
    public void excluir(TbCargo cargo);
    public void atualizar(TbCargo cargo);
    public List<String> listarCargos();
}
