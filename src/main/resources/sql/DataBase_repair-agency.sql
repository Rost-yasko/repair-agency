DROP DATABASE repair_agency;
CREATE DATABASE repair_agency;

DROP TABLE IF EXISTS roles CASCADE;
CREATE TABLE roles(
id SERIAL PRIMARY KEY,
name varchar NOT NULL
);

DROP TABLE IF EXISTS users CASCADE;
CREATE TABLE users(
id SERIAL NOT NULL PRIMARY KEY,
first_name varchar NOT NULL,
last_name varchar NOT NULL,
email varchar NOT NULL,
phone varchar NOT NULL,
balance decimal(12,2) NOT NULL,
login varchar NOT NULL UNIQUE,
password varchar NOT NULL,
role_id integer REFERENCES roles(id)
);

DROP TABLE IF EXISTS orders CASCADE;
CREATE TABLE orders(
id SERIAL NOT NULL PRIMARY KEY,
date_of_posting TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
completion_date  timestamptz NOT NULL,
status varchar NOT NULL,
user_id integer REFERENCES users(id)
);

DROP TYPE IF EXISTS rating CASCADE;
CREATE TYPE rating AS ENUM ('1','2','3','4','5');

DROP TABLE IF EXISTS feedbacks CASCADE;
CREATE TABLE feedbacks(
id integer NOT NULL PRIMARY KEY REFERENCES orders,
feedback_data TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
text_feedback text,
rating rating NOT NULL
);

DROP TABLE IF EXISTS services CASCADE;
CREATE TABLE services(
id SERIAL NOT NULL PRIMARY KEY,
name varchar NOT NULL,
description text,
silver varchar NOT NULL,
price_silver decimal(12,2) NOT NULL,
gold varchar NOT NULL,
price_gold decimal(12,2) NOT NULL
);

DROP TABLE IF EXISTS orders_has_services CASCADE;
CREATE TABLE orders_has_services(
id SERIAL NOT NULL PRIMARY KEY,
price decimal(12,2) NOT NULL,
service_id integer REFERENCES services(id),
order_id integer REFERENCES orders(id)
);
