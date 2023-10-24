package codemarket.model.rm;
import codemarket.model.dao.EnderecoDAO;
import codemarket.model.dao.EnderecoDAOImpl;
import codemarket.model.pojo.TbEndereco;

public class EnderecoRN {

    private EnderecoDAO genericDao;

    public EnderecoRN() {
        genericDao = new EnderecoDAOImpl();
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
}
