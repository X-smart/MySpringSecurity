package cn.com.taiji.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	// 简单的项目 平级开发
//	@Bean
//	public UserDetailsService userDetailsService() {
//		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//		manager.createUser(User.withUsername("user").password("password").roles("USER").build());
//		manager.createUser(User.withUsername("root").password("root").roles("root").build());
//		return manager;
//	}

	// 作用：默认所有的url必须是登录（认证）过后才能访问
	// protected void configure(HttpSecurity http) throws Exception {
	// http
	// .authorizeRequests().antMatchers("/in","/about").permitAll()
	// .anyRequest().authenticated()
	// .and()
	// .formLogin()
	// .and()
	// .httpBasic();
	// }
//	@Bean
//	protected void registerAuthentication(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("user") // #1 在内存中添加用户
//				.password("password").roles("USER").and().withUser("admin") // #2 给用户添加角色
//				.password("password").roles("ADMIN", "USER");
//	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**"); // #3 不验证该路径下的请求，
	}

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.csrf().disable();
//		http
//		// #4 不验证该请求 http请求的方式，跳过所有的静态资源 css js
//		.authorizeRequests().antMatchers("/signup", "/about").permitAll() 
//				.antMatchers("/admin/**").hasRole("ADMIN") // #6 给相关角色相关的访问权限
//				.anyRequest().authenticated() // #7 其余所有的url都需要登录
//				.and().formLogin() // #8 默认使用form提交的方式
//				.loginPage("/login") // #9  重写登录页面，不需要权限
//				.permitAll(); // #5 
//	}

	
	@Autowired
	 public void configureGlobal(AuthenticationManagerBuilder auth)
	   throws Exception {
	  auth.inMemoryAuthentication().withUser("username").password("password")
	    .roles("USER").
	  and().withUser("root").password("root")
	    .roles("ROOT");
	 }

	 protected void configure(HttpSecurity http) throws Exception {
	  http.authorizeRequests().antMatchers("/login").permitAll()
	  .anyRequest().authenticated().and().formLogin().loginPage("/login")
	    .and().httpBasic()
	    .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	    .and().csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()); // 开启csrf的代码
	  http.csrf().disable();
	 }
}
