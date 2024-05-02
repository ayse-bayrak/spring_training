drop table if exists employees;
--drop first, then create it again, and then after create data SQL is going to push data
-- create table EMPLOYEES(
--
--     id bigint not null,
--     name varchar(255),
--     primary key (id)
-- );
-- schema is where create the table
-- WE connected to database but i don't have table, two ways,
-- directly through SQL
-- i will have some classes and i will convert those classes to table

create table departments (
                             department varchar(100),
                             division varchar(100),
                             primary key (id)
);


create table employees (
                           employee_id INT,
                           first_name VARCHAR(50),
                           last_name VARCHAR(50),
                           email VARCHAR(50),
                           hire_date DATE,
                           gender VARCHAR(1),
                           salary INT,
                           primary key (id)
);
