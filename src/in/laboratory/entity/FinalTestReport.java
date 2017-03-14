/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.laboratory.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author sakshi
 */
@Entity
public class FinalTestReport implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String categoryName;
    private String testName;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date createdAt;
    @ManyToOne
    private Patient patient;
    private String result;
    private String normalvalues;
    

    public FinalTestReport() {
    }

    public FinalTestReport(String categoryName, String testName, Date createdAt, Patient patient, String result, String normalvalues) {
        this.categoryName = categoryName;
        this.testName = testName;
        this.createdAt = createdAt;
        this.patient = patient;
        this.result = result;
        this.normalvalues = normalvalues;
    }

   

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

   
    
    

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getNormalvalues() {
        return normalvalues;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setNormalvalues(String normalvalues) {
        this.normalvalues = normalvalues;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof FinalTestReport)) {
            return false;
        }
        FinalTestReport other = (FinalTestReport) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "in.laboratory.entity.FinalTestReport[ id=" + id + " ]";
    }
    
}
