package com.actingregistration.daoImpl;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.actingregistration.dao.AdminDao;
import com.actingregistration.entities.Admin;
import com.actingregistration.utils.EntityFactory;

public class AdminDaoImpl implements AdminDao{

	private EntityManagerFactory entityManagerFactory=null;
	
	public AdminDaoImpl(){
		entityManagerFactory=EntityFactory.getEntityManagerFactory();
	}
	
	@Override
	public boolean saveAdmin(Admin admin) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction =null;
		try{
			entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.persist(admin);
			entityTransaction.commit();
			entityManager.close();
		}catch(Exception e){
			System.out.println("Error in persisting Admin");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean isAdminValid(String emailId) throws ClassNotFoundException, SQLException {
		Entity entityAnno=Admin.class.getAnnotation(Entity.class);
		System.out.println(entityAnno.name());
		EntityManager entitymanager=entityManagerFactory.createEntityManager();
		Query query=entitymanager.createQuery("Select u.emailId from Admin u where u.emailId=:emailId");
		query.setParameter("emailId", emailId);
		List<String>list= query.getResultList(); 
		if(list.isEmpty())
			return false;
		return true;
	}
	
	@Override
	public boolean forLoginCheck(String emailId, String password) throws ClassNotFoundException, SQLException {
		Entity entityAnno=Admin.class.getAnnotation(Entity.class);
		System.out.println(entityAnno.name());
		EntityManager entitymanager=entityManagerFactory.createEntityManager();
		Query query=entitymanager.createQuery("Select u.loginStatus from Admin u where u.password=:password and u.emailId=:emailId");
		query.setParameter("password", password);
		query.setParameter("emailId", emailId);
		return (boolean) query.getSingleResult();
	}

	@Override
	public Admin getAdmin(String emailId, String password) throws ClassNotFoundException, SQLException {
		EntityManager entitymanager=entityManagerFactory.createEntityManager();
		Query query=entitymanager.createQuery("Select u from Admin u where u.emailId=:emailId");
		query.setParameter("emailId", emailId);
		Admin admin;
		try{
			admin= (Admin) query.getSingleResult(); 
		}catch(NoResultException nre){
			nre.printStackTrace();
			return null;
		}
		return admin;
	}

	@Override
	public boolean updateAdmin(Admin admin) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction =null;
		try{
			entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.merge(admin);
			entityTransaction.commit();
			entityManager.close();
		}catch(Exception e){
			System.out.println("Error in updating the admin");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Admin getAdminByemailId(String emailId) throws ClassNotFoundException, SQLException {
		EntityManager entitymanager=entityManagerFactory.createEntityManager();
		Query query=entitymanager.createQuery("Select u from Admin u where u.emailId=:emailId");
		query.setParameter("emailId", emailId);
		Admin admin;
		try{
			admin= (Admin) query.getSingleResult(); 
			System.out.println(admin);
		}catch(NoResultException nre){
			nre.printStackTrace();
			return null;
		}
		return admin;
	}

	@Override
	public boolean forgotPassword(String emailId, Long contactNo) {
		Entity entityAnno=Admin.class.getAnnotation(Entity.class);
		System.out.println(entityAnno.name());
		EntityManager entitymanager=entityManagerFactory.createEntityManager();
		Query query=entitymanager.createQuery("Select u.loginStatus from Admin u where u.contactNo=:contactNo and u.emailId=:emailId");
		query.setParameter("contactNo", contactNo);
		query.setParameter("emailId", emailId);
		return (boolean) query.getSingleResult();
	}

}
