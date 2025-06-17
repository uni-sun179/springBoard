package com.example.demo.helper;

import com.example.demo.entity.Thread;
import com.example.demo.form.ThreadForm;

public class ThreadHelper {
	
	//フォームからエンティティへ
	public static Thread convertThread(ThreadForm form) {
		Thread thread = new Thread();
		thread.setId(form.getId());
		thread.setThreadName(form.getThreadName());
		thread.setCreatedAt(form.getCreatedAt());
		
		return thread;
	}
	
	//エンティティからフォームへ
	public static ThreadForm convertThreadForm(Thread thread) {
		ThreadForm form = new ThreadForm();
		form.setId(thread.getId());
		form.setThreadName(thread.getThreadName());
		form.setCreatedAt(thread.getCreatedAt());
		
		return form;
	}
}
