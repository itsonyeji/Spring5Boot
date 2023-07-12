-- member
create table member2 (
    mno         int             auto_increment,
    userid      varchar(18)     unique,
    passwd      varchar(18)     not null,
    name        varchar(10)     not null,
    email       varchar(50)     unique,
    zipcode     char(7)         not null,
    addr1       varchar(100)    not null,
    addr2       varchar(100)    not null,
    phone       char(35)        not null,
    regdate     datetime        default current_timestamp,
    primary key (mno)
);

insert into member2
(userid, passwd, name, email, zipcode, addr1, addr2, phone)
values ('abc123','987xyz','ityeji','ityeji@abc123.co.kr','123-456','서울시 관악구','남부순환로','010-1234-5678');

select * from member2;

-- board
create table board2 (
    bno         int             auto_increment,
    title       varchar(100)    not null,
    userid      varchar(18)     not null,
    regdate     datetime        default  current_timestamp,
    thumbs      int             default 0,
    views       int             default 0,
    contents    text            not null,
    ipaddr      varchar(15)     not null,
    primary key (bno)/*,
    foreign key (userid) references member2(userid)*/
);

alter table board2
add constraint fkuid
foreign key (userid) references member2 (userid);
-- 제약조건을 따로 작성해야 여러 테이블에 대한 관계를 설정이 편리하다.

insert into board2
(title, userid, contents, ipaddr)
values ('카톡 이모티콘 신작, 인기투표 1위는 찹쌀떡 닮은 무뇽이', 'abc123', '찹쌀떡 같이 하얗고 말랑말랑한 ‘무뇽이’가 카카오톡 이용자들이 직접 뽑은 ‘2023년 이모티콘 라이징 스타’로 선정됐다.', '56.86.214.59');
insert into board2
(title, userid, contents, ipaddr)
values ('오픈소스 AI가 구글을 앞설 것이라고 생각하지 않는다.', 'ityeji', '구글이 마이크로소프트와의 경쟁에 몰두하는 사이 오픈소스 기술에 우위를 넘겨주게 될 것이라는 내부 메모는 실제 있었던 것으로 안다. 그러나 나는 오픈소스 AI가 구글을 앞설 것이라고 생각하지 않는다.', '116.246.54.206');
insert into board2
(title, userid, contents, ipaddr)
values ('트랜스포머 로봇 등장...도로 달리다 변신해 비행 가능', '987xyz', '지진이나 홍수 등 다양한 자연재해 속에서 M4는 다재다능함을 활용해 수색 및 구조 임무에 맞는 이동성을 달성할 수 있다', '203.143.118.9');

-- 외래키로 설정한 값은 레퍼런스한 테이블에 있는 값을 이용해야한다.
select count(userid) cnt, ceil(count(userid)/25) pages from board2;