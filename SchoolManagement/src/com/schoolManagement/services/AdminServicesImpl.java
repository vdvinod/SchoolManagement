package com.schoolManagement.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.schoolManagement.bean.AddSchool;
import com.schoolManagement.bean.AddStudent;
import com.schoolManagement.bean.NewCategory;
import com.schoolManagement.bean.NewClass;
import com.schoolManagement.bean.NewDivision;
import com.schoolManagement.bean.SenderName;
import com.schoolManagement.dao.AdminDao;

@Component("adminServices")
public class AdminServicesImpl implements AdminServices{
	private AdminDao adminDao;

	public AdminDao getAdminDao() {
		return adminDao;
	}
@Autowired
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}
@Override
public boolean addSchoolService(AddSchool addSchool) {
	
	return adminDao.addSchoolDao(addSchool);
}
@Override
public String getSchoolId() {
	 
	
	return adminDao.getSchoolId();
}
@Override
public Map<String,String> getSchoolName() {
	return adminDao.getSchoolNameDao();
}

@Override
public List<NewClass> getSchoolClass(String schoolId) {
	return adminDao.getSchoolClassDao(schoolId);
}
@Override
public List<NewDivision> getSchoolDiv(String schoolId) {
	return adminDao.getSchoolDivDao(schoolId);
}

@Override
public List<NewClass> getClassListFilter(String schId) {
	return adminDao.getClassListFilterDao(schId);
}

@Override
public List<AddStudent> showApprovedStudentDetails( ) {
	return adminDao.showApprovedStudentDetailsDao();
}
@Override
public List<AddStudent> showPendingStudentDetails( ) {
	return adminDao.showPendingStudentDetailsDao();
}
@Override
public List<NewDivision> getDivListFilter(String schId) {
	return adminDao.getDivListFilterDao(schId);
}
@Override
public List<AddStudent> showApprovedStudentDetails(String schoolId) {
	return adminDao.showApprovedStudentDetailsDao(schoolId);
}
@Override
public List<AddStudent> showPendingStudentDetails(String schoolId) {
	return adminDao.showPendingStudentDetailsDao(schoolId);
}
@Override
public List<AddStudent> approvedStudentDetailsSchClassFilter(String schoolId, String schClass) {
	return adminDao.approvedStudentDetailsSchClassFilterDao(schoolId,schClass);
}
@Override
public List<AddStudent> pendingStudentDetailsSchClassFilter(String schoolId, String schClass) {
	return adminDao.pendingStudentDetailsSchClassFilterDao(schoolId,schClass);
}
@Override
public List<AddStudent> approvedStudentDetailsSchDivFilter(String schoolId, String schClass, String schDiv) {
	return adminDao.approvedStudentDetailsSchDivFilterDao(schoolId,schClass,schDiv);
}
@Override
public List<AddStudent> pendingStudentDetailsSchDivFilter(String schoolId, String schClass, String schDiv) {
	return adminDao.pendingStudentDetailsSchDivFilterDao(schoolId,schClass,schDiv);
}
@Override
public List<AddStudent> approvedStudentDetailsOtherFilter(String schoolId, String rollNoFilter, String mobileFilter) {
	return adminDao.approvedStudentDetailsOtherFilterDao(schoolId,rollNoFilter,mobileFilter);
}
@Override
public List<AddStudent> pendingStudentDetailsOtherFilter(String schoolId, String rollNoFilter, String mobileFilter) {
	return adminDao.pendingStudentDetailsOtherFilterDao(schoolId,rollNoFilter,mobileFilter);
}
@Override
public boolean addStudent(AddStudent newStudent) {
	return adminDao.addStudentDao(newStudent);
}
@Override
public AddStudent editStudent(String schoolId, String rollNo) {
	return adminDao.editStudentDao(schoolId,rollNo);
}
@Override
public AddStudent showStudent(String schId, String rollNo) {
	return adminDao.showStudentDao(schId,rollNo);
}
@Override
public boolean addClass(NewClass newClass) {
	return adminDao.addClassDao(newClass);
}
@Override
public boolean addDivision(NewDivision newDivision) {
	return adminDao.addDivisionDao(newDivision);
}
@Override
public boolean addCategory(NewCategory newCategory) {
	return adminDao.addCategoryDao(newCategory);
}
@Override
public List<AddSchool> getSchoolList() {
	return adminDao.getSchoolListDao();
}
@Override
public AddSchool editSchool(String schoolId) {
	return adminDao.editSchoolDao(schoolId);
}
@Override
public boolean editStudentAdmin(AddStudent newStudent) {
	
	return adminDao.editStudentAdminDao(newStudent);
}
@Override
public boolean editSchoolAdmin(AddSchool addSchool) {
	
	return adminDao.editSchoolAdminDao(addSchool);
}
@Override
public List<NewCategory> getCategory(String schoolId) {
	
	return adminDao.getCategoryDao(schoolId);
}
@Override
public boolean newSenderAdd(SenderName newSender) {
	
	return adminDao.newSenderAddDao(newSender);
}
@Override
public List<SenderName> getSenderName() {
	
	return adminDao.getSenderNameDao();
}
@Override
public String getSchoolName(String schoolId) {
	return adminDao.getSchoolNameDao(schoolId);
}


}
