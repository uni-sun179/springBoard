package com.example.demo.entity;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

//ユーザーの認証情報
public class LoginUser extends User {
	
	//独自のフィールド
	private Integer id;
	
	public LoginUser(Integer id, String username,
			String password,
			Collection<? extends GrantedAuthority> authorities) {
			
			super(username,password,authorities);
			this.id = id;
	}
	
	public Integer getId() {
		return this.id;
	}
}
