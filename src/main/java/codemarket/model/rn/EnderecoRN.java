package codemarket.model.rn;
import codemarket.model.dao.GenericDAO;
import codemarket.model.vo.TbEndereco;
import java.util.List;;

public class EnderecoRN {

    private GenericDAO<TbEndereco> genericDao;

    public EnderecoRN() {
        genericDao = new GenericDAO<>();
    }

    public void salvar(TbEndereco Endereco) {
        genericDao.salvar(Endereco);
    }

    public void atualizar(TbEndereco Endereco) {
        genericDao.atualizar(Endereco);
    }

    public void excluir(TbEndereco Endereco) {
        genericDao.excluir(Endereco);
    }
    public List buscarTodos(String coluna) {
        List<TbEndereco> Enderecos = genericDao.listarTodos(TbEndereco.class, coluna);
        return Enderecos;
    }
    public TbEndereco listaUm(String pesquisa, String valor, Class classe) {
        String jpql = "SELECT t FROM " + classe.getTypeName() + "t where t." + pesquisa + " = '" + valor + "'";
        TbEndereco obj = genericDao.listarUm(pesquisa, valor, classe);
        return obj;
    }
}
