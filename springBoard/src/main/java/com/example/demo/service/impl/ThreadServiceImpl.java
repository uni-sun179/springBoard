package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Thread;
import com.example.demo.repository.ThreadMapper;
import com.example.demo.service.ThreadService;

import lombok.RequiredArgsConstructor;

//スレッド:サービス実装クラス
@Service
@Transactional
@RequiredArgsConstructor
public class ThreadServiceImpl implements ThreadService {
	
	//DI
	private final ThreadMapper mapper; 
	
	//一度に取得するスレッドは10件で固定
	final int size = 10;
	
	@Override
	public List<Thread> findThread(Integer page) {
		// TODO 自動生成されたメソッド・スタブ
		int offset = page * size;
		return mapper.selectThread(size,offset);
	}

	@Override
	public Integer countThread() {
		// TODO 自動生成されたメソッド・スタブ
		return mapper.countThread();
	}
	
	public Integer getTotalPage() {
		int threadCount = mapper.countThread();
		int totalPage = (int) Math.ceil(threadCount / size);
		return  totalPage;
	}
	
	public Thread findByIdThread(Integer id) {
		return mapper.selectThreadById(id);
	};

	@Override
	public void insertThread(Thread thread) {
		// TODO 自動生成されたメソッド・スタブ
		mapper.insertThread(thread);
	}

	@Override
	public void deleteThread(Integer id) {
		// TODO 自動生成されたメソッド・スタブ
		mapper.deleteThread(id);
	}

}