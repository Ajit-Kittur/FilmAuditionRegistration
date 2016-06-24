package com.actingregistration.serviceImpl;

import java.sql.SQLException;

import com.actingregistration.dao.ActorDao;
import com.actingregistration.daoImpl.ActorDaoImpl;
import com.actingregistration.entities.Actor;
import com.actingregistration.service.ActorService;

public class ActorServiceImpl implements ActorService{

	ActorDao actorDao=new ActorDaoImpl();
	Actor actor;
	
	@Override
	public boolean actorRegistration(String firstName, String lastName, String emailId, String password, long contactNo)
			throws ClassNotFoundException, SQLException {
		if(actorDao.isActorValid(emailId))
			return false;
		else {
			actor=new Actor(firstName, lastName, emailId, password, contactNo);
			actorDao.saveActor(actor);
			return true;
		}
	}

	@Override
	public Actor actorLogin(String emailId, String password) throws ClassNotFoundException, SQLException {
		actor=actorDao.getActor(emailId, password);
		System.out.println(actor);
		if(actor != null){
			if(actorDao.forLoginCheck(emailId, password)){
				actor.setLoginStatus(false);
			}
			else{
				actor.setLoginStatus(true);
			}
			actorDao.updateActor(actor);
			return actor;
		}
		else{
			return null;
		}
	}

	@Override
	public Actor getActor(String emailId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
