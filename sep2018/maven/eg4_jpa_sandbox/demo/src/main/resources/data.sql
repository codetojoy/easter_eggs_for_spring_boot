insert into books (id,author,title) values (1, 'Michael Lewis', 'Moneyball');
insert into books (id,author,title) values (2, 'Malcolm Gladwell', 'Outliers');
insert into books (id,author,title) values (3, 'Richard Thaler', 'Misbehaving');

insert into item (id,name) values (5150, 'Randy Rhoads');

-- code / values

insert into code (id,name) values (777,'CODE_777');
insert into code (id,name) values (888,'CODE_888');
insert into code (id,name) values (999,'CODE_999');

insert into value (id,code_id,desc) values (700,777,'Yes');
insert into value (id,code_id,desc) values (701,777,'No');

insert into value (id,code_id,desc) values (800,888,'Excellent');
insert into value (id,code_id,desc) values (801,888,'Very Good');
insert into value (id,code_id,desc) values (802,888,'Fair');
insert into value (id,code_id,desc) values (803,888,'Poor');

insert into value (id,code_id,desc) values (900,999,'Often');
insert into value (id,code_id,desc) values (901,999,'Sometimes');
insert into value (id,code_id,desc) values (902,999,'Never');

-- questions

insert into question (id,code_id,desc) values (50,777,'question 1a');
insert into question (id,code_id,desc) values (60,888,'question 1b');
insert into question (id,code_id,desc) values (70,999,'question 2');
insert into question (id,code_id,desc) values (80,999,'question 3a');
insert into question (id,code_id,desc) values (20,777,'question 3b');

-- answers

insert into answer (id,item_id,question_id,answer_text) values (1,5150,50,'Yes');
insert into answer (id,item_id,question_id,answer_text) values (2,5150,60,'Excellent');
insert into answer (id,item_id,question_id,answer_text) values (3,5150,70,'Often');
insert into answer (id,item_id,question_id,answer_text) values (4,5150,80,'Never');
insert into answer (id,item_id,question_id,answer_text) values (5,5150,20,'No');
