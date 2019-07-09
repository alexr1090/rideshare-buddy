package com.example.demo.npspring5_tutorial.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;






@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
//	@Override
//	@Bean
//	public AuthenticationManager authenticationManagerBean() throws Exception {
//	    return super.authenticationManagerBean();
//	}


//	@Autowired
//	private MyUserDetailsService userDetailsService;
//	 
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth)
//	  throws Exception {
//	    auth.authenticationProvider(authenticationProvider());
//	}
//	 
//	@Bean
//	public DaoAuthenticationProvider authenticationProvider() {
//	    DaoAuthenticationProvider authProvider
//	      = new DaoAuthenticationProvider();
//	    authProvider.setUserDetailsService(userDetailsService);
//	    authProvider.setPasswordEncoder(encoder());
//	    return authProvider;
//	}
//	 
//	@Bean
//	public PasswordEncoder encoder() {
//	    return new BCryptPasswordEncoder(11);
//	} All this stuff is used for logging in against a database
	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//		auth.parentAuthenticationManager(authenticationManagerBean());
//			.userDetailsService(UserServiceImpl);
//	}
	// @formatter:off
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/css/**", "/js/**", "/images/**").permitAll(); //required to show page properly with spring security
		http.authorizeRequests().antMatchers("/logout").permitAll();
		
		http
			.csrf().disable()
			.authorizeRequests()
			.anyRequest().authenticated()
			.and().formLogin().loginPage("/login").permitAll();
		//login is permitted to all
		http.headers().frameOptions().disable();	
		
	}
	
// @formatter:on
}
