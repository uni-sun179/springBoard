package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Thread;

//スレッド:サービス
public interface ThreadService {
	
	//一定数のスレッドを取得
	List<Thread> findThread(Integer page);
	
	//スレッドの個数を取得
	Integer countThread();
	
	//必要なページ数を取得
	Integer getTotalPage();
	
	//IDによるスレッドの取得
	Thread findByIdThread(Integer id);
	
	//スレッドの新規作成
	void insertThread(Thread thread);
	
	//スレッドの削除
	void deleteThread(Integer id);
}
