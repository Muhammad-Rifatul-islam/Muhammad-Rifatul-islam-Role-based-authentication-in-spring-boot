package bd.edu.rifat.group.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import bd.edu.rifat.group.model.User;

public class GroupUserDetails implements UserDetails{
   
	private String username;
	private String password;
	private boolean isActive;
	private List<GrantedAuthority> Authorities;
	
	public GroupUserDetails(User user) {
		this.username=user.getUserName();
		this.password=user.getPassword();
		this.isActive=user.isActive();
		this.Authorities=Arrays.stream(user.getRoles().split(",")).
				map(SimpleGrantedAuthority :: new).collect(Collectors.toList());
		
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return Authorities;
	}

	@Override
	public String getPassword() {
		
		return password;
	}

	@Override
	public String getUsername() {
		
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
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
		
		return isActive;
	}

}
