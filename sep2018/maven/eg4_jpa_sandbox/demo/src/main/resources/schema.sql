DROP TABLE IF EXISTS books;

CREATE TABLE books (
    id INTEGER NOT NULL AUTO_INCREMENT,
    author VARCHAR(255) NOT NULL,
    title VARCHAR(255) NOT NULL
);

CREATE TABLE item (
    id INTEGER NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE code (
    id INTEGER NOT NULL,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE question (
    id INTEGER NOT NULL AUTO_INCREMENT,
    code_id INTEGER NOT NULL,
    desc VARCHAR(255) NOT NULL,
    foreign key (code_id) references code(id)
);

CREATE TABLE answer (
    id INTEGER NOT NULL AUTO_INCREMENT,
    item_id INTEGER NOT NULL,
    question_id INTEGER NOT NULL,
    answer_txt VARCHAR(255) NOT NULL
);

CREATE TABLE value (
    id INTEGER NOT NULL AUTO_INCREMENT,
    code_id INTEGER NOT NULL,
    desc VARCHAR(255) NOT NULL,
    foreign key (code_id) references code(id)
);