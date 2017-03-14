/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.laboratory.gui;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigInteger;
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
import javax.persistence.Transient;

/**
 *
 * @author sakshi
 */
@Entity
@Table(name = "finaltestreport", catalog = "laboratory", schema = "")
@NamedQueries({
    @NamedQuery(name = "Finaltestreport_1.findAll", query = "SELECT f FROM Finaltestreport_1 f"),
    @NamedQuery(name = "Finaltestreport_1.findById", query = "SELECT f FROM Finaltestreport_1 f WHERE f.id = :id"),
    @NamedQuery(name = "Finaltestreport_1.findByCategoryname", query = "SELECT f FROM Finaltestreport_1 f WHERE f.categoryname = :categoryname"),
    @NamedQuery(name = "Finaltestreport_1.findByCreatedat", query = "SELECT f FROM Finaltestreport_1 f WHERE f.createdat = :createdat"),
    @NamedQuery(name = "Finaltestreport_1.findByNormalvalues", query = "SELECT f FROM Finaltestreport_1 f WHERE f.normalvalues = :normalvalues"),
    @NamedQuery(name = "Finaltestreport_1.findByResult", query = "SELECT f FROM Finaltestreport_1 f WHERE f.result = :result"),
    @NamedQuery(name = "Finaltestreport_1.findByTestname", query = "SELECT f FROM Finaltestreport_1 f WHERE f.testname = :testname"),
    @NamedQuery(name = "Finaltestreport_1.findByPatientId", query = "SELECT f FROM Finaltestreport_1 f WHERE f.patientId = :patientId")})
public class Finaltestreport_1 implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Column(name = "CATEGORYNAME")
    private String categoryname;
    @Column(name = "CREATEDAT")
    @Temporal(TemporalType.DATE)
    private Date createdat;
    @Column(name = "NORMALVALUES")
    private String normalvalues;
    @Column(name = "RESULT")
    private String result;
    @Column(name = "TESTNAME")
    private String testname;
    @Column(name = "PATIENT_ID")
    private BigInteger patientId;

    public Finaltestreport_1() {
    }

    public Finaltestreport_1(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        Long oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        String oldCategoryname = this.categoryname;
        this.categoryname = categoryname;
        changeSupport.firePropertyChange("categoryname", oldCategoryname, categoryname);
    }

    public Date getCreatedat() {
        return createdat;
    }

    public void setCreatedat(Date createdat) {
        Date oldCreatedat = this.createdat;
        this.createdat = createdat;
        changeSupport.firePropertyChange("createdat", oldCreatedat, createdat);
    }

    public String getNormalvalues() {
        return normalvalues;
    }

    public void setNormalvalues(String normalvalues) {
        String oldNormalvalues = this.normalvalues;
        this.normalvalues = normalvalues;
        changeSupport.firePropertyChange("normalvalues", oldNormalvalues, normalvalues);
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        String oldResult = this.result;
        this.result = result;
        changeSupport.firePropertyChange("result", oldResult, result);
    }

    public String getTestname() {
        return testname;
    }

    public void setTestname(String testname) {
        String oldTestname = this.testname;
        this.testname = testname;
        changeSupport.firePropertyChange("testname", oldTestname, testname);
    }

    public BigInteger getPatientId() {
        return patientId;
    }

    public void setPatientId(BigInteger patientId) {
        BigInteger oldPatientId = this.patientId;
        this.patientId = patientId;
        changeSupport.firePropertyChange("patientId", oldPatientId, patientId);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Finaltestreport_1)) {
            return false;
        }
        Finaltestreport_1 other = (Finaltestreport_1) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "in.laboratory.gui.Finaltestreport_1[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
