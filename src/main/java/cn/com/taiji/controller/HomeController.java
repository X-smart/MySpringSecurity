package cn.com.taiji.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping(value="/",method=RequestMethod.GET)
	public String index(Principal pr) {
		String name = pr.getName();
		
		System.out.println(name);
		return "index";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String denglu() {
		System.out.println("myloginGET");
		return "login";
	}
	
	
	
	
}
