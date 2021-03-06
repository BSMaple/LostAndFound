create table found_register
(
  found_id int auto_increment
    primary key,
  found_name varchar(255) not null,
  found_place varchar(255) not null,
  found_time date not null,
  found_describe varchar(255) null,
  found_people varchar(255) null,
  found_telephone_number varchar(255) null,
  found_situation tinyint(2) default '0' not null,
  found_info_visible tinyint default '0' not null,
  found_pic varchar(255) default 'empty.jpg' null,
  had_review tinyint default '0' not null comment '审核状态 1为通过
	'
)
  comment '拾物登记表' engine=InnoDB
;



create table lost_register
(
  lost_id int auto_increment
    primary key,
  lost_name varchar(255) not null,
  lost_place varchar(255) not null,
  lost_time date not null,
  lost_describe varchar(255) not null,
  lost_people varchar(255) not null,
  lost_telephone_number varchar(255) not null,
  lost_situation tinyint(2) not null,
  lost_info_visible tinyint default '0' not null,
  lost_pic varchar(255) default 'empty.jpg' null
)
  comment '失物登记表' engine=InnoDB
;


-- auto-generated definition
CREATE TABLE admin_info
(
  id       INT AUTO_INCREMENT
    PRIMARY KEY,
  username VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL
)
  COMMENT '管理员信息表'
  ENGINE = InnoDB;


