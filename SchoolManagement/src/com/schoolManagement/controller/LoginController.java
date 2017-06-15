package com.schoolManagement.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.schoolManagement.bean.Login;
import com.schoolManagement.services.LoginServiceImpl;
@Controller
@SessionAttributes("loginSession")
public class LoginController {

	private LoginServiceImpl loginServices;

	public LoginServiceImpl getLoginServices() {
		return loginServices;
	}
@Autowired
	public void setLoginServices(LoginServiceImpl loginServices) {
		this.loginServices = loginServices;
	}
@ModelAttribute("loginSession")
public Login getLoginSession(){
	return new Login();	
}
@RequestMapping("login")
public String login(@ModelAttribute Login login,ModelMap model,HttpServletResponse response)
{
	
	String role=loginServices.validLogin(login);
	
if(role=="admin")
{
	model.addAttribute("loginSession",login);

	return "admin/welcome";
}
	else if(role=="school")
		
{		
		model.addAttribute("loginSession",login);

		String schId=loginServices.getSchId(login);
		System.out.println("School Id @ cookie = "+schId);
		response.addCookie(new Cookie("schoolId", schId));
	return "school/welcome";
}
	else if(role=="distributor")
	{
		model.addAttribute("loginSession",login);

		model.addAttribute("message", "Hello Distributor");
	return "distributor/welcome";
	}
	else if(role=="approver")
	{
		model.addAttribute("loginSession",login);

		String schIdApp=loginServices.getSchIdApp(login);
		System.out.println("School id Approver = "+schIdApp);
		
		model.addAttribute("stuDetails", loginServices.getStudentDetails(schIdApp,login));
	return "approver/welcome";
	}
	else
	model.addAttribute("message", "Oops! Invalid Login "+login.getEmail());
return "../../index";
	}
@RequestMapping("logout")
public String logout()
{
	return "../../index";
}
}
