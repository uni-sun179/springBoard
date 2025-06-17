--削除
drop table if exists posts;
drop table if exists threads;
drop table if exists users;

drop type if exists role;

--権限用のENUM
create type role as ENUM('ADMIN','USER');

--usersテーブルの定義
create table users(
	--ユーザーID
	id serial primary key,
	--ユーザー名
	username varchar(50) not null unique,
	--パスワード
	password varchar(200) not null,
	--権限
	authority role not null	
);

--threadsテーブル
create table threads(
	--スレッドID
	id serial primary key,
	--スレッド名
	thread_name varchar(200) not null,
	--作成日時
	created_at timestamp without time zone
);

--postsテーブル
create table posts(
	--ポストID
	id serial primary key,
	--ポストテキスト
	post_text text not null,
	--投稿したユーザーのID
	user_id int ,
	--投稿されたスレッドのID
	thread_id int,
	--作成日時
	created_at timestamp without time zone,
	--外部キーの設定
	--foreign key(user_id) references users(id),
	foreign key(thread_id) references threads(id)
);