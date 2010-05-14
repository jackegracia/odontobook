package edu.austral.lab1.odontobook.model.dao;

import edu.austral.lab1.odontobook.model.Doctor;
import edu.austral.lab1.odontobook.model.HibernateUtil;
import edu.austral.lab1.odontobook.model.Usuario;

public class UsuarioDao extends BaseDao{
	
	
	
	public Usuario getUsuario(String name){
		Usuario user = (Usuario) HibernateUtil.getSession().createQuery(
		"from Usuario as user where user.username = ?")
		.setString(0, name)
		.uniqueResult();
		return user;
	}
	
	public boolean usuarioCorrecto(String name, long pass){
		Usuario user = (Usuario) HibernateUtil.getSession().createQuery(
		"from Usuario as user where user.username = ?")
		.setString(0, name)
		.uniqueResult();
		if(user != null && user.getPassword().equals(pass)) return true;
		else return false;
	}
	


}
