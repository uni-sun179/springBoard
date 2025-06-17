package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.BoardUser;
import com.example.demo.entity.LoginUser;
import com.example.demo.entity.Role;
import com.example.demo.repository.BoardUserMapper;

import lombok.RequiredArgsConstructor;

//カスタム認証サービス
@Service
@RequiredArgsConstructor
public class LoginUserDetailsServiceImpl implements UserDetailsService{
	
	//DI
	private  final BoardUserMapper boardUserMapper;
	
	public UserDetails loadUserByUsername(String username) throws
	UsernameNotFoundException{
		
		BoardUser boardUser = boardUserMapper.selectUserByUserName(username);
		
		if(boardUser != null) {
			return new LoginUser(
					boardUser.getId(),
					boardUser.getUsername(),
					boardUser.getPassword(),
					getAuthorityList(boardUser.getAuthority())
			);
		}
		else {
			throw new UsernameNotFoundException(
					username + " => 指定しているユーザーは存在しません");
			
		}
	}
	
	//権限情報をリストで取得
	private List<GrantedAuthority> getAuthorityList(Role role){
		//権限リスト
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		authorities.add(new SimpleGrantedAuthority(role.name()));
		if(role == Role.ADMIN) {
			authorities.add(
					new SimpleGrantedAuthority(role.USER.toString()));
		}
		
		return authorities;
	}
}
