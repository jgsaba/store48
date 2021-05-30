
CREATE SCHEMA IF NOT EXISTS products;

CREATE TABLE products.categories(

    id bigserial primary key,
    name varchar(100)
);

CREATE TABLE products.products(

    id bigserial primary key,
    product_identifier varchar(100) not null,
    name varchar(100),
    price numeric not null,
    category_id bigint REFERENCES products.categories(id)
);