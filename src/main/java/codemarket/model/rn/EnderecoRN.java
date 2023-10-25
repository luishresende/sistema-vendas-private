package codemarket.model.rn;
import codemarket.model.dao.GenericDAO;
import codemarket.model.vo.TbEndereco;

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
}
