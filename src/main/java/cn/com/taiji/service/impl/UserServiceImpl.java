package cn.com.taiji.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import cn.com.taiji.bean.User;
import cn.com.taiji.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	
	List<User> listuser = new ArrayList<User>();
	
	@Override
	public void loginSucc() {
		// TODO Auto-generated method stub
		
		System.out.println("登录成功！！");
	}

	@Override
	public void JSRTest() {
		// TODO Auto-generated method stub
		System.out.println("使用JSR-250的注解");
	}

	@Override
	public String JSRTestRe() {
		// TODO Auto-generated method stub
		System.out.println("使用JSR-250的注解，并返回一个字符串对象");
		return "JSRTestRe";
	}

	@Override
	public List<User> listUser(List<User> users) {
		// TODO Auto-generated method stub
		//创建User
				User u1=new User("username","password",23,"男");
				User u2=new User("root","root",30,"男");
				User u3=new User("xiaoming","123456",25,"女");
				
				listuser.add(u1);
				listuser.add(u2);
				listuser.add(u3);
		return listuser;
	}

	@Override
	public List<User> delete(String name) {
		// TODO Auto-generated method stub
		for (User user : listuser) {  
	          if (user.getLoginName().equals(name)) {  
	        	  listuser.remove(user);  
	              break;  
	          }  
	      } 
	  return listuser;

	}

	

}
