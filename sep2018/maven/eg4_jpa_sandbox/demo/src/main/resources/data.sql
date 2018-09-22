insert into books (id,author,title) values (1, 'Michael Lewis', 'Moneyball');
insert into books (id,author,title) values (2, 'Malcolm Gladwell', 'Outliers');
insert into books (id,author,title) values (3, 'Richard Thaler', 'Misbehaving');

insert into item (id,name) values (5150, 'Randy Rhoads');

insert into code (id,name) values (777,'CODE_777');
insert into code (id,name) values (888,'CODE_888');
insert into code (id,name) values (999,'CODE_999');

insert into question (id,code_id,desc) values (50,777,'question 1a');
insert into question (id,code_id,desc) values (60,888,'question 1b');
insert into question (id,code_id,desc) values (70,999,'question 2');
insert into question (id,code_id,desc) values (80,999,'question 3a');
insert into question (id,code_id,desc) values (20,777,'question 3b');

insert into value (id,code_id,desc) values (700,777,'Yes');
insert into value (id,code_id,desc) values (701,777,'No');

insert into value (id,code_id,desc) values (800,888,'Excellent');
insert into value (id,code_id,desc) values (801,888,'Very Good');
insert into value (id,code_id,desc) values (801,888,'Fair');
insert into value (id,code_id,desc) values (801,888,'Poor');

insert into value (id,code_id,desc) values (900,999,'Often');
insert into value (id,code_id,desc) values (901,999,'Sometimes');
insert into value (id,code_id,desc) values (901,999,'Never');
