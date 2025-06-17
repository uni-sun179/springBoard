package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.BoardUser;

//ユーザー:サービス
public interface BoardUserService {
	//全ユーザー取得
	List<BoardUser> findAllUser();
	
	//IDによるユーザー取得
	BoardUser findByUserNameUser(String username);
	
	//ユーザーの登録
	void insertUser(BoardUser user);
	
	//ユーザー情報の更新
	void updateUser(BoardUser user);
	
	//ユーザーの削除
	void deleteUser(Integer id);
}
