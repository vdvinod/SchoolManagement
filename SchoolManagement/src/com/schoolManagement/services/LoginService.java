package com.schoolManagement.services;

import java.util.List;

import com.schoolManagement.bean.AddStudent;
import com.schoolManagement.bean.Login;

public interface LoginService {
public String validLogin(Login login);
public String  getSchId(Login login);
public List<AddStudent> getStudentDetails(String schoolId,Login login);
public String  getSchIdApp(Login login);

}
