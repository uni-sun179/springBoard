package com.example.demo.helper;

import com.example.demo.entity.Post;
import com.example.demo.form.PostForm;

public class PostHelper {
	
	public static Post convertPost(PostForm form) {
		Post post = new Post();
		post.setId(form.getId());
		post.setPostText(form.getPostText());
		post.setUserId(form.getUserId());
		post.setThreadId(form.getThreadId());
		return post;
	}
	
	public static PostForm convertPostForm(Post post) {
		PostForm form = new PostForm();
		form.setId(post.getId());
		form.setPostText(post.getPostText());
		form.setUserId(post.getUserId());
		form.setThreadId(post.getThreadId());
		return form;
	}
}
