/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.laboratory.utilities;

//import in.laboratory.entity.User
import in.laboratory.entity.FinalTestReport;
import in.laboratory.entity.controller.BiochemistryJpaController;
import in.laboratory.entity.controller.CompletebloodcountJpaController;
import in.laboratory.entity.controller.FinalTestReportJpaController;
import in.laboratory.entity.controller.HematologyJpaController;
import in.laboratory.entity.controller.PatientJpaController;
import in.laboratory.entity.controller.RoleJpaController;
import in.laboratory.entity.controller.UrinalysisJpaController;
//import in.laboratory.entity.controller.EyeSightJpaController;
import in.laboratory.entity.controller.UserJpaController;
import in.laboratory.entity.controller.WbcdifferentialcountJpaController;
import in.laboratory.entity.controller.WbcdifferentialcountJpaController;
import java.awt.Component;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Persistence;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author ajay
 */
public class Helper {

    public static UserJpaController getUserControllerInstance() {
        return new UserJpaController(
            Persistence.createEntityManagerFactory("LaboratoryPU")
        );
    }
    
    public static PatientJpaController getPatientControllerInstance() {
        return new PatientJpaController(
            Persistence.createEntityManagerFactory("LaboratoryPU")
        );
    }
    
    public static RoleJpaController getRoleControllerInstance() {
        return new RoleJpaController(
            Persistence.createEntityManagerFactory("LaboratoryPU")
        );
    }
    
    public static HematologyJpaController getHematologyControllerInstance() {
        return new HematologyJpaController(
            Persistence.createEntityManagerFactory("LaboratoryPU")
        );
    }
    
    public static BiochemistryJpaController getBiochemistryControllerInstance() {
        return new BiochemistryJpaController(
            Persistence.createEntityManagerFactory("LaboratoryPU")
        );
    }
    
    public static CompletebloodcountJpaController getCompleteBloodCountControllerInstance() {
        return new CompletebloodcountJpaController(
            Persistence.createEntityManagerFactory("LaboratoryPU")
        );
    }
    
    public static WbcdifferentialcountJpaController getWBCDifferentialCountControllerInstance() {
        return new WbcdifferentialcountJpaController(
            Persistence.createEntityManagerFactory("LaboratoryPU")
        );
    }
    
    public static UrinalysisJpaController getUrinalysisControllerInstance() {
        return new UrinalysisJpaController(
            Persistence.createEntityManagerFactory("LaboratoryPU")
        );
    }
    
    public static FinalTestReportJpaController getFinalTestReportControllerInstance() {
        return new FinalTestReportJpaController(
            Persistence.createEntityManagerFactory("LaboratoryPU")
        );
    }
    
//    public static EyeSightJpaController getEyeSightControllerInstance() {
//        return new EyeSightJpaController(
//            Persistence.createEntityManagerFactory("LovelyOpticalsPU")
//        );
//    }
    
    public static void centerScreen(JFrame frame) {
        frame.setLocationRelativeTo(null);
    }
    
