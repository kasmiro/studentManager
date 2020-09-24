# create database jiaowu;
use jiaowu;

create table teacher (
    t_id        char(10)    primary key,
    t_name      nchar(20)   not null
);

create table course (
    course_id   char(10)    primary key,
    course_name nchar(20)   not null,
    t_id        char(10)    not null references teacher(t_id)
);

create table class (
    class_id    char(10)    primary key,
    class_name  nchar(20)   not null,
    t_id        char(10)    not null references teacher(t_id)
);

create table student (
    s_id        char(10)    primary key,
    s_name      nchar(20)   not null,
    major       nchar(20)   not null,
    class_id    nchar(10)   not null references class(class_id)
);

create table cs (
    course_id   char(10)    not null references class(class_id),
    s_id	    char(10)    not null references student(s_id),
    primary key(course_id, s_id)
);