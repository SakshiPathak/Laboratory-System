/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.laboratory.gui;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author sakshi
 */
@Entity
@Table(name = "hematology", catalog = "laboratory", schema = "")
@NamedQueries({
    @NamedQuery(name = "Hematology.findAll", query = "SELECT h FROM Hematology h"),
    @NamedQuery(name = "Hematology.findById", query = "SELECT h FROM Hematology h WHERE h.id = :id"),
    @NamedQuery(name = "Hematology.findByNormalvalues", query = "SELECT h FROM Hematology h WHERE h.normalvalues = :normalvalues"),
    @NamedQuery(name = "Hematology.findByResults", query = "SELECT h FROM Hematology h WHERE h.results = :results"),
    @NamedQuery(name = "Hematology.findByTestname", query = "SELECT h FROM Hematology h WHERE h.testname = :testname")})
public class Hematology implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NORMALVALUES")
    private String normalvalues;
    @Column(name = "RESULTS")
    private String results;
    @Column(name = "TESTNAME")
    private String testname;

    public Hematology() {
    }

    public Hematology(Long id) {
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

    public String getNormalvalues() {
        return normalvalues;
    }

    public void setNormalvalues(String normalvalues) {
        String oldNormalvalues = this.normalvalues;
        this.normalvalues = normalvalues;
        changeSupport.firePropertyChange("normalvalues", oldNormalvalues, normalvalues);
    }

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        String oldResults = this.results;
        this.results = results;
        changeSupport.firePropertyChange("results", oldResults, results);
    }

    public String getTestname() {
        return testname;
    }

    public void setTestname(String testname) {
        String oldTestname = this.testname;
        this.testname = testname;
        changeSupport.firePropertyChange("testname", oldTestname, testname);
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
        if (!(object instanceof Hematology)) {
            return false;
        }
        Hematology other = (Hematology) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "in.laboratory.gui.Hematology[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
