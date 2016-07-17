package com.actingregistration.serviceImpl;

import java.sql.SQLException;

import com.actingregistration.dao.AdminDao;
import com.actingregistration.daoImpl.AdminDaoImpl;
import com.actingregistration.entities.Admin;
import com.actingregistration.service.AdminService;
import com.actingregistration.utils.EncryptDecryptData;
import com.actingregistration.utils.SystemGeneratedMail;

public class AdminServiceImpl implements AdminService{

	AdminDao adminDao=new AdminDaoImpl();
	Admin admin;
	
	@Override
	public boolean adminRegistration(String firstName, String lastName, String emailId, String password, long contactNo)
			throws ClassNotFoundException, SQLException, Exception {
		if(adminDao.isAdminValid(emailId))
			return false;
		else {
			admin=new Admin(firstName, lastName, emailId, contactNo, EncryptDecryptData.encrypt(password));
			adminDao.saveAdmin(admin);
			if (SystemGeneratedMail.sendMail(emailId, "Thank You for Registering to FilmAudition.com", "System Generated Mail"))
				System.out.println("Mail Sent");;
			return true;
		}
	}

	@Override
	public Admin adminLogin(String emailId, String password) throws ClassNotFoundException, SQLException, Exception {
		admin=adminDao.getAdmin(emailId, EncryptDecryptData.encrypt(password));
		System.out.println(admin);
		if(admin != null){
			if(adminDao.forLoginCheck(emailId, EncryptDecryptData.encrypt(password))){
				admin.setLoginStatus(false);
			}
			else{
				admin.setLoginStatus(true);
			}
			adminDao.updateAdmin(admin);
			return admin;
		}
		else{
			return null;
		}
	}

	@Override
	public Admin getAdmin(String emailId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean forgotPassword(String emailId, String password, Long contactNo)
			throws ClassNotFoundException, SQLException, Exception {
		System.out.println(emailId);
		System.out.println(password);
		if(adminDao.forgotPassword(emailId, contactNo)){
			admin=adminDao.getAdminByemailId(emailId);
			admin.setPassword(EncryptDecryptData.encrypt(password));
			adminDao.updateAdmin(admin);
			return true;
		}
		else {
			return false;
		}
	}

}
