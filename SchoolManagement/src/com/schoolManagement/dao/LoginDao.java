package com.schoolManagement.dao;

import java.util.List;

import com.schoolManagement.bean.AddStudent;
import com.schoolManagement.bean.Login;

public interface LoginDao {
	public String validLoginDao(Login login);
	public String  getSchIdDao(Login login);
	public List<AddStudent> getStudentDetailsDao(String schoolId,Login login);
	public String  getSchIdAppDao(Login login);

}
