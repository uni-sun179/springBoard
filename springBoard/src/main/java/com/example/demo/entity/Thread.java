package com.example.demo.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//スレッド:エンティティ
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Thread {
	//スレッドID
	private Integer id;
	//スレッド名
	private String threadName;
	//作成日時
	private LocalDateTime createdAt;
}
