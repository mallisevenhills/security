drop database if exists sample_db;
create database sample_db;

GRANT ALL ON sample_db.* TO 'malli'@'%' IDENTIFIED BY 'malli' WITH GRANT OPTION;
GRANT ALL ON sample_db.* TO 'malli'@'localhost' IDENTIFIED BY 'malli' WITH GRANT OPTION;

use sample_db;

drop table if exists  sec_user;
create table sec_user(id bigint(20) NOT NULL AUTO_INCREMENT,
                       user_name varchar(128), 
                       password varchar(128),
                       role varchar(128), 
                       status char(10) default 'ACTIVE',
                       created timestamp default '0000-00-00 00:00:00',
                       last_updated timestamp default current_timestamp on update current_timestamp,
                        PRIMARY KEY (id));
