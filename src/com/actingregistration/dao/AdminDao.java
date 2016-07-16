package com.actingregistration.dao;

import java.sql.SQLException;

import com.actingregistration.entities.Admin;

public interface AdminDao {

	public boolean saveAdmin(Admin admin);
	public boolean isAdminValid(String emailId) throws ClassNotFoundException, SQLException; 
	public Admin getAdmin(String emailId, String password) throws ClassNotFoundException, SQLException;
	public boolean updateAdmin(Admin admin);
	public Admin getAdminByemailId(String emailId) throws ClassNotFoundException, SQLException;
	public boolean forLoginCheck(String emailId, String password) throws ClassNotFoundException, SQLException;
	public boolean forgotPassword(String emailId, Long contactNo);
}
