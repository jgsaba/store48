
CREATE SCHEMA IF NOT EXISTS shoppings;

CREATE TABLE shoppings.shop (

    id bigserial primary key,
    user_identifier varchar(100) not null,
    shopping_date timestamp not null,
    total numeric not null
);

CREATE TABLE shoppings.item(

    shop_id bigserial REFERENCES shoppings.shop(id),
    product_identifier varchar(100) not null,
    price numeric not null
);