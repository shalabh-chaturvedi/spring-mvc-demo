package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {
	//need controller method to show initial form
	
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	//need controller method to process the form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	@RequestMapping("/processFormVersionTwo")
	public String addDataToModel(HttpServletRequest request, Model model) {
		//read the request parameter from HTML form
		String studentName = request.getParameter("studentName");
		
		//convert to uppercase
		studentName = studentName.toUpperCase();
		
		//create message
		String result = "Yo" + studentName;
		
		//add message to model
		model.addAttribute("message", result);
		
		return "helloworld";
	}
	
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("studentName") String studentName, Model model) {
		
		//convert to uppercase
		studentName = studentName.toUpperCase();
		
		//create message
		String result = "Yo! " + studentName;
		
		//add message to model
		model.addAttribute("message", result);
		
		return "helloworld";
	}
}
