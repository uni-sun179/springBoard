package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.entity.Post;
import com.example.demo.entity.ViewPost;

//投稿:リポジトリ
@Mapper
public interface PostMapper {
	
	//スレッド関係なく全投稿を取得
	List<Post> selectPostAll();
	
	//特定のスレッドの投稿を取得
	List<Post> selectPostByThreadId(@Param("thread_id") Integer threadId);
	
	//ユーザー名付きで特定のスレッドの投稿を取得
	List<ViewPost> selectPostWithUsernameByThreadId
													  (@Param("thread_id") Integer threadId);
	
	//投稿の作成
	void insertPost(Post post);
	
	//投稿の削除
	void deletePost(@Param("id") Integer id);
}
