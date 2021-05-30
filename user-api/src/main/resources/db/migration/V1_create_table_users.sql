
CREATE SCHEMA IF NOT EXISTS users;

CREATE TABLE users.users (

    id bigserial primary key,
    name varchar(100) not null,
    cpf varchar(20),
    address varchar(150),
    email varchar (100),
    phone varchar (100),
    user_key varchar(255),
    registerDate timestamp not null;
);