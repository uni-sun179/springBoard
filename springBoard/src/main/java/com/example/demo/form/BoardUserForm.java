package com.example.demo.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import com.example.demo.entity.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardUserForm {
	//ユーザーID
	private Integer id;
	//ユーザー名
	@NotBlank(message = "ユーザー名が空です")
	private String username;
	//パスワード
	@Size(min=8,max=20,message="パスワードは8文字以上20文字以内で設定してください")
	private String password;
	//権限
	private Role authority;
}
