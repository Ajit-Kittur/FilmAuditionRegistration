package com.actingregistration.service;

import java.sql.SQLException;

import com.actingregistration.entities.Admin;

public interface AdminService {
	public boolean adminRegistration(String firstName, String lastName, String emailId, String password, long contactNo) throws ClassNotFoundException, SQLException, Exception;
	public Admin adminLogin(String emailId, String password) throws ClassNotFoundException, SQLException, Exception;
	public Admin getAdmin(String emailId) throws ClassNotFoundException, SQLException;
	public Boolean forgotPassword(String emailId, String password, Long contactNo) throws ClassNotFoundException, SQLException, Exception;

}
