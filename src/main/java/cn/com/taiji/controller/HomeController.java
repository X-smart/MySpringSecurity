package cn.com.taiji.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.com.taiji.bean.User;
import cn.com.taiji.service.UserService;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;
	
	//登陆成功跳转页面
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String index(Principal pr,Model model) {
		//取当前用户
		String name = pr.getName();
	
		System.out.println(name);
		//userService.loginSucc();
		//userService.JSRTest();
//		String testRe = userService.JSRTestRe();
//		System.out.println(testRe);
		List<User>  listuser=new ArrayList<User>();
		List<User> user = userService.listUser(listuser);
		model.addAttribute("userlist", user);
		System.out.println(user);
		return "index";
	}
	
	//跳转到登录页面
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String denglu() {
		System.out.println("myloginGET");
		return "login";
	}
	
	//删除用户
		@RequestMapping(value="/delete",method=RequestMethod.GET)
		public String delete(String name,Model model) {
			
			System.out.println(name);
			List<User> deleteuser = userService.delete(name);
			model.addAttribute("userlist", deleteuser);
			return "index";
		}
		
	
	
	
}
