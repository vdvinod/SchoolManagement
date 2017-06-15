package com.schoolManagement.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.schoolManagement.bean.AddSchool;
import com.schoolManagement.bean.AddStudent;
import com.schoolManagement.bean.NewCategory;
import com.schoolManagement.bean.NewClass;
import com.schoolManagement.bean.NewDivision;
import com.schoolManagement.bean.SenderName;
import com.schoolManagement.services.AdminServicesImpl;

@Controller

public class AdminController {
	private String className,idSch;
	private AdminServicesImpl adminServices;
	public AdminServicesImpl getAdminServices() {
		return adminServices;
	}
	@Autowired
	public void setAdminServices(AdminServicesImpl adminServices) {
		this.adminServices = adminServices;
	}
	

	@RequestMapping("addSchAdmin")
	public String addSch(ModelMap model)
	{
		String schId=adminServices.getSchoolId();
		AddSchool addSch=new AddSchool();
		addSch.setSchoolId(schId);
		model.addAttribute("schId",schId);
		model.addAttribute("schoolList", adminServices.getSchoolList());
		model.addAttribute("senderName",adminServices.getSenderName());
		return"admin/addSchool";
	}
	@RequestMapping("senderNameAdmin")
	public String senderName()
	{
		return"admin/senderName";
	}
	@RequestMapping("addSchoolAdmin")
	public String addSchool(@ModelAttribute AddSchool addSchool,ModelMap model)
	{
		System.out.println("Called through Add School Method");
		
		if(adminServices.addSchoolService(addSchool))
		{
			model.addAttribute("resultSuccess",addSchool.getSchoolName()+" School Added Successfully");
		}else
		{	model.addAttribute("resultFail",addSchool.getSchoolName()+"Oops! School Not Added Successfully");
		}
		String schId=adminServices.getSchoolId();
		AddSchool addSch=new AddSchool();
		addSch.setSchoolId(schId);
		model.addAttribute("schId",schId);
		model.addAttribute("schoolList", adminServices.getSchoolList());
		model.addAttribute("senderName",adminServices.getSenderName());

		return"admin/addSchool";
		}
	
	@RequestMapping(value="getSchoolClassAdmin")
	public @ResponseBody List<NewClass> ajaxTest(@RequestParam String schoolId,ModelMap model)
	{
		//model.addAttribute("category",adminServices.getCategory(schoolId));
		
		return adminServices.getSchoolClass(schoolId);
	}
	@RequestMapping(value="getSchoolDivisionAdmin")
	public @ResponseBody List<NewDivision> getSchoolDivision(@RequestParam String schoolId)
	{
		return adminServices.getSchoolDiv(schoolId);
	}
	@RequestMapping("addStudentAdmin")
	public String addStudentAdmin(@ModelAttribute AddStudent newStudent,ModelMap model)
	{
		if(adminServices.addStudent(newStudent))
		{	
			model.addAttribute("resultSuccess",newStudent.getStuFirstName() +" "+newStudent.getStuMiddleName()+" "+newStudent.getStuLastName()+" Student Added Successfully");
		}
		else
		{
			model.addAttribute("resultFail",newStudent.getStuFirstName() +" "+newStudent.getStuMiddleName()+" "+newStudent.getStuLastName()+" Oops!! Student not Added Successfully");
		}
		Map<String,String> schName=adminServices.getSchoolName();
		model.addAttribute("schoolList", schName);
		
		return"admin/addStudent";
	}
	@RequestMapping("showStuAdmin")
	public String addStu(ModelMap model)
	{
		model.addAttribute("showApprovedStudent", adminServices.showApprovedStudentDetails());
		model.addAttribute("showPendingStudent", adminServices.showPendingStudentDetails());
		Map<String,String> schName=adminServices.getSchoolName();
		model.addAttribute("schoolList", schName);
		return"admin/addStudent";
	}
	@RequestMapping("schNamefilterAdmin")
	public String schNamefilterAdmin(@RequestParam String schId,ModelMap model)
	{
		idSch=schId;
		Map<String,String> schName=adminServices.getSchoolName();
		model.addAttribute("schoolList", schName);
		model.addAttribute("classList",adminServices.getClassListFilter(schId));
		model.addAttribute("divList",adminServices.getDivListFilter(schId));
		model.addAttribute("showApprovedStudent", adminServices.showApprovedStudentDetails(schId));
		model.addAttribute("showPendingStudent", adminServices.showPendingStudentDetails(schId));

		return "admin/addStudent";
	}
	
