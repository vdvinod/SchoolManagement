package com.schoolManagement.services;

import java.util.List;
import java.util.Map;

import com.schoolManagement.bean.AddSchool;
import com.schoolManagement.bean.AddStudent;
import com.schoolManagement.bean.NewCategory;
import com.schoolManagement.bean.NewClass;
import com.schoolManagement.bean.NewDivision;
import com.schoolManagement.bean.SenderName;

public interface AdminServices {
public boolean addSchoolService(AddSchool addSchool);
public String getSchoolId();
public Map<String,String> getSchoolName();
public boolean addStudent(AddStudent newStudent);
public List<NewClass> getSchoolClass(String schoolId);
public List<NewDivision> getSchoolDiv(String schoolId);
public List<NewClass> getClassListFilter(String schId);
public List<NewDivision> getDivListFilter(String schId);
public List<AddStudent> showApprovedStudentDetails( );
public List<AddStudent> showPendingStudentDetails( );
public List<AddStudent> showApprovedStudentDetails(String schoolId);
public List<AddStudent> showPendingStudentDetails(String schoolId );
public List<AddStudent> approvedStudentDetailsSchClassFilter(String schoolId,String schClass);
public List<AddStudent> pendingStudentDetailsSchClassFilter(String schoolId,String schClass);
public List<AddStudent> approvedStudentDetailsSchDivFilter(String schoolId,String schClass,String schDiv);
public List<AddStudent> pendingStudentDetailsSchDivFilter(String schoolId,String schClass,String schDiv);
public List<AddStudent> approvedStudentDetailsOtherFilter(String schoolId,String rollNoFilter,String mobileFilter);
public List<AddStudent> pendingStudentDetailsOtherFilter(String schoolId,String rollNoFilter,String mobileFilter);
public AddStudent editStudent(String schoolId,String rollNo);
public AddStudent showStudent(String schId, String rollNo);
public boolean addClass(NewClass newClass);
public boolean addDivision(NewDivision newDivision);
public boolean addCategory(NewCategory newCategory);
public List<AddSchool> getSchoolList();
public AddSchool editSchool(String schoolId);
public boolean editStudentAdmin(AddStudent newStudent);
public boolean editSchoolAdmin(AddSchool addSchool);
public List<NewCategory> getCategory(String schoolId);
public boolean newSenderAdd(SenderName newSender);
public List<SenderName> getSenderName();
public String getSchoolName(String schoolId);
}
