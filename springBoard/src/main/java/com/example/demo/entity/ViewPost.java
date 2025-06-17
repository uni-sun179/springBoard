package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ViewPost{
	//投稿のID
	private Integer id;
	//投稿内容
	private String postText;
	//投稿者の名前
	private String username;
}
