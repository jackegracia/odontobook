package edu.austral.lab1.odontobook.controler;

import edu.austral.lab1.odontobook.model.Consultorio;

public class ActionManager {
private NewDoctorAction newDoctor;

public ActionManager(Consultorio consultorio){
	newDoctor=new NewDoctorAction(consultorio);
}

public NewDoctorAction getNewDoctor() {
	return newDoctor;
}

public void setNewDoctor(NewDoctorAction newDoctor) {
	this.newDoctor = newDoctor;
}
}
