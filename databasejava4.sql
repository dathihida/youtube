use master 
go 

 create database asmJava4
 go 
 use asmJava4

 go

 create table userid(
	id int primary key identity,
	username varchar(10) unique not null,
	[password] varchar(10) not null,
	email varchar(50) unique not null,
	isAdmin bit not null default 0,
	isActive bit not null default 1,
 )

 go

 create table  video(
	id int primary key identity,
	title nvarchar(255) not null,
	href varchar(50) unique not null,
	poster nvarchar(255) null,
	[views] int not null default 0,
	shares int not null default 0,
	[description] nvarchar(255) not null,
	isActive bit not null default 1
 )

 go

 create table history(
	id int primary key identity,
	userId int foreign key references [userid](id),
	videoId int foreign key references video(id),
	viewDate datetime not null default getDate(),
	isLiked bit not null default 0,
	likedDate datetime null,
 )
 go
 insert into [userid] (username, [password], email, isAdmin) values
 ('admin', '111', 'tiendat060709@gmail.com', 1),
 ('user', '222', 'datphung1908@gmail.com', 0)
 go
 insert into video(title, href, [description] ) values
(N'Hài Sóng Tổng Hợp: Hoài Linh, Trấn Thành, Trường Giang, Lê Dương Bảo Lâm, Mạc Văn Khoa, Lâm Vỹ Dạ', 'UmuuKOTzK5k&ab_channel=VieChannel-HTV2', N'Hoài Linh, Trấn Thành, Trường Giang, Lê Dương Bảo Lâm, Mạc Văn Khoa, Lâm Vỹ Dạ'),
(N'GIẤU NGHỀ DÙNG KĨ NĂNG SSS TRIỆU HOÁN THÚ ĐỒ SÁT MA VỰC P1 (CHAP 1-33) | REVIEW TRUYỆN TRANH ANIME', '_S5I073x1LQ&t=1287s&ab_channel=SắnReview', N'REVIEW TRUYỆN TRANH ANIME'),
(N'Phần 1 - Thế giới thực hoà vào game, ta có max điểm kỹ năng - Manhua thuyết minh', '2kViFuKYGD4&ab_channel=BảoKaManhuaReview', N'Manhua thuyết minh')
go
insert into history(userId, videoId, isLiked, likedDate) values
(2, 1, 1, GETDATE()),
(2, 3, 0, null)
go


select *from userid
select *from video
select *from history

update video set href='UmuuKOTzK5k' where id= 1;
update video set href='_S5I073x1LQ' where id= 2;
update video set href='2kViFuKYGD4' where id= 3;
update video set poster = 'https://img.youtube.com/vi/UmuuKOTzK5k/maxresdefault.jpg' where id=3

delete history where id =4;
delete history where id =5;
delete history where id = 6;
delete history where id = 7;
delete history where id = 8;
update history set isLiked= 0, likedDate = null where id= 2;

insert into video(title, href, [description] ) values
(N'Những trò "hack" nghịch hay ho bá đạo mà bạn có thể làm với Chrome Developer Tools', 'aqzOvND-5sw', N'Những trò "hack" nghịch hay ho bá đạo mà bạn có thể làm với Chrome Developer Tools'),
(N'Code Cùng Code Dạo - Tự Học JavaScript Cơ Bản trong 15 phút', 'ZIgDYEZl1VE', N'Code Cùng Code Dạo'),
(N'DARIUS CỦA XIAOCHAOMENG KHIẾN GANGPLANK RƠI VÀO TRẦM TƯ VÌ OUT TRÌNH', 'uxAxOO7aQVY', N'DARIUS CỦA XIAOCHAOMENG'),
(N'Tổng Hợp - Thanh Niên Tốt Bụng Xuyên Không Thành Ma Đạo Tổ Sư | Review Truyện Tranh', 'z9tgWWYZlfY', N'Review Truyện Tranh'),
(N'TỔNG HỢP TIÊN VÕ ĐẾ TÔN | CHAP 1- 109 | REVIEW TRUYỆN TRANH HAY | TÓM TẮT TRUYỆN TRANH HAY', 'urzj7NuSiR4', N'TÓM TẮT TRUYỆN TRANH HAY'),
(N'TỔNG HỢP TIÊN VÕ ĐẾ TÔN | CHAP 110- 193 | REVIEW TRUYỆN TRANH HAY | TÓM TẮT TRUYỆN TRANH HAY', 'DCI_cdT8_Ac', N'TÓM TẮT TRUYỆN TRANH HAY'),
(N'TỔNG HỢP TIÊN VÕ ĐẾ TÔN | CHAP 194- 237 | REVIEW TRUYỆN TRANH HAY | TÓM TẮT TRUYỆN TRANH HAY', 'y82-yNH4OeI', N'TÓM TẮT TRUYỆN TRANH HAY');


SELECT * FROM Video o WHERE o.href = '_S5I073x1LQ'

select * from History o where o.userId = 1 and o.isLiked = 1 and o.isActive = 1 ORDER BY o.viewDate DESC


select v.id, v.title, v.href, sum(CAST(h.isLiked as int)) as totalLike from video v left join history h on v.id = h.videoId where v.isActive=1 group by v.id, v.title, v.href order by sum(CAST(h.isLiked as int)) desc;

create proc sp_selectUsersLikedVideoByVideoHref(@videoHref varchar(50))
as begin
select 
	u.id,u.username, u.email, u.[password], u.isActive, u.isAdmin
	from userid u inner join history h on u.id = h.userId
				inner join video v on h.videoId = v.id
	where v.href = @videoHref and u.isActive = 1 and v.isActive = 1 and h.isLiked = 1
end

select 
	u.username, u.email
	from userid u inner join history h on u.id = h.userId
				inner join video v on h.videoId = v.id
	where v.href='_S5I073x1LQ' and u.isActive = 1 and v.isActive = 1 and h.isLiked = 1


insert into [userid] (username, [password], email, isAdmin) values
 ('', '', '', 1)

 select *from video where title= N'Những trò "hack" nghịch hay ho bá đạo mà bạn có thể làm với Chrome Developer Tools';