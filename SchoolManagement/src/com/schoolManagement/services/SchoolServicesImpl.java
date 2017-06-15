package com.schoolManagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.schoolManagement.bean.AddStudent;
import com.schoolManagement.bean.NewCategory;
import com.schoolManagement.bean.NewClass;
import com.schoolManagement.bean.NewDivision;
import com.schoolManagement.dao.SchoolDaoImpl;

@Component("schoolServices")
public class SchoolServicesImpl implements SchoolServices{
private SchoolDaoImpl schoolDao;

public SchoolDaoImpl getSchoolDao() {
	return schoolDao;
}
@Autowired
public void setSchoolDao(SchoolDaoImpl schoolDao) {
	this.schoolDao = schoolDao;
}
@Override
public boolean addDivision(NewDivision newDivision) {
	return schoolDao.addDivisionDao(newDivision);
}
@Override
public boolean addClass(NewClass newClass) {
	return schoolDao.addClassDao(newClass);
}

@Override
public List<NewClass> getSchoolClass(String schoolId) {
	return schoolDao.getSchoolClassDao(schoolId);
}
@Override
public List<NewDivision> getSchoolDiv(String schoolId) {
	return schoolDao.getSchoolDivDao(schoolId);
}
@Override
public String getLoginSchool(String schoolId) {
	return schoolDao.getLoginSchoolDao(schoolId);
}
@Override
public boolean addStudent(AddStudent newStudent) {
	return schoolDao.addStudentDao(newStudent);
}
@Override
public List<AddStudent> showApprovedStudentDetails(String schoolId) {
	return schoolDao.showApprovedStudentDetailsDao(schoolId);
}
@Override
public AddStudent editStudent(String rollNo) {
	return schoolDao.editStudentDao(rollNo);
}
@Override
public List<AddStudent> showPendingStudentDetails(String schoolId) {
	return schoolDao.showPendingStudentDetailsDao(schoolId);

}
@Override
public List<AddStudent> showApprovedStudentDetails(String schoolId, String classFilter,String divFilter,String rollNoFilter,String mobileFilter) {
	return schoolDao.showApprovedStudentDetailsDao(schoolId,classFilter,divFilter,rollNoFilter,mobileFilter);
}
@Override
public List<AddStudent> showPendingStudentDetails(String schoolId, String classFilter,String divFilter,String rollNoFilter,String mobileFilter) {
	return schoolDao.showPendingStudentDetailsDao(schoolId,classFilter,divFilter,rollNoFilter,mobileFilter);
}
@Override
public AddStudent showStudent(String schId, String rollNo) {
	return schoolDao.showStudentDao(schId,rollNo);
}
@Override
public boolean addCategory(NewCategory newCategory) {
	return schoolDao.addCategoryDao(newCategory);
}

//Approver Functions

@Override
public boolean approveStu(String email,String rollNo) {
	return schoolDao.approveStuDao(email,rollNo);
}
@Override
public List<AddStudent> getStudentDetails(String schoolId, String login) {
	return schoolDao.getStudentDetailsDao(schoolId,login);
}
@Override
public boolean editStudentSch(AddStudent addStudent) {
	
	return schoolDao.editStudentSchDao(addStudent);
}
@Override
public List<NewCategory> getCategory(String schoolId) {
	
	return schoolDao.getCategoryDao(schoolId);
}
}
