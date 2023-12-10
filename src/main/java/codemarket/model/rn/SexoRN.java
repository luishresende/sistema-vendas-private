package codemarket.model.rn;
import codemarket.model.dao.GenericDAO;
import codemarket.model.vo.TbEntidade;
import codemarket.model.vo.TbSexo;
import java.util.ArrayList;
import java.util.List;import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import static javafx.scene.paint.Color.*;


public class SexoRN {

    private GenericDAO<TbSexo> genericDao;

    public SexoRN() {
        genericDao = new GenericDAO<>();
    }

    public void salvar(TbSexo Sexo) {
        genericDao.salvar(Sexo);
    }

    public void atualizar(TbSexo Sexo) {
        genericDao.atualizar(Sexo);
    }

    public void excluir(TbSexo Sexo) {
        genericDao.excluir(Sexo);
    }
    public List buscarTodos(String coluna) {
        List<TbSexo> Sexos = genericDao.listarTodos(TbSexo.class, coluna);
        return Sexos;
    }
    public TbSexo listaUm(String pesquisa, String valor, Class classe) {
        String jpql = "SELECT t FROM " + classe.getTypeName() + "t where t." + pesquisa + " = '" + valor + "'";
        TbSexo obj = genericDao.listarUm(pesquisa, valor, classe);
        return obj;
    }
    public List pesquisar(String jpql) {
        List obj = genericDao.pesquisar(jpql);
        return obj;
    }
    public TbSexo varificaSexo(ComboBox<String> tipoSexo, SexoRN sexorn) {
        //System.out.println(tipoSexo.getValue());
        TbSexo sexo = null;
        if (!tipoSexo.isDisable()) {
            sexo = sexorn.listaUm("sexDescricao", tipoSexo.getValue(), TbSexo.class);
        }
        //System.out.println(sexo.getSexDescricao());
        return sexo;
    }
    public boolean validarCampo(ComboBox<String> tipoSexo) {
        if (tipoSexo.getValue() == null) {
            return true;
        } else {
            return false;
        }
    }
}
