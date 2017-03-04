/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.laboratory.gui;

import in.laboratory.entity.controller.PatientJpaController;
import in.laboratory.utilities.Helper;
import java.util.logging.Level;
import java.util.logging.Logger;
import in.laboratory.entity.Patient;
import java.util.Date;
import javax.persistence.Persistence;

/**
 *
 * @author sakshi
 */
public class PatientFrame extends javax.swing.JInternalFrame {
    //private PatientJpaController patientController;

    /**
     * Creates new form Patient
     */
    public PatientFrame() {
        initComponents();
        
        getRootPane().setDefaultButton(btnSave);
        
        //patientController = Helper.getPatientControllerInstance();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        LaboratoryPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("LaboratoryPU").createEntityManager();
        patientQuery = java.beans.Beans.isDesignTime() ? null : LaboratoryPUEntityManager.createQuery("SELECT p FROM Patient p");
        patientList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : patientQuery.getResultList();
        buttonGroup1 = new javax.swing.ButtonGroup();
        pnlButtons = new javax.swing.JPanel();
        lblSearchByName = new javax.swing.JLabel();
        cmbPatient = new javax.swing.JComboBox<String>();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        btnNewRecord = new javax.swing.JButton();
        pnlCustomer = new javax.swing.JPanel();
        lblFirstName = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        lblLastName = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        lblGender = new javax.swing.JLabel();
        rdMale = new javax.swing.JRadioButton();
        rdFemale = new javax.swing.JRadioButton();
        lblAge = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblAddress = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        lblCity = new javax.swing.JLabel();
        txtCity = new javax.swing.JTextField();
        lblPincode = new javax.swing.JLabel();
        txtPincode = new javax.swing.JTextField();
        lblState = new javax.swing.JLabel();
        txtState = new javax.swing.JTextField();
        lblPhoneNumber = new javax.swing.JLabel();
        txtPhoneNumber = new javax.swing.JTextField();
        txtAge = new javax.swing.JTextField();
        lblReferencedBy = new javax.swing.JLabel();
        txtReferencedBy = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Patient Details");

        pnlButtons.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblSearchByName.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblSearchByName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSearchByName.setText("Search By Name");

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${resultList}");
        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, patientQuery, eLProperty, cmbPatient);
        bindingGroup.addBinding(jComboBoxBinding);
        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, patientQuery, org.jdesktop.beansbinding.ELProperty.create("${firstResult}"), cmbPatient, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        cmbPatient.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbPatientItemStateChanged(evt);
            }
        });

        btnSave.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSave.setMnemonic('s');
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnUpdate.setMnemonic('u');
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnRefresh.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRefresh.setMnemonic('g');
        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnNewRecord.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnNewRecord.setText("New Record");
        btnNewRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewRecordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlButtonsLayout = new javax.swing.GroupLayout(pnlButtons);
        pnlButtons.setLayout(pnlButtonsLayout);
        pnlButtonsLayout.setHorizontalGroup(
            pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtonsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSearchByName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbPatient, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRefresh, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(btnNewRecord, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlButtonsLayout.setVerticalGroup(
            pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtonsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSearchByName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbPatient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNewRecord)
                .addGap(18, 18, 18)
                .addComponent(btnSave)
                .addGap(18, 18, 18)
                .addComponent(btnUpdate)
                .addGap(18, 18, 18)
                .addComponent(btnRefresh)
                .addContainerGap())
        );

        pnlCustomer.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Customer Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        lblFirstName.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblFirstName.setText("First Name:");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, cmbPatient, org.jdesktop.beansbinding.ELProperty.create("${selectedItem.firstName}"), txtFirstName, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        lblLastName.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblLastName.setText("Last Name:");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, cmbPatient, org.jdesktop.beansbinding.ELProperty.create("${selectedItem.lastName}"), txtLastName, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        lblGender.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblGender.setText("Gender:");

        buttonGroup1.add(rdMale);
        rdMale.setSelected(true);
        rdMale.setText("Male");

        buttonGroup1.add(rdFemale);
        rdFemale.setText("Female");

        lblAge.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblAge.setText("Age:");

        lblEmail.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblEmail.setText("Email:");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, cmbPatient, org.jdesktop.beansbinding.ELProperty.create("${selectedItem.email}"), txtEmail, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        lblAddress.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblAddress.setText("Address:");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, cmbPatient, org.jdesktop.beansbinding.ELProperty.create("${selectedItem.address}"), txtAddress, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        lblCity.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblCity.setText("City:");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, cmbPatient, org.jdesktop.beansbinding.ELProperty.create("${selectedItem.city}"), txtCity, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        lblPincode.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPincode.setText("Pincode:");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, cmbPatient, org.jdesktop.beansbinding.ELProperty.create("${selectedItem.pincode}"), txtPincode, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        lblState.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblState.setText("State:");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, cmbPatient, org.jdesktop.beansbinding.ELProperty.create("${selectedItem.state}"), txtState, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        lblPhoneNumber.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPhoneNumber.setText("Phone Number:");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, cmbPatient, org.jdesktop.beansbinding.ELProperty.create("${selectedItem.phoneNo}"), txtPhoneNumber, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, cmbPatient, org.jdesktop.beansbinding.ELProperty.create("${selectedItem.age}"), txtAge, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        lblReferencedBy.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblReferencedBy.setText("Doctor Incharge:");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, cmbPatient, org.jdesktop.beansbinding.ELProperty.create("${selectedItem.referencedBy}"), txtReferencedBy, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        javax.swing.GroupLayout pnlCustomerLayout = new javax.swing.GroupLayout(pnlCustomer);
        pnlCustomer.setLayout(pnlCustomerLayout);
        pnlCustomerLayout.setHorizontalGroup(
            pnlCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCustomerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFirstName)
                    .addComponent(lblLastName)
                    .addComponent(lblGender)
                    .addComponent(lblAddress)
                    .addComponent(lblCity)
                    .addComponent(lblPincode)
                    .addComponent(lblState)
                    .addComponent(lblPhoneNumber)
                    .addGroup(pnlCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lblAge, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblReferencedBy))
                .addGap(63, 63, 63)
                .addGroup(pnlCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtReferencedBy, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addGroup(pnlCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtPhoneNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                        .addComponent(txtState)
                        .addComponent(txtPincode)
                        .addComponent(txtCity)
                        .addGroup(pnlCustomerLayout.createSequentialGroup()
                            .addComponent(rdMale)
                            .addGap(18, 18, 18)
                            .addComponent(rdFemale))
                        .addComponent(txtFirstName)
                        .addComponent(txtLastName)
                        .addComponent(txtEmail)
                        .addComponent(txtAddress)
                        .addComponent(txtAge)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        pnlCustomerLayout.setVerticalGroup(
            pnlCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCustomerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFirstName)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLastName)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGender)
                    .addComponent(rdMale)
                    .addComponent(rdFemale))
                .addGap(7, 7, 7)
                .addGroup(pnlCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAge)
                    .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAddress))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCity))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPincode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPincode))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblState))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPhoneNumber))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblReferencedBy)
                    .addComponent(txtReferencedBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 5, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlButtons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbPatientItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbPatientItemStateChanged
        in.laboratory.entity.Patient patient =
        (in.laboratory.entity.Patient) cmbPatient.getSelectedItem();

        //dpDoB.setDate(customer.getDateOfBirth().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        if (patient.getGender() == 'M')
        rdMale.setSelected(true);
        else
        rdFemale.setSelected(true);

        btnSave.setEnabled(false);
    }//GEN-LAST:event_cmbPatientItemStateChanged

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (txtFirstName.getText().isEmpty()) {
            Helper.showErrorMessage(this, "First Name Cannot be Empty");
            txtFirstName.requestFocus();
            return;
        }

        if (txtPincode.getText().isEmpty()) {
            txtPincode.setText("0");
        }

        if (txtPhoneNumber.getText().isEmpty()) {
            Helper.showErrorMessage(this, "Phone Number Cannot be Empty");
            txtFirstName.requestFocus();
            return;
        }
        
        PatientJpaController patientcontroller = new PatientJpaController(
                Persistence.createEntityManagerFactory("LaboratoryPU")
        );

