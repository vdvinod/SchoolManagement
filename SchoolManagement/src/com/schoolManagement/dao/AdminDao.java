package com.schoolManagement.dao;

import java.util.List;
import java.util.Map;

import com.schoolManagement.bean.AddSchool;
import com.schoolManagement.bean.AddStudent;
import com.schoolManagement.bean.NewCategory;
import com.schoolManagement.bean.NewClass;
import com.schoolManagement.bean.NewDivision;
import com.schoolManagement.bean.SenderName;

public interface AdminDao {
	public boolean addSchoolDao(AddSchool addSchool);
	public String getSchoolId();
	public Map<String,String> getSchoolNameDao();
	public boolean addStudentDao(AddStudent newStudent);
	public List<NewClass> getSchoolClassDao(String schoolId);
	public List<NewDivision> getSchoolDivDao(String schoolId);
	public List<NewClass> getClassListFilterDao(String schId);
	public List<NewDivision> getDivListFilterDao(String schId);
	public List<AddStudent> showApprovedStudentDetailsDao( );
	public List<AddStudent> showPendingStudentDetailsDao( ); 
	public List<AddStudent> showApprovedStudentDetailsDao(String schoolId);
	public List<AddStudent> showPendingStudentDetailsDao(String schoolId );
	public List<AddStudent> approvedStudentDetailsSchClassFilterDao(String schoolId,String schClass);
	public List<AddStudent> pendingStudentDetailsSchClassFilterDao(String schoolId,String schClass);
	public List<AddStudent> approvedStudentDetailsSchDivFilterDao(String schoolId,String schClass,String schDiv);
	public List<AddStudent> pendingStudentDetailsSchDivFilterDao(String schoolId,String schClass,String schDiv);
	public List<AddStudent> approvedStudentDetailsOtherFilterDao(String schoolId,String rollNoFilter,String mobileFilter);
	public List<AddStudent> pendingStudentDetailsOtherFilterDao(String schoolId,String rollNoFilter,String mobileFilter);
	public AddStudent editStudentDao(String schoolId,String rollNo);
	public AddStudent showStudentDao(String schId, String rollNo);
	public boolean addClassDao(NewClass newClass);
	public boolean addDivisionDao(NewDivision newDivision);
	public boolean addCategoryDao(NewCategory newCategory);
public List<AddSchool> getSchoolListDao();
public AddSchool editSchoolDao(String schoolId);
public boolean editStudentAdminDao(AddStudent newStudent);
public boolean editSchoolAdminDao(AddSchool addSchool);
public List<NewCategory> getCategoryDao(String schoolId);
public boolean newSenderAddDao(SenderName newSender);
public List<SenderName> getSenderNameDao();
public String getSchoolNameDao(String schoolId);
}
