package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Post;
import com.example.demo.entity.ViewPost;

//投稿:サービス
public interface PostService {
	
	//スレッド関係なく全投稿を取得
	List<Post> findAllPost();
	
	//特定のスレッドの投稿を取得
	List<Post> findByThreadIdPost(Integer threadId);
	
	//表示用の投稿を取得
	List<ViewPost> findByThreadIdViewPost(Integer threadId);
	
	//投稿の作成
	void insertPost(Post post);
	
	//投稿の削除
	void deletePost(Integer id);
}
