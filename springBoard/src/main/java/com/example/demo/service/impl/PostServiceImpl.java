package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Post;
import com.example.demo.entity.ViewPost;
import com.example.demo.repository.PostMapper;
import com.example.demo.service.PostService;

import lombok.RequiredArgsConstructor;

//投稿:サービス実装クラス
@Service
@Transactional
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

	//DI
	private final PostMapper mapper;
	@Override
	public List<Post> findAllPost() {
		// TODO 自動生成されたメソッド・スタブ
		return mapper.selectPostAll();
	}

	@Override
	public List<Post> findByThreadIdPost(Integer threadId) {
		// TODO 自動生成されたメソッド・スタブ
		return mapper.selectPostByThreadId(threadId);
	}
	
	@Override
	public List<ViewPost> findByThreadIdViewPost(Integer threadId){
		
		return mapper.selectPostWithUsernameByThreadId(threadId);
	}

	@Override
	public void insertPost(Post post) {
		// TODO 自動生成されたメソッド・スタブ
		mapper.insertPost(post);
	}

	@Override
	public void deletePost(Integer id) {
		// TODO 自動生成されたメソッド・スタブ
		mapper.deletePost(id);
	}

}
