CREATE TABLE IF NOT EXISTS depot_users
(
    user_id SERIAL primary key,
    username character varying(100) not null,
    password character varying(100) not null,
    email character varying(100) not null,
    phone_number character varying(100) not null,
    active_flag boolean not null
);

CREATE TABLE IF NOT EXISTS authorizations
(
    user_id integer REFERENCES depot_users(user_id),
    role_id integer not null
);
