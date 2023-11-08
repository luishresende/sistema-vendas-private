/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codemarket.model.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author kauan
 */
@Entity
@Table(name = "tb_entidade")
@NamedQueries({
    @NamedQuery(name = "TbEntidade.findAll", query = "SELECT t FROM TbEntidade t")})
public class TbEntidade implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eeentcpfCnpj")
    private List<TbEntidadeHasEndereco> tbEntidadeHasEnderecoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ehtentcpfCnpj")
    private List<TbEntidadeHasTelefone> tbEntidadeHasTelefoneList;
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "ent_nome")
    private String entNome;
    @Basic(optional = false)
    @Column(name = "ent_nomeFantasia")
    private String entnomeFantasia;
    @Id
    @Basic(optional = false)
    @Column(name = "ent_cpfCnpj")
    private String entcpfCnpj;
    @Basic(optional = false)
    @Column(name = "ent_rgIe")
    private String entrgIe;
    @Basic(optional = false)
    @Column(name = "ent_email")
    private String entEmail;
    @Column(name = "ent_dtNasc")
    @Temporal(TemporalType.DATE)
    private Date entdtNasc;
    @Basic(optional = false)
    @Column(name = "ent_tipo")
    private String entTipo;
    @ManyToMany(mappedBy = "tbEntidadeList")
    private List<TbEndereco> tbEnderecoList;
    @JoinTable(name = "tb_entidade_has_telefone", joinColumns = {
        @JoinColumn(name = "eht_ent_cpfCnpj", referencedColumnName = "ent_cpfCnpj")}, inverseJoinColumns = {
        @JoinColumn(name = "eht_fone_id", referencedColumnName = "fone_id")})
    @ManyToMany
    private List<TbTelefone> tbTelefoneList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "forcpfCnpj")
    private TbFornecedor tbFornecedor;
    @JoinColumn(name = "ent_endereco_principal", referencedColumnName = "end_id")
    @ManyToOne(optional = false)
    private TbEndereco entEnderecoPrincipal;
    @JoinColumn(name = "ent_sexo", referencedColumnName = "sex_id")
    @ManyToOne
    private TbSexo entSexo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "funcentcpfCnpj")
    private List<TbFuncionario> tbFuncionarioList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "clicpfCnpj")
    private TbCliente tbCliente;

    public TbEntidade() {
    }

    public TbEntidade(String entcpfCnpj) {
        this.entcpfCnpj = entcpfCnpj;
    }

    public TbEntidade(String entcpfCnpj, String entNome, String entnomeFantasia, String entrgIe, String entEmail, String entTipo) {
        this.entcpfCnpj = entcpfCnpj;
        this.entNome = entNome;
        this.entnomeFantasia = entnomeFantasia;
        this.entrgIe = entrgIe;
        this.entEmail = entEmail;
        this.entTipo = entTipo;
    }

    public String getEntNome() {
        return entNome;
    }

    public void setEntNome(String entNome) {
        this.entNome = entNome;
    }

    public String getEntnomeFantasia() {
        return entnomeFantasia;
    }

    public void setEntnomeFantasia(String entnomeFantasia) {
        this.entnomeFantasia = entnomeFantasia;
    }

    public String getEntcpfCnpj() {
        return entcpfCnpj;
    }

    public void setEntcpfCnpj(String entcpfCnpj) {
        this.entcpfCnpj = entcpfCnpj;
    }

    public String getEntrgIe() {
        return entrgIe;
    }

    public void setEntrgIe(String entrgIe) {
        this.entrgIe = entrgIe;
    }

    public String getEntEmail() {
        return entEmail;
    }

    public void setEntEmail(String entEmail) {
        this.entEmail = entEmail;
    }

    public Date getEntdtNasc() {
        return entdtNasc;
    }

    public void setEntdtNasc(Date entdtNasc) {
        this.entdtNasc = entdtNasc;
    }

    public String getEntTipo() {
        return entTipo;
    }

    public void setEntTipo(String entTipo) {
        this.entTipo = entTipo;
    }

    public List<TbEndereco> getTbEnderecoList() {
        return tbEnderecoList;
    }

    public void setTbEnderecoList(List<TbEndereco> tbEnderecoList) {
        this.tbEnderecoList = tbEnderecoList;
    }

    public List<TbTelefone> getTbTelefoneList() {
        return tbTelefoneList;
    }

    public void setTbTelefoneList(List<TbTelefone> tbTelefoneList) {
        this.tbTelefoneList = tbTelefoneList;
    }

    public TbFornecedor getTbFornecedor() {
        return tbFornecedor;
    }

    public void setTbFornecedor(TbFornecedor tbFornecedor) {
        this.tbFornecedor = tbFornecedor;
    }

    public TbEndereco getEntEnderecoPrincipal() {
        return entEnderecoPrincipal;
    }

    public void setEntEnderecoPrincipal(TbEndereco entEnderecoPrincipal) {
        this.entEnderecoPrincipal = entEnderecoPrincipal;
    }

    public TbSexo getEntSexo() {
        return entSexo;
    }

    public void setEntSexo(TbSexo entSexo) {
        this.entSexo = entSexo;
    }

    public List<TbFuncionario> getTbFuncionarioList() {
        return tbFuncionarioList;
    }

    public void setTbFuncionarioList(List<TbFuncionario> tbFuncionarioList) {
        this.tbFuncionarioList = tbFuncionarioList;
    }

    public TbCliente getTbCliente() {
        return tbCliente;
    }

    public void setTbCliente(TbCliente tbCliente) {
        this.tbCliente = tbCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (entcpfCnpj != null ? entcpfCnpj.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbEntidade)) {
            return false;
        }
        TbEntidade other = (TbEntidade) object;
        if ((this.entcpfCnpj == null && other.entcpfCnpj != null) || (this.entcpfCnpj != null && !this.entcpfCnpj.equals(other.entcpfCnpj))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "codemarket.model.vo.TbEntidade[ entcpfCnpj=" + entcpfCnpj + " ]";
    }

    public List<TbEntidadeHasEndereco> getTbEntidadeHasEnderecoList() {
        return tbEntidadeHasEnderecoList;
    }

    public void setTbEntidadeHasEnderecoList(List<TbEntidadeHasEndereco> tbEntidadeHasEnderecoList) {
        this.tbEntidadeHasEnderecoList = tbEntidadeHasEnderecoList;
    }

    public List<TbEntidadeHasTelefone> getTbEntidadeHasTelefoneList() {
        return tbEntidadeHasTelefoneList;
    }

    public void setTbEntidadeHasTelefoneList(List<TbEntidadeHasTelefone> tbEntidadeHasTelefoneList) {
        this.tbEntidadeHasTelefoneList = tbEntidadeHasTelefoneList;
    }
    
}