	@RequestMapping("schClassFilterAdmin")
	public String schClassFilterAdmin(@RequestParam String schId,@RequestParam String schClass,ModelMap model)
	{
		Map<String,String> schName=adminServices.getSchoolName();
		model.addAttribute("schoolList", schName);
		model.addAttribute("classList",adminServices.getClassListFilter(schId));
		model.addAttribute("divList",adminServices.getDivListFilter(schId));
		model.addAttribute("showApprovedStudent", adminServices.approvedStudentDetailsSchClassFilter(schId,schClass));
		model.addAttribute("showPendingStudent", adminServices.pendingStudentDetailsSchClassFilter(schId,schClass));
		className=schClass;
		return "admin/addStudent";
	}
	@RequestMapping("schDivFilterAdmin")
	public String schDivFilterAdmin(@RequestParam String schId,@RequestParam String schDiv,ModelMap model)
	{
		Map<String,String> schName=adminServices.getSchoolName();
		model.addAttribute("schoolList", schName);
		model.addAttribute("classList",adminServices.getClassListFilter(schId));
		model.addAttribute("divList",adminServices.getDivListFilter(schId));
		model.addAttribute("showApprovedStudent", adminServices.approvedStudentDetailsSchDivFilter(schId,className,schDiv));
		model.addAttribute("showPendingStudent", adminServices.pendingStudentDetailsSchDivFilter(schId,className,schDiv));
	
		return "admin/addStudent";
	}
	@RequestMapping("filterFunctionAdmin")
	public String filterFunctionAdmin(@RequestParam String rollNoFilter ,@RequestParam String mobileFilter,ModelMap model,@CookieValue(value="schoolId",defaultValue="null")String schoolId)
	{
		Map<String,String> schName=adminServices.getSchoolName();
		model.addAttribute("schoolList", schName);
		
		model.addAttribute("showApprovedStudent", adminServices.approvedStudentDetailsOtherFilter(idSch,rollNoFilter,mobileFilter));
		model.addAttribute("showPendingStudent", adminServices.pendingStudentDetailsOtherFilter(idSch,rollNoFilter,mobileFilter));
	
		return "admin/addStudent";
	}
	@RequestMapping("editStuAdmin")
	public String editStudentSch(@RequestParam String rollNo,@RequestParam String schoolId,ModelMap model)
	{
		/*Map<String,String> schName=adminServices.getSchoolName();
		model.addAttribute("schoolList", schName);*/
		model.addAttribute("editStudent", adminServices.editStudent(schoolId,rollNo));
		model.addAttribute("schoolName",adminServices.getSchoolName(schoolId));
		model.addAttribute("className", adminServices.getSchoolClass(schoolId));
		model.addAttribute("divisionName",adminServices.getSchoolDiv(schoolId));

		return "admin/editStudent";
	}
	@RequestMapping("moreDetailsStuAdmin")
	public String moreDetailsStuAdmin(@RequestParam String rollNo,@RequestParam String schId,ModelMap model)
	{		
		model.addAttribute("schoolName",adminServices.getSchoolName(schId));
		model.addAttribute("showStudent",adminServices.showStudent(schId,rollNo));
		return "admin/showStudent";
	}
	@RequestMapping("newClassAdmin")
	public String newClassAdmin(ModelMap model)
	{
		Map<String,String> schName=adminServices.getSchoolName();
		model.addAttribute("schoolList", schName);
		return"admin/newClass";
	}
	@RequestMapping("addClassAdmin")
	public String addClassAdmin(@ModelAttribute NewClass newClass,ModelMap model)
	{
		
		if(adminServices.addClass(newClass))
		{	model.addAttribute("resultSuccess",newClass.getClassName()+" Class Added Successfully");
		}
		else
		{
			model.addAttribute("resultFail"," Oops! "+newClass.getClassName()+" Class Not Added Successfully");
		}
		return"admin/newClass";
	}
	
