package codemarket.model.dao;

import codemarket.model.pojo.TbEstado;
import java.util.List;

public interface CidEstDAO {
    public List<String> listarCidades(TbEstado estado);
}
