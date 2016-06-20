package com.actingregistration.main;

import com.actingregistration.dao.ActorDao;
import com.actingregistration.dao.VideoDao;
import com.actingregistration.daoImpl.ActorDaoImpl;
import com.actingregistration.daoImpl.VideoDaoImpl;

public class TestMain {

	public static void main(String[] args) {
		
		ActorDao actorDao=new ActorDaoImpl();
		VideoDao videoDao=new VideoDaoImpl();
	}

}
