-- Create user table
create table USER_ACCOUNT
(
USER_NAME VARCHAR(30) not null,
GENDER    VARCHAR(1) not null,
PASSWORD  VARCHAR(30) not null,
primary key (USER_NAME)
);
 
 -- Create product bid table

create table PRODUCTBID
(
PRODUCTCODE  VARCHAR(20) not null,
NAME  VARCHAR(128) not null,
PRICE FLOAT not null,
MAILID VARCHAR(50),
PHONENUMBER VARCHAR(15),
POSTALADDRESS VARCHAR(250),
primary key (NAME)
) ;

-- Create product table

create table PRODUCT
(
CODE  VARCHAR(20) not null,
NAME  VARCHAR(128) not null,
PRICE FLOAT not null,
BIDDERNAME  VARCHAR(128),
primary key (CODE)
) ;

-- Insert test data: ---------------------------------------------------------------
 
insert into user_account (USER_NAME, GENDER, PASSWORD)
values ('chandrakala', 'F', '12345');

commit;
