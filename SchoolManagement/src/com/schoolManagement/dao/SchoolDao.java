package com.schoolManagement.dao;

import java.util.List;

import com.schoolManagement.bean.AddStudent;
import com.schoolManagement.bean.NewCategory;
import com.schoolManagement.bean.NewClass;
import com.schoolManagement.bean.NewDivision;

public interface SchoolDao {
	public boolean addDivisionDao(NewDivision newDivision);
	public boolean addClassDao(NewClass newClass);
	public List<NewClass> getSchoolClassDao(String schoolId);
	public List<NewDivision> getSchoolDivDao(String schoolId);
	public String getLoginSchoolDao(String schoolId);
	public boolean addStudentDao(AddStudent newStudent);
	public List<AddStudent> showApprovedStudentDetailsDao(String schoolId);
	public AddStudent editStudentDao(String rollNo);
	public List<AddStudent> showPendingStudentDetailsDao(String schoolId); 
	public List<AddStudent> showApprovedStudentDetailsDao(String schoolId,String classFilter,String divFilter,String rollNoFilter,String mobileFilter);
	public List<AddStudent> showPendingStudentDetailsDao(String schoolId,String classFilter,String divFilter,String rollNoFilter,String mobileFilter);
	public AddStudent showStudentDao(String schoolId,String rollNo);
	public boolean addCategoryDao(NewCategory newCategory);
	public boolean editStudentSchDao(AddStudent addStudent);
	public List<NewCategory> getCategoryDao(String schoolId);
	//Approver Functions 
	
	
	public boolean approveStuDao(String email,String rollNo);
	public List<AddStudent> getStudentDetailsDao(String schoolId,String login);
}
