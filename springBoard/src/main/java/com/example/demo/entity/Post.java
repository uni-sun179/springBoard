package com.example.demo.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//投稿:エンティティ
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
	//投稿ID
	private Integer id;
	//投稿内容
	private String postText;
	//投稿者ID
	private Integer userId;
	
	//投稿したスレッドのID
	private Integer threadId;
	//作成日時
	private LocalDateTime createdAt;
	
	//投稿とユーザーの一対一関係
	//private BoardUser boardUser;
	
	//投稿とスレッドの一対一関係
	//private Thread thread;
}