//        in.laboratory.entity.Patient patient =
//        new in.laboratory.entity.Patient();
        Patient patient = new Patient();

        patient.setFirstName(txtFirstName.getText().trim());
        patient.setLastName(txtLastName.getText().trim());
        patient.setGender(rdMale.isSelected() ? 'M' : 'F');
        patient.setAge(txtAge.getText().trim());
        patient.setEmail(txtEmail.getText().trim());
        patient.setAddress(txtAddress.getText().trim());
        patient.setCity(txtCity.getText().trim());
        patient.setPincode(Integer.parseInt(txtPincode.getText().trim()));
        patient.setState(txtState.getText().trim());
//        customer.setDateOfBirth(
//            Date.from(
//                dpDoB.getDate().atStartOfDay(ZoneId.systemDefault()).toInstant()
//            )
//        );
        patient.setPhoneNo(txtPhoneNumber.getText().trim());
        patient.setReferencedBy(txtReferencedBy.getText().trim());
        patient.setUpdatedAt(new Date());

        patientcontroller.create(patient);

        Helper.showSuccessMessage(this, "New Customer Created Successfully!");
        btnSave.setEnabled(false);
        btnNewRecord.setEnabled(true);
        txtAddress.setText("");
        txtCity.setText("");
        txtEmail.setText("");
        txtFirstName.setText("");
        txtLastName.setText("");
        txtPhoneNumber.setText("");
        txtPincode.setText("");
        txtState.setText("");
        //dpDoB.setDate(null);
        rdMale.setSelected(true);
        txtAge.setText("");
        txtReferencedBy.setText("");
        //Helper.closeAndOpen(this, new Dashboard());
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
//        in.laboratory.entity.Patient patient =
//        (in.laboratory.entity.Patient) cmbPatient.getSelectedItem();
        
        PatientJpaController patientcontroller = new PatientJpaController(
                Persistence.createEntityManagerFactory("LaboratoryPU")
        );
        
        Patient patient = (Patient) cmbPatient.getSelectedItem();

        patient.setFirstName(txtFirstName.getText().trim());
        patient.setLastName(txtLastName.getText().trim());
        patient.setGender(rdMale.isSelected() ? 'M' : 'F');
        patient.setAge(txtAge.getText().trim());
        patient.setEmail(txtEmail.getText().trim());
        patient.setAddress(txtAddress.getText().trim());
        patient.setCity(txtCity.getText().trim());
        patient.setPincode(Integer.parseInt(txtPincode.getText().trim()));
        patient.setState(txtState.getText().trim());
