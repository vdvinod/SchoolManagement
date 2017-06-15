package com.schoolManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.schoolManagement.services.SchoolServicesImpl;

@Controller
public class ApproverController {
	SchoolServicesImpl schoolServices;
public SchoolServicesImpl getSchoolServices() {
		return schoolServices;
	}
@Autowired
	public void setSchoolServices(SchoolServicesImpl schoolServices) {
		this.schoolServices = schoolServices;
	}

@RequestMapping("approveStu")
private String approveStu(ModelMap model,@RequestParam String approverEmail,@RequestParam String rollNo,@CookieValue(value="schoolId",defaultValue="null")String schoolId)
{
	System.out.println("Approver email = "+approverEmail+" RollNo Student = "+rollNo);
	if(schoolServices.approveStu(approverEmail,rollNo))
		model.addAttribute("resultSuccess"," Student Approved ");
	else
		model.addAttribute("resultFail"," Oops!! Student not Approved ");

	model.addAttribute("stuDetails", schoolServices.getStudentDetails(schoolId,approverEmail));

	return "approver/welcome";
}
@RequestMapping("moreDetails")
public String moreDetails(@RequestParam String rollNo,@RequestParam String schoolId,ModelMap model)
{
	model.addAttribute("showStudent", schoolServices.showStudent(schoolId,rollNo));
	return"approver/showStudent";
}
@RequestMapping("backToWelcome")
public String backToWelcome()
{
	return "approver/welcome";
}
}
