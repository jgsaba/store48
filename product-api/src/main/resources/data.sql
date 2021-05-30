insert into products.categories (name) values ('electronics');
insert into products.categories (name) values ('furniture');
insert into products.categories (name) values ('toys');

insert into products.products (product_identifier, name, price, category_id)
    values ('TBLT', 'Tablet', 99.99, 1);

insert into products.products (product_identifier, name, price, category_id)
    values ('OFFCHR', 'Office chair', 119.99, 2);

insert into products.products (product_identifier, name, price, category_id)
    values ('ACTFIG', 'Action figure', 11.99, 3);