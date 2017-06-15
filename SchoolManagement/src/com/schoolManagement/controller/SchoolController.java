package com.schoolManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.schoolManagement.bean.AddStudent;
import com.schoolManagement.bean.NewCategory;
import com.schoolManagement.bean.NewClass;
import com.schoolManagement.bean.NewDivision;
import com.schoolManagement.services.SchoolServicesImpl;

@Controller
public class SchoolController {
private SchoolServicesImpl schoolServices;

public SchoolServicesImpl getSchoolServices() {
	return schoolServices;
}
@Autowired
public void setSchoolServices(SchoolServicesImpl schoolServices) {
	this.schoolServices = schoolServices;
}

@RequestMapping("newClassSch")
public String newClass(ModelMap model,@CookieValue(value="schoolId",defaultValue="null")String schoolId)
{
	model.addAttribute("schName", schoolServices.getLoginSchool(schoolId));

	return"school/newClass";
}
@RequestMapping("newDivisionSch")
public String newDivision(ModelMap model,@CookieValue(value="schoolId",defaultValue="null")String schoolId)
{
	model.addAttribute("schName", schoolServices.getLoginSchool(schoolId));

	return"school/newDivision";
}
@RequestMapping("newCategorySch")
public String newCategory(ModelMap model,@CookieValue(value="schoolId",defaultValue="null")String schoolId)
{
	model.addAttribute("schName", schoolServices.getLoginSchool(schoolId));
	return"school/newCategory";
}
@RequestMapping("addCategorySch")
public String addCategorySch(@ModelAttribute NewCategory newCategory,ModelMap model,@CookieValue(value="schoolId",defaultValue="null")String schoolId)
{
	newCategory.setSchoolId(schoolId);
	System.out.println("cookie value at add division = "+newCategory.getSchoolId());
		if(schoolServices.addCategory(newCategory))
		{	model.addAttribute("resultSuccess",newCategory.getCategoryName()+" Category Added Successfully");
		}
		else
		{
			model.addAttribute("resultFail",newCategory.getCategoryName()+"  Oops! Category  Not Added Successfully");
		}
		model.addAttribute("schName", schoolServices.getLoginSchool(schoolId));

		return"school/newDivision";
}

@RequestMapping("addDivisionSch")
public String addDivision(@ModelAttribute NewDivision newDivision,ModelMap model,@CookieValue(value="schoolId",defaultValue="null")String schoolId)
{
	
newDivision.setSchoolId(schoolId);
System.out.println("cookie value at add division = "+newDivision.getSchoolId());
	if(schoolServices.addDivision(newDivision))
	{	model.addAttribute("resultSuccess"," Division "+newDivision.getNewDivision()+" Added Successfully");
	}
	else
	{
		model.addAttribute("resultFail","  Oops! "+newDivision.getNewDivision()+" Division Not Added Successfully");
	}
	model.addAttribute("schName", schoolServices.getLoginSchool(schoolId));

	return"school/newDivision";
}
@RequestMapping("addClassSch")
public String addClass(@ModelAttribute NewClass newClass,ModelMap model,@CookieValue(value="schoolId",defaultValue="null")String schoolId)
{
	
newClass.setSchoolId(schoolId);
	if(schoolServices.addClass(newClass))
	{	model.addAttribute("resultSuccess",newClass.getClassName()+" Class Added Successfully");
	}
	else
	{
		model.addAttribute("resultFail",newClass.getClassName()+"  Oops! Class Not Added Successfully");
	}
	model.addAttribute("schName", schoolServices.getLoginSchool(schoolId));

	return"school/newClass";
}
@RequestMapping("showStuSch")
public String addStu(ModelMap model,@CookieValue(value="schoolId",defaultValue="null")String schoolId)
{
	model.addAttribute("schoolClass", schoolServices.getSchoolClass(schoolId));
	model.addAttribute("schoolDiv", schoolServices.getSchoolDiv(schoolId));
	model.addAttribute("category", schoolServices.getCategory(schoolId));
	model.addAttribute("schName", schoolServices.getLoginSchool(schoolId));
	model.addAttribute("showApprovedStudent", schoolServices.showApprovedStudentDetails(schoolId));
	model.addAttribute("showPendingStudent", schoolServices.showPendingStudentDetails(schoolId));
	return"school/addStudent";
}
@RequestMapping(value="getSchoolDivisionSch")
public @ResponseBody List<NewDivision> getSchoolDivision(@CookieValue(value="schoolId",defaultValue="null")String schoolId)
{
	return schoolServices.getSchoolDiv(schoolId);
}

@RequestMapping("addStudentSch")
public String addStudentSch(@ModelAttribute AddStudent newStudent,ModelMap model,@CookieValue(value="schoolId",defaultValue="null")String schoolId)
{

newStudent.setSchoolId(schoolId);
	if(schoolServices.addStudent(newStudent))
	{	
		model.addAttribute("resultSuccess",newStudent.getStuFirstName() +" "+newStudent.getStuMiddleName()+" "+newStudent.getStuLastName()+" Student Added Successfully");
	}
	else
	{
		model.addAttribute("resultFail",newStudent.getStuFirstName() +" "+newStudent.getStuMiddleName()+" "+newStudent.getStuLastName()+" Oops!! Student not Added Successfully");
	}
	model.addAttribute("schoolClass", schoolServices.getSchoolClass(schoolId));
	model.addAttribute("schoolDiv", schoolServices.getSchoolDiv(schoolId));
	model.addAttribute("category", schoolServices.getCategory(schoolId));
	model.addAttribute("schName", schoolServices.getLoginSchool(schoolId));
	model.addAttribute("showApprovedStudent", schoolServices.showApprovedStudentDetails(schoolId));
	model.addAttribute("showPendingStudent", schoolServices.showPendingStudentDetails(schoolId));
	return"school/addStudent";
}

@RequestMapping("editStuSch")
public String editStudentSch(@RequestParam String rollNo,ModelMap model,@CookieValue(value="schoolId",defaultValue="null")String schoolId)
{
	model.addAttribute("schName", schoolServices.getLoginSchool(schoolId));
	model.addAttribute("schoolClass", schoolServices.getSchoolClass(schoolId));
	model.addAttribute("editStudent", schoolServices.editStudent(rollNo));
	return "school/editStudent";
}

@RequestMapping("filterFunction")
public String filterFunction(@RequestParam String classFilter,@RequestParam String divFilter,@RequestParam String rollNoFilter ,@RequestParam String mobileFilter,ModelMap model,@CookieValue(value="schoolId",defaultValue="null")String schoolId)
{
	model.addAttribute("schoolClass", schoolServices.getSchoolClass(schoolId));
	model.addAttribute("schName", schoolServices.getLoginSchool(schoolId));
	model.addAttribute("showApprovedStudent", schoolServices.showApprovedStudentDetails(schoolId,classFilter,divFilter,rollNoFilter,mobileFilter));
	model.addAttribute("showPendingStudent", schoolServices.showPendingStudentDetails(schoolId,classFilter,divFilter,rollNoFilter,mobileFilter));
	return"school/addStudent";
}
@RequestMapping("moreDetailsStuSch")
public String moreDetailsStudent(@RequestParam String rollNo,@RequestParam String schId,ModelMap model)
{
	model.addAttribute("showStudent",schoolServices.showStudent(schId,rollNo));
	model.addAttribute("schName", schoolServices.getLoginSchool(schId));

	return "school/showStudent";
}
@RequestMapping("editStudentSch")
public String editStudentSch(@ModelAttribute AddStudent addStudent,ModelMap model,@CookieValue(value="schoolId",defaultValue="null")String schoolId)
{
	if(schoolServices.editStudentSch(addStudent))
		model.addAttribute("resultSuccess","Student "+addStudent.getStuFirstName()+" "+addStudent.getStuMiddleName()+" "+addStudent.getStuLastName()+" Updated Successfully" );
	else
		model.addAttribute("resultFail","Oops !! Student "+addStudent.getStuFirstName()+" "+addStudent.getStuMiddleName()+" "+addStudent.getStuLastName()+" Updated Successfully" );

	model.addAttribute("schName", schoolServices.getLoginSchool(schoolId));
	model.addAttribute("schoolClass", schoolServices.getSchoolClass(schoolId));

	return "school/editStudent";
}

}
