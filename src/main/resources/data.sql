create table Brands(
	brand_id int primary key,
	brand_name varchar not null
);

create table Products(
	product_id int primary key,
	product_name varchar not null
);

create table Prices(
	brand_id int,
	start_date timestamp,
	end_date timestamp,
	price_list int,
	product_id int,
	priority int,
	price numeric(2),
	curr varchar not null,
	foreign key (brand_id) references Brands(brand_id),
	foreign key (product_id) references Products(product_id)
);

insert into Brands(brand_id, brand_name) values (1, 'ZARA');
insert into Products(product_id, product_name) values (35455, 'Producto 35455');
insert into Prices(brand_id, start_date, end_date, price_list, product_id, priority, price, curr) values
(1, '2020-06-14 00:00+00'::timestamp, '2020-12-31 23:59+00'::timestamp, 1, 35455, 0, 35.50, 'EUR'),
(1, '2020-06-14 15:00+00'::timestamp, '2020-06-14 18:30+00'::timestamp, 2, 35455, 1, 25.45, 'EUR'),
(1, '2020-06-15 00:00+00'::timestamp, '2020-06-15 11:00+00'::timestamp, 3, 35455, 1, 30.50, 'EUR'),
(1, '2020-06-15 16:00+00'::timestamp, '2020-12-31 23:59+00'::timestamp, 4, 35455, 1, 38.95, 'EUR');
