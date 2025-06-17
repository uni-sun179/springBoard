package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.entity.Thread;

//スレッド:リポジトリ
@Mapper
public interface ThreadMapper {
	
	//ページング用
	//一定の件数のスレッドを取得
	List<Thread> selectThread(@Param("limit") Integer limit,@Param("offset") Integer offset);
	
	//スレッドの個数を取得
	Integer countThread();
	
	//IDによるスレッドの取得
	Thread selectThreadById(@Param("id") Integer id);
	
	//スレッドの作成
	void insertThread(Thread thread);
	
	//スレッドの削除
	void deleteThread(@Param("id") Integer id);
}
