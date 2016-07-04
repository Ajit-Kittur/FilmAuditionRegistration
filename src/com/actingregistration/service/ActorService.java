package com.actingregistration.service;

import java.sql.SQLException;

import com.actingregistration.entities.Actor;

public interface ActorService {
	public boolean actorRegistration(String firstName, String lastName, String emailId, String password, long contactNo) throws ClassNotFoundException, SQLException, Exception;
	public Actor actorLogin(String emailId, String password) throws ClassNotFoundException, SQLException, Exception;
	public Actor getActor(String emailId) throws ClassNotFoundException, SQLException;
	public Boolean forgotPassword(String emailId, String password, Long contactNo) throws ClassNotFoundException, SQLException, Exception;
}
