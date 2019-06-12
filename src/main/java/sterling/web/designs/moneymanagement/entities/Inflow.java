/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sterling.web.designs.moneymanagement.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rodney
 */
@Entity
@Table(name = "inflow")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inflow.findAll", query = "SELECT i FROM Inflow i")
    , @NamedQuery(name = "Inflow.findByType", query = "SELECT i FROM Inflow i WHERE i.type = :type")
    , @NamedQuery(name = "Inflow.findByCurrency", query = "SELECT i FROM Inflow i WHERE i.currency = :currency")
    , @NamedQuery(name = "Inflow.findByAmount", query = "SELECT i FROM Inflow i WHERE i.amount = :amount")
    , @NamedQuery(name = "Inflow.findByTime", query = "SELECT i FROM Inflow i WHERE i.time = :time")
    , @NamedQuery(name = "Inflow.findByDate", query = "SELECT i FROM Inflow i WHERE i.date = :date")
    , @NamedQuery(name = "Inflow.findByTransid", query = "SELECT i FROM Inflow i WHERE i.transid = :transid")
    , @NamedQuery(name = "Inflow.findByInflowid", query = "SELECT i FROM Inflow i WHERE i.inflowid = :inflowid")
    , @NamedQuery(name = "Inflow.findByEnteredby", query = "SELECT i FROM Inflow i WHERE i.enteredby = :enteredby")
    , @NamedQuery(name = "Inflow.findByApprovedby", query = "SELECT i FROM Inflow i WHERE i.approvedby = :approvedby")
    , @NamedQuery(name = "Inflow.findByStatus", query = "SELECT i FROM Inflow i WHERE i.status = :status")})
public class Inflow implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "currency")
    private String currency;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private int amount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date time;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "transid")
    private String transid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "inflowid")
    private String inflowid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "enteredby")
    private String enteredby;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "approvedby")
    private String approvedby;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "status")
    private String status;

    public Inflow() {
    }

    public Inflow(String transid) {
        this.transid = transid;
    }

    public Inflow(String transid, String type, String currency, int amount, Date time, Date date, String inflowid, String enteredby, String approvedby, String status) {
        this.transid = transid;
        this.type = type;
        this.currency = currency;
        this.amount = amount;
        this.time = time;
        this.date = date;
        this.inflowid = inflowid;
        this.enteredby = enteredby;
        this.approvedby = approvedby;
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTransid() {
        return transid;
    }

    public void setTransid(String transid) {
        this.transid = transid;
    }

    public String getInflowid() {
        return inflowid;
    }

    public void setInflowid(String inflowid) {
        this.inflowid = inflowid;
    }

    public String getEnteredby() {
        return enteredby;
    }

    public void setEnteredby(String enteredby) {
        this.enteredby = enteredby;
    }

    public String getApprovedby() {
        return approvedby;
    }

    public void setApprovedby(String approvedby) {
        this.approvedby = approvedby;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transid != null ? transid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inflow)) {
            return false;
        }
        Inflow other = (Inflow) object;
        if ((this.transid == null && other.transid != null) || (this.transid != null && !this.transid.equals(other.transid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sterling.web.designs.moneymanagement.entities.Inflow[ transid=" + transid + " ]";
    }
    
}
