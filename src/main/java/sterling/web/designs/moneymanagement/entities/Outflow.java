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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "outflow")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Outflow.findAll", query = "SELECT o FROM Outflow o")
    , @NamedQuery(name = "Outflow.findByType", query = "SELECT o FROM Outflow o WHERE o.type = :type")
    , @NamedQuery(name = "Outflow.findByCurrency", query = "SELECT o FROM Outflow o WHERE o.currency = :currency")
    , @NamedQuery(name = "Outflow.findByAmount", query = "SELECT o FROM Outflow o WHERE o.amount = :amount")
    , @NamedQuery(name = "Outflow.findByCashoutid", query = "SELECT o FROM Outflow o WHERE o.cashoutid = :cashoutid")
    , @NamedQuery(name = "Outflow.findByDesignation", query = "SELECT o FROM Outflow o WHERE o.designation = :designation")
    , @NamedQuery(name = "Outflow.findByDateIntiated", query = "SELECT o FROM Outflow o WHERE o.dateIntiated = :dateIntiated")
    , @NamedQuery(name = "Outflow.findByDateResponse", query = "SELECT o FROM Outflow o WHERE o.dateResponse = :dateResponse")
    , @NamedQuery(name = "Outflow.findByRequestedby", query = "SELECT o FROM Outflow o WHERE o.requestedby = :requestedby")
    , @NamedQuery(name = "Outflow.findByApprovedby", query = "SELECT o FROM Outflow o WHERE o.approvedby = :approvedby")
    , @NamedQuery(name = "Outflow.findByStatus", query = "SELECT o FROM Outflow o WHERE o.status = :status")})
public class Outflow implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "currency")
    private String currency;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private int amount;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cashoutid")
    private Integer cashoutid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "designation")
    private String designation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_intiated")
    @Temporal(TemporalType.DATE)
    private Date dateIntiated;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_response")
    @Temporal(TemporalType.DATE)
    private Date dateResponse;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "requestedby")
    private String requestedby;
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

    public Outflow() {
    }

    public Outflow(Integer cashoutid) {
        this.cashoutid = cashoutid;
    }

    public Outflow(Integer cashoutid, String type, String currency, int amount, String designation, Date dateIntiated, Date dateResponse, String requestedby, String approvedby, String status) {
        this.cashoutid = cashoutid;
        this.type = type;
        this.currency = currency;
        this.amount = amount;
        this.designation = designation;
        this.dateIntiated = dateIntiated;
        this.dateResponse = dateResponse;
        this.requestedby = requestedby;
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

    public Integer getCashoutid() {
        return cashoutid;
    }

    public void setCashoutid(Integer cashoutid) {
        this.cashoutid = cashoutid;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Date getDateIntiated() {
        return dateIntiated;
    }

    public void setDateIntiated(Date dateIntiated) {
        this.dateIntiated = dateIntiated;
    }

    public Date getDateResponse() {
        return dateResponse;
    }

    public void setDateResponse(Date dateResponse) {
        this.dateResponse = dateResponse;
    }

    public String getRequestedby() {
        return requestedby;
    }

    public void setRequestedby(String requestedby) {
        this.requestedby = requestedby;
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
        hash += (cashoutid != null ? cashoutid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Outflow)) {
            return false;
        }
        Outflow other = (Outflow) object;
        if ((this.cashoutid == null && other.cashoutid != null) || (this.cashoutid != null && !this.cashoutid.equals(other.cashoutid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sterling.web.designs.moneymanagement.entities.Outflow[ cashoutid=" + cashoutid + " ]";
    }
    
}
