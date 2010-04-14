package edu.austral.lab1.odontobook.controler;

import edu.austral.lab1.odontobook.model.Consultorio;

public class ActionManager {
private NewDoctorAction newDoctor;
private NewPacienteAction newPaciente;

public ActionManager(Consultorio consultorio){
	newDoctor=new NewDoctorAction(consultorio);
	newPaciente=new NewPacienteAction(consultorio);
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
