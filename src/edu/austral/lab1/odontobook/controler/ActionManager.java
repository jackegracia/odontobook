package edu.austral.lab1.odontobook.controler;

import java.util.Date;

import edu.austral.lab1.odontobook.graphicInterface.DoctorTabbedPane;
import edu.austral.lab1.odontobook.graphicInterface.GraphicInterface;
import edu.austral.lab1.odontobook.model.Consultorio;

public class ActionManager {
private NewDoctorAction newDoctor;
private NewPacienteAction newPaciente;
private NewTurnoAction newTurnoAction;
private DeleteDoctorAction deleteDoctorAction;
private ModificarPacienteAction modificarPacienteAction;
private NewHistogramaAction newHistograma;

public NewHistogramaAction getNewHistograma() {
	return newHistograma;
}

public void setNewHistograma(NewHistogramaAction newHistograma) {
	this.newHistograma = newHistograma;
}

public ActionManager(Consultorio consultorio,GraphicInterface gi){
	newDoctor=new NewDoctorAction(consultorio,gi);
	newPaciente=new NewPacienteAction(consultorio);
	deleteDoctorAction=new DeleteDoctorAction(gi);
	modificarPacienteAction=new ModificarPacienteAction(consultorio);
newHistograma=new NewHistogramaAction();
}

public ActionManager (DoctorTabbedPane doc,Date date){
	newTurnoAction=new NewTurnoAction(doc, date);
}


public ModificarPacienteAction getModificarPacienteAction() {
	return modificarPacienteAction;
}

public void setModificarPacienteAction(
		ModificarPacienteAction modificarPacienteAction) {
	this.modificarPacienteAction = modificarPacienteAction;
}

public DeleteDoctorAction getDeleteDoctorAction() {
	return deleteDoctorAction;
}

public void setDeleteDoctorAction(DeleteDoctorAction deleteDoctorAction) {
	this.deleteDoctorAction = deleteDoctorAction;
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
