package com.schoolManagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.schoolManagement.bean.AddStudent;
import com.schoolManagement.bean.Login;
import com.schoolManagement.dao.LoginDaoImpl;
@Component("loginServices")
public class LoginServiceImpl implements LoginService{
private LoginDaoImpl loginDao;

public LoginDaoImpl getLoginDao() {
	return loginDao;
}
@Autowired
public void setLoginDao(LoginDaoImpl loginDao) {
	this.loginDao = loginDao;
}
@Override
public String validLogin(Login login) {
	return loginDao.validLoginDao(login);
}
@Override
public String getSchId(Login login) {
	return loginDao.getSchIdDao(login);
}
@Override
public List<AddStudent> getStudentDetails(String schoolId,Login login) {
	return loginDao.getStudentDetailsDao(schoolId,login);
}
@Override
public String getSchIdApp(Login login) {
	return loginDao.getSchIdAppDao(login);
}
}
