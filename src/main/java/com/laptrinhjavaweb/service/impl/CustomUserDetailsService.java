package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.Constant.SystemConstant;
import com.laptrinhjavaweb.dto.MyUser;
import com.laptrinhjavaweb.entity.RoleEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userR;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity = userR.findOneByUserNameAndStatus(username, SystemConstant.ACTIVE_STATUS);
		if(userEntity == null)
			throw new UsernameNotFoundException("User not found");
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		for(RoleEntity role : userEntity.getRoles())
			authorities.add(new SimpleGrantedAuthority(role.getCode()));
		
		//put thong tin vao security de duy tri khi user login
		MyUser user = new MyUser(userEntity.getUserName(), userEntity.getPassword(), true, true, true, true, authorities);
		
		user.setFullName(userEntity.getFullName());
		return user;
	}
	
	

}