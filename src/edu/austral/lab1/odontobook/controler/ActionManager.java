package edu.austral.lab1.odontobook.controler;

import java.util.Date;

import edu.austral.lab1.odontobook.graphicInterface.DoctorTabbedPane;
import edu.austral.lab1.odontobook.model.Consultorio;
import edu.austral.lab1.odontobook.model.Doctor;

public class ActionManager {
private NewDoctorAction newDoctor;
private NewPacienteAction newPaciente;
private NewTurnoAction newTurnoAction;
private DeleteDoctorAction deleteDoctorAction;

public ActionManager(Consultorio consultorio){
	newDoctor=new NewDoctorAction(consultorio);
	newPaciente=new NewPacienteAction(consultorio);
	deleteDoctorAction=new DeleteDoctorAction();

}

public DeleteDoctorAction getDeleteDoctorAction() {
	return deleteDoctorAction;
}

public void setDeleteDoctorAction(DeleteDoctorAction deleteDoctorAction) {
	this.deleteDoctorAction = deleteDoctorAction;
}

public ActionManager (DoctorTabbedPane doc,Date date){
	newTurnoAction=new NewTurnoAction(doc, date);
}

public NewTurnoAction getNewTurnoAction() {
	return newTurnoAction;
}

public void setNewTurnoAction(NewTurnoAction newTurnoAction) {
	this.newTurnoAction = newTurnoAction;
}

public NewPacienteAction getNewPaciente() {
	return newPaciente;
}

public void setNewPaciente(NewPacienteAction newPaciente) {
	this.newPaciente = newPaciente;
}

public NewDoctorAction getNewDoctor() {
	return newDoctor;
}

public void setNewDoctor(NewDoctorAction newDoctor) {
	this.newDoctor = newDoctor;
}
}
