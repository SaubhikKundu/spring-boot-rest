package com.saubhik.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.saubhik.beans.Department;
import com.saubhik.beans.Welcome;
import com.saubhik.services.DepartmentService;

@Controller
public class WelcomeController {

	private static final String welcomemsg = "Welcome Mr. %s!";
    @Autowired
    private DepartmentService departmentService;
	
	@GetMapping("/welcome/user")
    @ResponseBody
    public Welcome welcomeUser(@RequestParam(name="name", required=false, defaultValue="Java Fan") String name) {
		
        return new Welcome(String.format(welcomemsg, name));
    }

	@GetMapping("/dept")
    @ResponseBody
    public String deptDetaills(@RequestParam(name="deptno", required=false, defaultValue="10") String deptno) {
		return departmentService.getById(deptno).getDeptName();
    }
}
