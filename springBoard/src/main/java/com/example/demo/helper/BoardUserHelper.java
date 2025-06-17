package com.example.demo.helper;

import com.example.demo.entity.BoardUser;
import com.example.demo.form.BoardUserForm;

//エンティティとフォームの変換
public class BoardUserHelper {
	
	public static BoardUser convertBoardUser(BoardUserForm form) {
		BoardUser user = new BoardUser();
		
		user.setId(form.getId());
		user.setUsername(form.getUsername());
		user.setPassword(form.getPassword());
		user.setAuthority(form.getAuthority());
		
		return user;
	}
	
	public static BoardUserForm convertBoardUserForm(BoardUser user) {
		BoardUserForm form = new BoardUserForm();
		
		form.setId(user.getId());
		form.setUsername(user.getUsername());
		form.setPassword(user.getPassword());
		form.setAuthority(user.getAuthority());
		
		return form;
	}
}