    public static void showSuccessMessage(Component component, String message) {
        JOptionPane.showMessageDialog(component, message, "Message", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void showErrorMessage(Component component, String message) {
        JOptionPane.showMessageDialog(component, message, "Message", JOptionPane.ERROR_MESSAGE);
    }
    
    public static void closeAndOpen(JFrame toClose, JFrame toOpen) {
        toClose.dispose();
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                toOpen.setVisible(true);
            }
        });
    }
    
    public static void generateHTML(FinalTestReport finaltestreport) {
        // File Name
        Long patientId = finaltestreport.getPatient().getId();
        Long finaltestreportId = finaltestreport.getId();
        String reportFileName = patientId + "-" + finaltestreportId + ".html";
        // Customer Infprmation
       // String customerName = finaltestreport.getCustomer().toString();
//        String dateOfBirth = 
//            new SimpleDateFormat("dd/MM/yyyy")
//                .format(eyeSight.getCustomer().getDateOfBirth());
       // String phoneNumber = eyeSight.getCustomer().getPhoneNumber();
//        String date = 
//            new SimpleDateFormat("dd/MM/yyyy")
//                .format(eyeSight.getCreatedAt());
        // Right Eye Test Results
        String categoryname = finaltestreport.getCategoryName();
        String testname = finaltestreport.getTestName();
        String results = finaltestreport.getResult();
        String normalvalues = finaltestreport.getNormalvalues();
        
        String htmlCode = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "	<title></title>\n" +
                "	<link rel='stylesheet' type='text/css' href='css/bootstrap.min.css'>\n" +
                "	<link rel=\"stylesheet\" type=\"text/css\" href=\"\">\n" +
                "	<style type=\"text/css\">\n" +
                "		.shop-name {\n" +
                "			font-size: 6.5em;\n" +
                "		}\n" +
                "\n" +
                "		th {\n" +
                "			background-color: #EBEBEB;\n" +
                "		}\n" +
                "\n" +
                "		th, td:nth-child(1), td:nth-child(3), td:nth-child(4) {\n" +
                "			text-align: center;\n" +
                "		}\n" +
                "\n" +
                "		td:nth-child(5), td:last-child {\n" +
                "			text-align: right;\n" +
                "		}\n" +
                "\n" +
                "		.bold {\n" +
                "			font-weight: bolder;\n" +
                "		}\n" +
                "\n" +
                "		td:first-child {\n" +
                "			width: 100px;\n" +
                "		}\n" +
                "\n" +
                "		td:nth-child(3) {\n" +
                "			width: 100px;\n" +
                "		}\n" +
                "		.container{border:2px solid gray;border-top:none;}\n" +
                "	</style>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "<div class='container'>\n" +
                "	<div class='row'>\n" +
                "		<div class='col-md-8 col-md-offset-2'>\n" +
                "			<h1 class='text-center shop-name'>Lovely Opticals</h1>\n" +
                "		</div>\n" +
                "	</div>\n" +
                "	<div class='row'>\n" +
                "		<div class='col-md-8 col-md-offset-2'>\n" +
                "			<h4 class='text-center clearfix'>Deals in: Specs, Goggles, Contact Lens, Complete Computerized Eye Testing</h4>\n" +
                "		</div>\n" +
                "	</div>\n" +
                "	<div class='row'>\n" +
                "		<div class='col-md-8 col-md-offset-2'>\n" +
                "			<h4 class='text-center clearfix'>Opp. Dena Bank, Near Lovely Fast Food, Railway Road, Hoshiarpur.</h4>\n" +
                "		</div>\n" +
                "	</div>\n" +
                "    <div class='row'>\n" +
                "		<div class='col-md-8 col-md-offset-2'>\n" +
                "			<h4 class='text-center clearfix'>Ph.(S)01882-232322, 75080-20006 E-mail:lovely_optical@yahoo.com</h4>\n" +
                "		</div>\n" +
                "	</div>\n" +
                "\n" +
                "	<hr>\n" +
                "\n" +
                "	<div class='row'>\n" +
                "		<div class='col-md-6'>\n" +
                "                   <div class='col-md-3'>\n" +
                "			<span>Customer ID:</span>\n" +
                "                   </div>\n" +
                "                   <div class='col-md-3'>\n" +
                "			<span><b>" + patientId + "</b></span>\n" +
                "                   </div>\n" +                
                "		</div>\n" +
                "		<div class='col-md-6'>\n" +
                "			<span class='pull-right'>Date: <b>" + "XXX" + "</b></span>\n" +
                "		</div>\n" +
                "	</div>\n" +
                "\n" +
                "	<div class='row'>\n" +
                "		<div class='col-md-6'>\n" +
                "                   <div class='col-md-3'>\n" +
                "			<span>Customer Name:</span>\n" +
                "                   </div>\n" +
                "                   <div class='col-md-3'>\n" +
                "			<span><b>" + "XXX"/*customerName*/ + "</b></span>\n" +
                "                   </div>\n" +
                "		</div>\n" +
                "	</div>\n" +
                "\n" +
                "	<div class='row'>\n" +
                "		<div>\n" +
                "			<table class='table table-hover table-bordered'>\n" +
                "				<thead>\n" +
                "					<tr>\n" +
                //"						<th style=\"width:8%;\"></th>\n" +
                "						<th style=\"width:10%;\">TEST NAME</th>\n" +
                "						<th style=\"width:10%;\">RESULTS</th>\n" +
                "						<th style=\"width:10%;\">NORMAL VALUES</th>\n" +
                //"						<th style=\"width:10%;\">ADD</th>\n" +     
                "					</tr>\n" +
                "				</thead>\n" +
                "				<tbody>\n" +
            
                "<tr>\n" +
                //"						<td>RE</td>\n" +
                "						<td class=\"text-center\"><b>" + testname + "</b></td>\n" +
                "						<td class=\"text-center\"><b>" + results + "</b></td>\n" +
                "						<td class=\"text-center\"><b>" + normalvalues + "</b></td>\n" +
               // "						<td class=\"text-center\"><b>" + reAdd + "</b></td>\n" +
                
                "					</tr>\n" +
               /* "					<tr>\n" +
                "						<td>LE</td>\n" +
                "						<td class=\"text-center\"><b>" + leSph + "</b></td>\n" +
                "						<td class=\"text-center\"><b>" + leCyl + "</b></td>\n" +
                "						<td class=\"text-center\"><b>" + leAxis + "</b></td>\n" +
                "						<td class=\"text-center\"><b>" + leAdd + "</b></td>\n" +
                "					</tr>\n" +  */
                "				</tbody>\n" +
                "			</table>\n" +
                "		</div>\n" +
                "	</div>\n" +
                "	<div class='row'>\n" +
                "		<div class='col-md-6'>\n" +
                "                   <div class='col-md-3'>\n" +
                "			<span>DOB:</span>\n" +
                "                   </div>\n" +
                "                   <div class='col-md-3'>\n" +
                "			<span><b>" + " XXXX "/*dateOfBirth*/ + "</b></span>\n" +
                "                   </div>\n" +
                "		</div>\n" +
                "	</div>\n" +
                "\n" +
                "	<div class='row'>\n" +
                "		<div class='col-md-6'>\n" +
                "                   <div class='col-md-3'>\n" +
                "			<span>Phone Number:</span>\n" +
                "                   </div>\n" +
                "                   <div class='col-md-3'>\n" +
                "			<span><b>" + " XXXX "/*phoneNumber*/ + "</b></span>\n" +
                "                   </div>\n" +
                "		</div>\n" +
                "	</div>\n" +
                "\n" +

                "</div>	\n" +
                "\n" +
                "</body>\n" +
                "</html>";
        
        try {
            File file = new File(reportFileName);
            PrintWriter pw = new PrintWriter(file);
            pw.print(htmlCode);
            pw.close();
            Helper.showSuccessMessage(null, "Report with filename " + reportFileName + " created successfully!");
             Runtime.getRuntime().exec("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe " + file.getAbsolutePath());
        } catch (IOException ex) {
            Logger.getLogger(Helper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
