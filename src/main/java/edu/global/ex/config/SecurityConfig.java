package edu.global.ex.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import edu.global.ex.security.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	} 

	@Override
	public void configure(WebSecurity web) throws Exception {
		// web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
		web.ignoring().antMatchers("/css/**", "/js/**", "/img/**", "/lib/**");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//	       auth.inMemoryAuthentication()
//	               .withUser("member").password("{noop}member").roles("USER").and()
//	               .withUser("admin").password("{noop}admin").roles("ADMIN");

		auth.userDetailsService(customUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// 우선 CSRF설정을 해제한다.
		// 초기 개발시만 해주는게 좋다.
//		http.csrf().disable();

		// authorization & authentication
		http.authorizeRequests().antMatchers("/user/**").hasAnyRole("USER").antMatchers("/admin/**").hasAnyRole("ADMIN")
				.antMatchers("/**").permitAll();

		http.formLogin().loginPage("/login").defaultSuccessUrl("/").permitAll();
	}
}
