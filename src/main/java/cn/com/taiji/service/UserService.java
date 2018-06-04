package cn.com.taiji.service;

import java.util.List;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;

import cn.com.taiji.bean.User;

public interface UserService {
	@Secured("ROLE_ROOT") //spring 的注解
	public void loginSucc() ;
	
	@PreAuthorize("hasRole('ROLE_ROOT')")
	public void JSRTest();
	
	@PostAuthorize("returnObject=='JSRTestRe'")
	public String JSRTestRe();
	
	//root 和 user都可以执行该方法，但root可以看到所有的用户，user只能看到自己
	@PreAuthorize("hasAnyRole({'ROLE_ROOT','ROLE_USER'})")
	@PostFilter("hasRole('ROLE_ROOT')||"+"filterObject.loginName == principal.username")
	public List<User> listUser(List<User> users);
	
	public List<User> delete(String name);

	
}
