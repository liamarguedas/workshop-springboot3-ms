package com.sode.hroauth.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class User implements UserDetails, Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	
	private String email;
	private String password;

	private Set<Role> roles = new HashSet<>();

	public User() {
	}

	public User(Long id, String name, String email, String password) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles
				.stream()
				.map(r -> new SimpleGrantedAuthority(r.getRoleName()))
				.collect(Collectors.toList());
	}

	@Override
	public String getUsername() {
		return getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// NO LOGIC NEEDED
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// NO LOGIC NEEDED
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// NO LOGIC NEEDED
		return true;
	}

	@Override
	public boolean isEnabled() {
		// NO LOGIC NEEDED
		return true;
	}
}
