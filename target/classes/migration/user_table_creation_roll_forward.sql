CREATE TABLE IF NOT EXISTS account
(
    id SERIAL primary key,
    first_name character varying(100) not null,
    last_name character varying(100) not null,
    username character varying(100) not null,
    password character varying(100) not null,
    email character varying(100) not null,
    phone_number character varying(100) not null,
    active_flag boolean not null
);

CREATE TABLE if not exists role
(
    id serial primary key,
    name character varying(100) not null
);

CREATE TABLE IF NOT EXISTS account_role
(
    id serial primary key,
    account_id integer REFERENCES account(id),
    role_id integer REFERENCES role(id),
);


insert into role (name) values("admin");
insert into role (name) values("user");

insert into account (first_name, last_name, username, password, email, phone_number, active_flag)
values('Steven', 'Ndaye', 'StevenNdaye', 'steven', 'stevenndaye@gmail.com', '+555192281996', true);
insert into account (first_name, last_name, username, password, email, phone_number, active_flag)
values ('Grace', 'Kibambe', 'GraceKibambe', 'grace', 'gracykib@yahoo.fr', '+277678967061', true);

insert into account_role(account_id, role_id)
values(1, 1);
insert into account_role(account_id, role_id)
values(2, 2);