	@RequestMapping("newDivisionAdmin")
	public String newDivisionAdmin(ModelMap model)
	{
		Map<String,String> schName=adminServices.getSchoolName();
		model.addAttribute("schoolList", schName);
		return"admin/newDivision";
	}
	@RequestMapping("addDivisionAdmin")
	public String addDivision(@ModelAttribute NewDivision newDivision,ModelMap model)
	{
		
		if(adminServices.addDivision(newDivision))
		{	model.addAttribute("resultSuccess",newDivision.getNewDivision()+" Division Added Successfully");
		}
		else
		{
			model.addAttribute("resultFail",newDivision.getNewDivision()+"  Oops! Division Not Added Successfully");
		}
		return"admin/newDivision";
	}
	@RequestMapping("newCategoryAdmin")
	public String newCategoryAdmin(ModelMap model)
	{
		Map<String,String> schName=adminServices.getSchoolName();
		model.addAttribute("schoolList", schName);
		return"admin/newCategory";
	}
	@RequestMapping("addCategoryAdmin")
	public String addCategoryAdmin(@ModelAttribute NewCategory newCategory,ModelMap model)
	{
		
		if(adminServices.addCategory(newCategory))
		{	model.addAttribute("resultSuccess"," Category "+newCategory.getCategoryName()+" Added Successfully");
		}
		else
		{
			model.addAttribute("resultFail","  Oops! "+newCategory.getCategoryName()+" Category Not Added Successfully");
		}
		return"admin/newCategory";
	}
	
	@RequestMapping("editSchAdmin")
	public String editSchool(@RequestParam String schoolId,ModelMap model)
	{
		model.addAttribute("editSch", adminServices.editSchool(schoolId));
		return"admin/editSchool";
	}
	@RequestMapping("editStudentAdmin")
	public String editStudentAdmin(@ModelAttribute AddStudent newStudent,ModelMap model)
	{
		if(adminServices.editStudentAdmin(newStudent))
			model.addAttribute("resultSuccess", "Student "+newStudent.getStuFirstName()+" "+newStudent.getStuMiddleName()+" "+newStudent.getStuLastName()+" Updated SuccessFully");
		else	
			model.addAttribute("resultFail", "Oops !! "+newStudent.getStuFirstName()+" "+newStudent.getStuMiddleName()+" "+newStudent.getStuLastName()+"Student Not  Updated SuccessFully");
		return "admin/editStudent";
	}
	@RequestMapping("editSchoolAdmin")
	public String editSchoolAdmin(@ModelAttribute AddSchool addSchool,ModelMap model)
	{
		if(adminServices.editSchoolAdmin(addSchool))
			model.addAttribute("resultSuccess", "School "+addSchool.getSchoolName()+" Updated SuccessFully");
		else	
			model.addAttribute("resultFail", "Oops !! "+addSchool.getSchoolName()+"School Not  Updated SuccessFully");
		return "admin/editSchool";
	}
	@RequestMapping("newSenderAdmin")
	public String newSenderAdmin(@ModelAttribute SenderName newSender,ModelMap model)
	{
		if(adminServices.newSenderAdd(newSender))
			model.addAttribute("resultSuccess","Sender Name "+newSender.getSenderName()+" Added Successfully");
		else 
			model.addAttribute("resultFail","Oops !! Sender Name "+newSender.getSenderName()+" not  Added Successfully");
		
		return"admin/senderName";
		
	}
}
