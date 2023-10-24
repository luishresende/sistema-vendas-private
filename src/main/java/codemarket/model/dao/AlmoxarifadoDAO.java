package codemarket.model.dao;

import codemarket.model.pojo.TbAlmoxarifado;
import java.util.List;

public interface AlmoxarifadoDAO {
    public void salvar(TbAlmoxarifado almoxarifado);
    public void excluir(TbAlmoxarifado almoxarifado);
    public void atualizar(TbAlmoxarifado almoxarifado);
    public List<String> listarAlmoxarifados();
}
