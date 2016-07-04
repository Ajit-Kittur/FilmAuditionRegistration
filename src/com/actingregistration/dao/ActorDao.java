package com.actingregistration.dao;

import java.sql.SQLException;

import com.actingregistration.entities.Actor;

public interface ActorDao {
	
	public boolean saveActor(Actor actor);
	public boolean isActorValid(String emailId) throws ClassNotFoundException, SQLException; 
	public Actor getActor(String emailId, String password) throws ClassNotFoundException, SQLException;
	public boolean updateActor(Actor actor);
	public Actor getActorByemailId(String emailId) throws ClassNotFoundException, SQLException;
	public boolean forLoginCheck(String emailId, String password) throws ClassNotFoundException, SQLException;
	public boolean forgotPassword(String emailId, Long contactNo);
}
