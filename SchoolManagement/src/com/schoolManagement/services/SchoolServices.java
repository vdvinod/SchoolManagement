package com.schoolManagement.services;

import java.util.List;

import com.schoolManagement.bean.AddStudent;
import com.schoolManagement.bean.NewCategory;
import com.schoolManagement.bean.NewClass;
import com.schoolManagement.bean.NewDivision;

public interface SchoolServices {
	public boolean addDivision(NewDivision newDivision);
	public boolean addClass(NewClass newClass);
public List<NewClass> getSchoolClass(String schoolId);
public List<NewDivision> getSchoolDiv(String schoolId);
public String getLoginSchool(String schoolId);
public boolean addStudent(AddStudent newStudent);
public List<AddStudent> showApprovedStudentDetails(String schoolId);
public List<AddStudent> showPendingStudentDetails(String schoolId);
public List<AddStudent> showApprovedStudentDetails(String schoolId,String classFilter,String divFilter,String rollNoFilter,String mobileFilter);
public List<AddStudent> showPendingStudentDetails(String schoolId,String classFilter,String divFilter,String rollNoFilter,String mobileFilter);
public AddStudent editStudent(String rollNo);
public AddStudent showStudent(String schId,String rollNo);
public boolean addCategory(NewCategory newCategory);
public boolean editStudentSch(AddStudent addStudent);
public List<NewCategory> getCategory(String schoolId);
//Approver Functions
public boolean approveStu(String email,String rollNo);
public List<AddStudent> getStudentDetails(String schoolId,String login);
}
