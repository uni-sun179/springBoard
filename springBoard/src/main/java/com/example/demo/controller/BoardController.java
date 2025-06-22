package com.example.demo.controller;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.BoardUser;
import com.example.demo.entity.LoginUser;
import com.example.demo.entity.Post;
import com.example.demo.entity.Role;
import com.example.demo.entity.Thread;
import com.example.demo.entity.ViewPost;
import com.example.demo.form.BoardUserForm;
import com.example.demo.form.PostForm;
import com.example.demo.form.ThreadForm;
import com.example.demo.helper.BoardUserHelper;
import com.example.demo.helper.PostHelper;
import com.example.demo.helper.ThreadHelper;
import com.example.demo.service.BoardUserService;
import com.example.demo.service.PostService;
import com.example.demo.service.ThreadService;
import com.example.demo.utility.PasswordGenerator;

import lombok.RequiredArgsConstructor;

//掲示板:コントローラー
@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
	
	//DI
	private final PostService postService;
	private final ThreadService threadService;
	private final BoardUserService boardUserService;
	
	private PasswordGenerator gen = new PasswordGenerator();
	
	//最初のページへリダイレクト
	@GetMapping({"" , "/"})
	public String redirectToFirstPage() {
		return "redirect:/board/1";
	}
	
	//スレッド一覧
	@GetMapping("/{page}")
	public String threadList(@PathVariable Integer page,Model model) {
		if( page <= 0) {
			return "redirect:/board/1";
		}
		//現在のページ数に応じてスレッドを10件取得
		List<Thread> threads = threadService.findThread(page - 1);
		int totalPages= threadService.getTotalPage();
		
		model.addAttribute("threads",threads);
		model.addAttribute("currentPage",page);
		model.addAttribute("totalPages",totalPages);
		
		return "board/thread-list";
	}
	
	//スレッドの中身
	@GetMapping("/thread/{id}")
	public String showThread(@PathVariable Integer id,Model model) {
		List<ViewPost> posts = postService.findByThreadIdViewPost(id);
		Thread thread = threadService.findByIdThread(id);
		
		model.addAttribute("thread", thread);
		model.addAttribute("posts", posts);
		
		return "board/thread";
	}
	
	//投稿作成フォーム
	@GetMapping("/create_post/{threadId}")
	public String createPost(@PathVariable Integer threadId,@ModelAttribute PostForm form,
			RedirectAttributes attributes,Model model) {
		
		//存在しないスレッドを指定した場合は一覧にリダイレクト
		if(threadService.findByIdThread(threadId) == null) {
			attributes.addFlashAttribute("message","お探しのスレッドは存在しないようです");
			return "redirect:/board/1";
		}
		
		model.addAttribute("threadId", threadId);
		form.setThreadId(threadId);
		return  "board/create-post";
	}
	
	//作成した投稿をデータベースに保存
	@PostMapping("/save_post")
	public String savePost(@Validated PostForm form,BindingResult bindingResult,
			@AuthenticationPrincipal LoginUser loginUser,RedirectAttributes attributes) {
		//バリデーションに引っかかると入力やり直し
		if(bindingResult.hasErrors()) {
			return "board/create-post";
		}
		//ユーザーIDはここでセット
		form.setUserId(loginUser.getId());
		Post post = PostHelper.convertPost(form);
		postService.insertPost(post);
		attributes.addFlashAttribute("message","投稿に成功しました。");
		
		return "redirect:/board/thread/"+form.getThreadId();
	}
	
	//ユーザー作成画面(入力画面)
	@GetMapping("/create_user")
	public String createUser(Model model,@ModelAttribute BoardUserForm form
			) {
		return "board/create-user";
	}
	
	//ユーザー作成実行
	@PostMapping("/save_user")
	public String saveUser(@Validated BoardUserForm form, BindingResult bindingResult,
			Model model,RedirectAttributes attributes) {
		
		//バリデーションチェック
		if(bindingResult.hasErrors()) {
			return "board/create-user";
		}
		
		//ユーザー名が重複する場合の処理
		if(boardUserService.findByUserNameUser(form.getUsername()) != null) {
			model.addAttribute("message","入力されたユーザー名は既に使われています");
			return "board/create-user";
		}
		
		//パスワードはハッシュ化する
		String encoded = gen.bCryptEncode(form.getPassword());
		form.setPassword(encoded);
		
		//権限は一般ユーザー
		form.setAuthority(Role.USER);
		
		//フォームクラスを変換
		BoardUser boardUser = BoardUserHelper.convertBoardUser(form);
		
		//データベース処理
		boardUserService.insertUser(boardUser);
		
		//メッセージをセットし、ログイン画面にリダイレクト
		attributes.addFlashAttribute("message","ユーザー登録に成功しました。引き続きログインしてください");
		return "redirect:/login" ;
	}
	
	//スレッド作成画面(入力画面)
	@GetMapping("/create_thread")
	public String createThread(Model model,ThreadForm form) {
		return "board/create-thread";
	}
	
	//スレッド作成実行
	@PostMapping("/save_thread")
	public String saveThread(@Validated ThreadForm form,BindingResult bindingResult,
			Model model,RedirectAttributes attributes) {
		if(bindingResult.hasErrors()) {
			return "board/create-thread";
		}
		
		Thread thread = ThreadHelper.convertThread(form);
		threadService.insertThread(thread);
		attributes.addFlashAttribute("message","スレッドを建てました");
		
		return "redirect:/board/1";
	}
}
