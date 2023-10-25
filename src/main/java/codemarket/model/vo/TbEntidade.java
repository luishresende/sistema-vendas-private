/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codemarket.model.vo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author kauan
 */
@Entity
@Table(name = "tb_entidade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbEntidade.findAll", query = "SELECT t FROM TbEntidade t"),
    @NamedQuery(name = "TbEntidade.findByEntNome", query = "SELECT t FROM TbEntidade t WHERE t.entNome = :entNome"),
    @NamedQuery(name = "TbEntidade.findByEntnomeFantasia", query = "SELECT t FROM TbEntidade t WHERE t.entnomeFantasia = :entnomeFantasia"),
    @NamedQuery(name = "TbEntidade.findByEntcpfCnpj", query = "SELECT t FROM TbEntidade t WHERE t.entcpfCnpj = :entcpfCnpj"),
    @NamedQuery(name = "TbEntidade.findByEntrgIe", query = "SELECT t FROM TbEntidade t WHERE t.entrgIe = :entrgIe"),
    @NamedQuery(name = "TbEntidade.findByEntFone", query = "SELECT t FROM TbEntidade t WHERE t.entFone = :entFone"),
    @NamedQuery(name = "TbEntidade.findByEntEmail", query = "SELECT t FROM TbEntidade t WHERE t.entEmail = :entEmail"),
    @NamedQuery(name = "TbEntidade.findByEntdtNasc", query = "SELECT t FROM TbEntidade t WHERE t.entdtNasc = :entdtNasc"),
    @NamedQuery(name = "TbEntidade.findByEntTipo", query = "SELECT t FROM TbEntidade t WHERE t.entTipo = :entTipo")})
public class TbEntidade implements Serializable {
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
    @Column(name = "ent_fone")
    private String entFone;
    @Basic(optional = false)
    @Column(name = "ent_email")
    private String entEmail;
    @Column(name = "ent_dtNasc")
    @Temporal(TemporalType.DATE)
    private Date entdtNasc;
    @Basic(optional = false)
    @Column(name = "ent_tipo")
    private String entTipo;
    @ManyToMany(mappedBy = "tbEntidadeCollection")
    private Collection<TbEndereco> tbEnderecoCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "forcpfCnpj")
    private TbFornecedor tbFornecedor;
    @JoinColumn(name = "ent_endereco_principal", referencedColumnName = "end_id")
    @ManyToOne(optional = false)
    private TbEndereco entEnderecoPrincipal;
    @JoinColumn(name = "ent_sexo", referencedColumnName = "sex_id")
    @ManyToOne
    private TbSexo entSexo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "funcEntId")
    private Collection<TbFuncionario> tbFuncionarioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "filEntidade")
    private Collection<TbFilial> tbFilialCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "clicpfCnpj")
    private TbCliente tbCliente;

    public TbEntidade() {
    }

    public TbEntidade(String entcpfCnpj) {
        this.entcpfCnpj = entcpfCnpj;
    }

    public TbEntidade(String entcpfCnpj, String entNome, String entnomeFantasia, String entrgIe, String entFone, String entEmail, String entTipo) {
        this.entcpfCnpj = entcpfCnpj;
        this.entNome = entNome;
        this.entnomeFantasia = entnomeFantasia;
        this.entrgIe = entrgIe;
        this.entFone = entFone;
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

    public String getEntFone() {
        return entFone;
    }

    public void setEntFone(String entFone) {
        this.entFone = entFone;
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

    @XmlTransient
    public Collection<TbEndereco> getTbEnderecoCollection() {
        return tbEnderecoCollection;
    }

    public void setTbEnderecoCollection(Collection<TbEndereco> tbEnderecoCollection) {
        this.tbEnderecoCollection = tbEnderecoCollection;
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

    @XmlTransient
    public Collection<TbFuncionario> getTbFuncionarioCollection() {
        return tbFuncionarioCollection;
    }

    public void setTbFuncionarioCollection(Collection<TbFuncionario> tbFuncionarioCollection) {
        this.tbFuncionarioCollection = tbFuncionarioCollection;
    }

    @XmlTransient
    public Collection<TbFilial> getTbFilialCollection() {
        return tbFilialCollection;
    }

    public void setTbFilialCollection(Collection<TbFilial> tbFilialCollection) {
        this.tbFilialCollection = tbFilialCollection;
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
    
}
