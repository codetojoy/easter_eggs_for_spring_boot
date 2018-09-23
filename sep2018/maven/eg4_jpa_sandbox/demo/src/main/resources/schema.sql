DROP TABLE IF EXISTS books;

CREATE TABLE books (
    id INTEGER NOT NULL AUTO_INCREMENT,
    author VARCHAR(255) NOT NULL,
    title VARCHAR(255) NOT NULL
);

CREATE TABLE item (
    id INTEGER NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    score INTEGER NOT NULL
);

CREATE TABLE code (
    id INTEGER NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE question (
    id INTEGER NOT NULL AUTO_INCREMENT,
    code_id INTEGER NOT NULL,
    desc VARCHAR(255) NOT NULL,
    foreign key (code_id) references code(id)
);

CREATE TABLE question_group (
    id INTEGER NOT NULL AUTO_INCREMENT,
    question_id INTEGER NOT NULL,
    prefix VARCHAR(255) NOT NULL,
    sequence INTEGER NOT NULL,
    tier INTEGER NOT NULL,
    q_activation_threshold INTEGER NOT NULL,
    has_comments BOOLEAN NOT NULL,
    is_mandatory BOOLEAN NOT NULL,
    is_mutex BOOLEAN NOT NULL,
    foreign key (question_id) references question(id)
);

CREATE TABLE answer (
    id INTEGER NOT NULL AUTO_INCREMENT,
    item_id INTEGER NOT NULL,
    question_id INTEGER NOT NULL,
    answer_text VARCHAR(255) NOT NULL,
    comments VARCHAR(255) NOT NULL,
    score INTEGER NOT NULL,
    foreign key (item_id) references item(id)
);

CREATE TABLE value (
    id INTEGER NOT NULL AUTO_INCREMENT,
    code_id INTEGER NOT NULL,
    desc VARCHAR(255) NOT NULL,
    foreign key (code_id) references code(id)
);

CREATE TABLE score (
    id INTEGER NOT NULL AUTO_INCREMENT,
    question_id INTEGER NOT NULL,
    value_id INTEGER NOT NULL,
    score_value INTEGER NOT NULL,
    foreign key (question_id) references question(id),
    foreign key (value_id) references value(id)
);