//        customer.setDateOfBirth(
//            Date.from(
//                dpDoB.getDate().atStartOfDay(ZoneId.systemDefault()).toInstant()
//            )
//        );
        patient.setPhoneNo(txtPhoneNumber.getText().trim());
        patient.setReferencedBy(txtReferencedBy.getText().trim());
        patient.setUpdatedAt(new Date());

        try {
            patientcontroller.edit(patient);
        } catch (Exception ex) {
            Logger.getLogger(PatientFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        Helper.showSuccessMessage(this, "Record Updated Successfully!");
//        btnSave.setEnabled(false);
//        btnNewRecord.setEnabled(true);
//        txtAddress.setText("");
//        txtCity.setText("");
//        txtEmail.setText("");
//        txtFirstName.setText("");
//        txtLastName.setText("");
//        txtPhoneNumber.setText("");
//        txtPincode.setText("");
//        txtState.setText("");
//        //dpDoB.setDate(null);
//        rdMale.setSelected(true);
//        txtAge.setText("");
//        txtReferencedBy.setText("");
        //Helper.closeAndOpen(this, new Dashboard());
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        txtAddress.setText("");
        txtCity.setText("");
        txtEmail.setText("");
        txtFirstName.setText("");
        txtLastName.setText("");
        txtPhoneNumber.setText("");
        txtPincode.setText("");
        txtState.setText("");
        //dpDoB.setDate(null);
        rdMale.setSelected(true);
        txtAge.setText("");
        txtReferencedBy.setText("");


//        try {
//            WritableWorkbook workbook =
//            Workbook.createWorkbook(new File("CustomersList.xls"));
//
//            WritableSheet sheet = workbook.createSheet("List", 0);
//
//            ListIterator<in.triinfotech.entity.Customer> listIterator =
//            customerController.findCustomerEntities().listIterator();
//            int row = 0, col = 0;
//            while (listIterator.hasNext()) {
//                in.triinfotech.entity.Customer customer = listIterator.next();
//                sheet.addCell(new Label(col++, row, customer.getFirstName()));
//                sheet.addCell(new Label(col++, row, customer.getLastName()));
//                sheet.addCell(new Label(col++, row, String.valueOf(customer.getGender())));
//                sheet.addCell(new Label(col++, row, customer.getDateOfBirth().toString()));
//                sheet.addCell(new Label(col++, row, customer.getEmail()));
//                sheet.addCell(new Label(col++, row, customer.getAddress()));
//                sheet.addCell(new Label(col++, row, customer.getCity()));
//                sheet.addCell(new Label(col++, row, String.valueOf(customer.getPinCode())));
//                sheet.addCell(new Label(col++, row, customer.getState()));
//                sheet.addCell(new Label(col, row++, customer.getPhoneNumber()));
//                col = 0;
//                System.out.println(customer);
//            }
//
//            workbook.write();
//            workbook.close();
//        } catch (IOException ex) {
//            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (WriteException ex) {
//            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        Helper.showSuccessMessage(this, "Excel file created successfully!");
//        Helper.closeAndOpen(this, new Dashboard());
        
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnNewRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewRecordActionPerformed
        btnSave.setEnabled(true);
        btnNewRecord.setEnabled(false);

        txtAddress.setText("");
        txtCity.setText("");
        txtEmail.setText("");
        txtFirstName.setText("");
        txtLastName.setText("");
        txtPhoneNumber.setText("");
        txtPincode.setText("");
        txtState.setText("");
        //dpDoB.setDate(null);
        rdMale.setSelected(true);
        txtAge.setText("");
        txtReferencedBy.setText("");
    }//GEN-LAST:event_btnNewRecordActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager LaboratoryPUEntityManager;
    private javax.swing.JButton btnNewRecord;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cmbPatient;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblAge;
    private javax.swing.JLabel lblCity;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFirstName;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblPhoneNumber;
    private javax.swing.JLabel lblPincode;
    private javax.swing.JLabel lblReferencedBy;
    private javax.swing.JLabel lblSearchByName;
    private javax.swing.JLabel lblState;
    private java.util.List<in.laboratory.gui.Patient> patientList;
    private javax.persistence.Query patientQuery;
    private javax.swing.JPanel pnlButtons;
    private javax.swing.JPanel pnlCustomer;
    private javax.swing.JRadioButton rdFemale;
    private javax.swing.JRadioButton rdMale;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtCity;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtPhoneNumber;
    private javax.swing.JTextField txtPincode;
    private javax.swing.JTextField txtReferencedBy;
    private javax.swing.JTextField txtState;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}