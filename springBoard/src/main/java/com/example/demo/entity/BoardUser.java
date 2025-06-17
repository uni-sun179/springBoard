package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//ユーザー:エンティティ
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardUser {
	//ユーザーID
	private Integer id;
	//ユーザー名
	private String username;
	//パスワード
	private String password;
	//権限
	private Role authority;
}
