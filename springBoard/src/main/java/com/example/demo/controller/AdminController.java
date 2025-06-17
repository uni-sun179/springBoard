package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.BoardUser;
import com.example.demo.entity.Role;
import com.example.demo.entity.Thread;
import com.example.demo.form.BoardUserForm;
import com.example.demo.form.ThreadForm;
import com.example.demo.helper.BoardUserHelper;
import com.example.demo.helper.ThreadHelper;
import com.example.demo.service.BoardUserService;
import com.example.demo.service.PostService;
import com.example.demo.service.ThreadService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
	
	private final BoardUserService boardUserService;
	private final ThreadService threadService;
	private final PostService PostService;
	
	//管理者メニュー
	@GetMapping({"/","/menu"})
	public String showAdminMenu(Model model) {
		return "/admin/menu";
	}
	
	//ユーザー一覧
	@GetMapping("/show_users")
	public String showUsers(Model model) {
		List<BoardUser> users = boardUserService.findAllUser();
		model.addAttribute("users", users);
		return "/admin/show-users";
	}
	
	//ユーザーの削除を確認する画面
	@PostMapping("/delete_user")
	public String checkDeleteUser(@RequestParam String username,Model model,
			RedirectAttributes attributes) {
		
		BoardUser dbUser = boardUserService.findByUserNameUser(username);
		
		//管理者の削除は禁止
		if(dbUser.getAuthority() == Role.ADMIN) {
			attributes.addFlashAttribute("message","管理者を削除することはできません");
			return "redirect:/admin/show_users";
		}
		
		BoardUserForm form = BoardUserHelper.convertBoardUserForm(dbUser);
		model.addAttribute("boardUserForm",form);
		
		return "/admin/delete-user";
	}
	
	//ユーザーの削除の実行
	@PostMapping("/exe_delete_user")
	public String deleteUser(BoardUserForm form,RedirectAttributes attributes) {
		
		BoardUser dbUser = boardUserService.findByUserNameUser(form.getUsername()); 
		
		if( dbUser != null) {
			boardUserService.deleteUser(dbUser.getId());
			attributes.addFlashAttribute("message", dbUser.getUsername() + "さんを削除しました");
			return "redirect:/admin/show_users";
		}
		
		attributes.addFlashAttribute("message","ユーザーの削除に失敗しました");
		return "redirect:/admin/show_users";
	}
	
	//スレッドの削除の確認画面
	@GetMapping("/delete_thread/{threadId}")
	public String checkDeleteThread(@PathVariable Integer threadId,Model model) {
		//対象のスレッドの情報を取得
		Thread thread = threadService.findByIdThread(threadId);
		//エンティティをフォームへ
		ThreadForm form = ThreadHelper.convertThreadForm(thread);
		model.addAttribute("threadForm", form);
		
		return "/admin/delete-thread";
	}
	
	@PostMapping("/exe_delete_thread")
	public String DeleteThread(ThreadForm form,RedirectAttributes attributes){
		//対象のスレッドの情報を取得
		Thread thread = threadService.findByIdThread(form.getId());
		if( thread != null ) {
			threadService.deleteThread(thread.getId());
			attributes.addFlashAttribute(
					"message","スレッド名:"+thread.getThreadName()+"の削除に成功しました");
			return "redirect:/board/1";
		}
		
		attributes.addFlashAttribute("message", "スレッドの削除に失敗しました");
		return "redirect:/board/1";
	}
}
