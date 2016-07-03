package com.actingregistration.serviceImpl;

import java.sql.SQLException;

import com.actingregistration.dao.ActorDao;
import com.actingregistration.daoImpl.ActorDaoImpl;
import com.actingregistration.entities.Actor;
import com.actingregistration.service.ActorService;
import com.actingregistration.utils.EncryptDecryptData;
import com.actingregistration.utils.SystemGeneratedMail;

public class ActorServiceImpl implements ActorService{

	ActorDao actorDao=new ActorDaoImpl();
	Actor actor;
	
	@Override
	public boolean actorRegistration(String firstName, String lastName, String emailId, String password, long contactNo)
			throws Exception {
		if(actorDao.isActorValid(emailId))
			return false;
		else {
			actor=new Actor(firstName, lastName, emailId, EncryptDecryptData.encrypt(password), contactNo);
			actorDao.saveActor(actor);
			if (SystemGeneratedMail.sendMail(emailId, "Thank You for Registering to FilmAudition.com", "System Generated Mail"))
				System.out.println("Mail Sent");;
			return true;
		}
	}

	@Override
	public Actor actorLogin(String emailId, String password) throws Exception {
		actor=actorDao.getActor(emailId, EncryptDecryptData.encrypt(password));
		System.out.println(actor);
		if(actor != null){
			if(actorDao.forLoginCheck(emailId, EncryptDecryptData.encrypt(password))){
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
