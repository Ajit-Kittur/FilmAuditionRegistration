package com.actingregistration.daoImpl;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.actingregistration.dao.VideoDao;
import com.actingregistration.entities.Video;
import com.actingregistration.utils.EntityFactory;

public class VideoDaoImpl implements VideoDao{

	private EntityManagerFactory entityManagerFactory=null;
	public VideoDaoImpl(){
		entityManagerFactory=EntityFactory.getEntityManagerFactory();
	}
	
	@Override
	public boolean saveVideo(Video video) throws ClassNotFoundException, SQLException {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction =null;
		try{
			entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.persist(video);
			entityTransaction.commit();
			entityManager.close();
		}catch(Exception e){
			System.out.println("Error in persisting Video");
			return false;
		}
		return true;
	}

	@Override
	public Video getVideo(int actorId, int videoId) throws ClassNotFoundException, SQLException {
		Entity entityAnno=Video.class.getAnnotation(Entity.class);
		System.out.println(entityAnno.name());
		EntityManager entitymanager=entityManagerFactory.createEntityManager();
		Query query=entitymanager.createQuery("Select v from Video v where v.actor.actorId=:actorId and v.videoId=:videoId");
		query.setParameter("actorId", actorId);
		query.setParameter("videoId", videoId);
		Video video= (Video) query.getSingleResult(); 
		if(video != null)
			return video;
		return null;
	}

	@Override
	public List<Video> getAllVideos(int actorId) throws ClassNotFoundException, SQLException {
		Entity entityAnno=Video.class.getAnnotation(Entity.class);
		System.out.println(entityAnno.name());
		EntityManager entitymanager=entityManagerFactory.createEntityManager();
		Query query=entitymanager.createQuery("Select v from Video v wher v.actor.actorId=:actorId");
		query.setParameter("actorId", actorId);
		List<Video> list= query.getResultList(); 
		if(list.isEmpty())
			return null;
		return list;
	}

}
