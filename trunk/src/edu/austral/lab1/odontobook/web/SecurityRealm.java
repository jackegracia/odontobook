package edu.austral.lab1.odontobook.web;

import org.securityfilter.realm.SimpleSecurityRealmBase;

import edu.austral.lab1.odontobook.model.dao.UsuarioDao;

public class SecurityRealm extends SimpleSecurityRealmBase{

	public boolean booleanAuthenticate(String username, String password) {
		UsuarioDao ud = new UsuarioDao();

		boolean login = ud.usuarioCorrecto(username, password);

		return login;

	}

	public boolean isUserInRole(String username, String role) {
		return true;
	}


}
