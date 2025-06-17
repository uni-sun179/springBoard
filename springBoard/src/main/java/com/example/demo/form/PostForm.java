package com.example.demo.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostForm {
		//投稿ID
		private Integer id;
		//投稿内容
		@NotBlank(message="文章が空欄です")
		@Size(min=5,max=500,message="5文字以上500文字以内にしてください")
		private String postText;
		//投稿者ID
		private Integer userId;
		//投稿したスレッドのID
		private Integer threadId;
}
