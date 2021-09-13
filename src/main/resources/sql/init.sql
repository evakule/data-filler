create table orders
(
    id          serial primary key,
    order_type  text default 'delivery',
    good_id     int4 default 0,
    price_id    int4 default 0,
    store_id    int4 default 0,
    supplier_id int4 default 0,
    employee_id int4 default 0
)

create table goods
(
    id        serial primary key,
    title     text           default 'some-good',
    weight    numeric(20, 8) default 0,
    freshness text           default 'fresh',
    is_food   text           default 'non-good',
    price_id  int4           default 0
)

create table prices
(
    id       serial primary key,
    value    numeric(20, 8) default 0,
    currency text           default 'UAH'
)

create table stores
(
    id                  serial primary key,
    title               text           default 'some-store',
    square_meters       numeric(20, 8) default 0,
    client_places_count int4           default 0,
    employees_count     int4           default 0
)

create table suppliers
(
    id      serial primary key,
    title   text default 'some-supplier',
    address text default 'some-address',
    type    text default 'some-supplier-type'
)

create table employees
(
    id          serial primary key,
    first_name  text default 'some_first_name',
    last_name   text default 'some_last_name',
    store_id    int4 default 0,
    position_id int4 default 0,
    salary_id   int4 default 0
)

create table positions
(
    id    serial primary key,
    title text default 'some-position'
)

create table salaries
(
    id       serial primary key,
    value    numeric(20, 8) default 0,
    currency text           default 'UAH'
)
