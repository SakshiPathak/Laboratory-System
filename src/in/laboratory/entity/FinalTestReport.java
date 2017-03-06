/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.laboratory.entity;

import in.laboratory.gui.Completebloodcount;
import in.laboratory.gui.Wbcdifferentialcount;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
//    private String test_type;
//    private String result;
//    private String normalvalues;
//    @OneToMany
//    private Hematology hematology;
//    private Biochemistry biochemistry;
//    private Completebloodcount completebloodcount;
//    private Wbcdifferentialcount wbcdifferentialcount;
//    private Urinalysis urinalysis;
//    private Patient patient;

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
