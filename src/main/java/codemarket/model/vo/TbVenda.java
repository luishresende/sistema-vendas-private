package codemarket.model.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Luis Resende
 */
@Entity
@Table(name = "tb_venda")
@NamedQueries({
    @NamedQuery(name = "TbVenda.findAll", query = "SELECT t FROM TbVenda t")})
public class TbVenda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ven_id")
    private Integer venId;
    @Basic(optional = false)
    @Column(name = "ven_data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date venData;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedVenda")
    private List<TbPedido> tbPedidoList;
    @JoinColumn(name = "ven_cli_id", referencedColumnName = "cli_id")
    @ManyToOne
    private TbCliente venCliId;
    @JoinColumn(name = "ven_tp_id", referencedColumnName = "tp_id")
    @ManyToOne(optional = false)
    private TbTipoPagamento venTpId;
    @JoinColumn(name = "ven_usuario", referencedColumnName = "usu_usuario")
    @ManyToOne(optional = false)
    private TbUsuario venUsuario;

    public TbVenda() {
    }

    public TbVenda(TbTipoPagamento pago, TbCliente cli, Date venData, TbUsuario user ) {
        this.venUsuario = user;
        this.venData = venData;
        this.venTpId = pago;
        this.venCliId = cli;
    }

    public Integer getVenId() {
        return venId;
    }

    public void setVenId(Integer venId) {
        this.venId = venId;
    }

    public Date getVenData() {
        return venData;
    }

    public void setVenData(Date venData) {
        this.venData = venData;
    }

    public List<TbPedido> getTbPedidoList() {
        return tbPedidoList;
    }

    public void setTbPedidoList(List<TbPedido> tbPedidoList) {
        this.tbPedidoList = tbPedidoList;
    }

    public TbCliente getVenCliId() {
        return venCliId;
    }

    public void setVenCliId(TbCliente venCliId) {
        this.venCliId = venCliId;
    }

    public TbTipoPagamento getVenTpId() {
        return venTpId;
    }

    public void setVenTpId(TbTipoPagamento venTpId) {
        this.venTpId = venTpId;
    }

    public TbUsuario getVenUsuario() {
        return venUsuario;
    }

    public void setVenUsuario(TbUsuario venUsuario) {
        this.venUsuario = venUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (venId != null ? venId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbVenda)) {
            return false;
        }
        TbVenda other = (TbVenda) object;
        if ((this.venId == null && other.venId != null) || (this.venId != null && !this.venId.equals(other.venId))) {
            return false;
        }
        return true;
    }

}
    

