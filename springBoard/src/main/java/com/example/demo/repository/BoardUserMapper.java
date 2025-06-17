package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.entity.BoardUser;

//ユーザー:リポジトリ
@Mapper
public interface BoardUserMapper {
	
	//全ユーザー取得
	List<BoardUser> selectUserAll();
	
	//IDによるユーザー取得
	BoardUser selectUserByUserName(@Param("username") String username);
	
	//ユーザーの登録
	void insertUser(BoardUser user);
	
	//ユーザー情報の更新
	void updateUser(BoardUser user);
	
	//ユーザーの削除
	void deleteUser(@Param("id") Integer id);
}
