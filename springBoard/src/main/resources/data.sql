--ユーザーの登録
--adminpass
insert into users (username,password,authority) 
values('admin','$2a$10$hZaLF9KIxfiixg9j9.QPSu9CQkVXnVI8XwzpNMYpDXeOGuS5sAN4.',
		   'ADMIN');

--userpass
insert into users (username,password,authority)
values('user','$2a$10$WG9IsrVoNjGMRg1z8S9gxOvAr7qFrw3cIwggssiR16y4D2IQ7m9fO',
		   'USER');

--スレッドの登録
insert into threads(thread_name, created_at) values('テスト1', current_timestamp);
insert into threads(thread_name, created_at) values('テスト2', current_timestamp);
insert into threads(thread_name, created_at) values('テスト3', current_timestamp);
insert into threads(thread_name, created_at) values('テスト4', current_timestamp);
insert into threads(thread_name, created_at) values('テスト5', current_timestamp);
insert into threads(thread_name, created_at) values('テスト6', current_timestamp);
insert into threads(thread_name, created_at) values('テスト7', current_timestamp);
insert into threads(thread_name, created_at) values('テスト8', current_timestamp);
insert into threads(thread_name, created_at) values('テスト9', current_timestamp);
insert into threads(thread_name, created_at) values('テスト10', current_timestamp);
insert into threads(thread_name, created_at) values('テスト11', current_timestamp);
insert into threads(thread_name, created_at) values('テスト12', current_timestamp);
insert into threads(thread_name, created_at) values('テスト13', current_timestamp);
insert into threads(thread_name, created_at) values('テスト14', current_timestamp);
insert into threads(thread_name, created_at) values('テスト15', current_timestamp);
insert into threads(thread_name, created_at) values('テスト16', current_timestamp);
insert into threads(thread_name, created_at) values('テスト17', current_timestamp);
insert into threads(thread_name, created_at) values('テスト18', current_timestamp);
insert into threads(thread_name, created_at) values('テスト19', current_timestamp);
insert into threads(thread_name, created_at) values('テスト20', current_timestamp);
insert into threads(thread_name, created_at) values('テスト21', current_timestamp);
insert into threads(thread_name, created_at) values('テスト22', current_timestamp);
insert into threads(thread_name, created_at) values('テスト23', current_timestamp);
insert into threads(thread_name, created_at) values('テスト24', current_timestamp);
insert into threads(thread_name, created_at) values('テスト25', current_timestamp);
insert into threads(thread_name, created_at) values('テスト26', current_timestamp);
insert into threads(thread_name, created_at) values('テスト27', current_timestamp);
insert into threads(thread_name, created_at) values('テスト28', current_timestamp);
insert into threads(thread_name, created_at) values('テスト29', current_timestamp);
insert into threads(thread_name, created_at) values('テスト30', current_timestamp);

--投稿の登録
insert into posts(post_text,user_id,thread_id,created_at) 
values('テステス',1,1,current_timestamp);

insert into posts(post_text,user_id,thread_id,created_at) 
values('テステス',1,2,current_timestamp);

insert into posts(post_text,user_id,thread_id,created_at) 
values('テステス',1,3,current_timestamp);

insert into posts(post_text,user_id,thread_id,created_at) 
values('テステス',2,1,current_timestamp);

insert into posts(post_text,user_id,thread_id,created_at) 
values('テステス',2,2,current_timestamp);

insert into posts(post_text,user_id,thread_id,created_at) 
values('テステス',2,3,current_timestamp);