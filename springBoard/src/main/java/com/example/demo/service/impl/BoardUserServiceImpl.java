package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.BoardUser;
import com.example.demo.repository.BoardUserMapper;
import com.example.demo.service.BoardUserService;

import lombok.RequiredArgsConstructor;

//ユーザー:サービス実装クラス
@Service
@Transactional
@RequiredArgsConstructor
public class BoardUserServiceImpl implements BoardUserService {
	
	//DI
	private final BoardUserMapper mapper;
	
	@Override
	public List<BoardUser> findAllUser() {
		// TODO 自動生成されたメソッド・スタブ
		return mapper.selectUserAll();
	}

	@Override
	public BoardUser findByUserNameUser(String username) {
		// TODO 自動生成されたメソッド・スタブ
		return mapper.selectUserByUserName(username);
	}

	@Override
	public void insertUser(BoardUser user) {
		// TODO 自動生成されたメソッド・スタブ
		mapper.insertUser(user);
	}

	@Override
	public void updateUser(BoardUser user) {
		// TODO 自動生成されたメソッド・スタブ
		mapper.updateUser(user);
	}

	@Override
	public void deleteUser(Integer id) {
		// TODO 自動生成されたメソッド・スタブ
		mapper.deleteUser(id);
	}

}
