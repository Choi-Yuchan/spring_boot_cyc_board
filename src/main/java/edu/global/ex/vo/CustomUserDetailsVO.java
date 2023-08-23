package edu.global.ex.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomUserDetailsVO implements UserDetails {

	private String username;
	private String password;
	private List<GrantedAuthority> authorities;

	public CustomUserDetailsVO(UserVO user) {
		this.setAuthorities(user);
		this.setPassword(user.getPassword());
		this.setUsername(user.getUsername());
	}

	// setter 함수
	public void setUsername(String username) {
		this.username = username;
	}

	// setter 함수
	public void setPassword(String password) {
		this.password = password;
	}

	// setter
	public void setAuthorities(UserVO userVO) {

		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		for (AuthVO auth : userVO.getAuthList()) {
			authorities.add(new SimpleGrantedAuthority(auth.getAuthority()));
		}

		this.authorities = authorities;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}
	
	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
