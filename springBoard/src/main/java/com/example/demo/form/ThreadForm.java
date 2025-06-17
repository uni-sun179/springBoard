package com.example.demo.form;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ThreadForm {
	//スレッドID
	private Integer id;
	//スレッド名
	@NotBlank(message="スレッド名は必要です")
	@Size(min = 2,max=50,message="スレッド名は2文字以上50文字以内にしてください")
	private String threadName;
	//作成日時
	private LocalDateTime createdAt;
}
