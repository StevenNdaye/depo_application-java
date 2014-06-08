CREATE TABLE IF NOT EXISTS depot_users
(
    user_id SERIAL primary key,
    first_name character varying(100) not null,
    last_name character varying(100) not null,
    username character varying(100) not null,
    password character varying(100) not null,
    email character varying(100) not null,
    phone_number character varying(100) not null,
    active_flag boolean not null
);

CREATE TABLE IF NOT EXISTS authorizations
(
    user_id integer REFERENCES depot_users(user_id),
    role_id integer not null,
    role character varying(100)
);

MERGE INTO depot_users
    USING (VALUES ('Steven', 'Ndaye', 'StevenNdaye', 'Heloise@87', 'stevenndaye@gmail.com', '+555192281996', true))
            AS newValues (first_name, last_name, username, password, email, phone_number, active_flag)
            ON depot_users.username = newValues.username
    WHEN NOT MATCHED THEN INSERT (first_name, last_name, username, password, email, phone_number, active_flag)
                          VALUES (newValues.first_name, newValues.last_name, newValues.username, newValues.password, newValues.email,
                          newValues.phone_number, newValues.active_flag);

MERGE INTO authorizations
        USING (VALUES (1, 1, 'admin'))
        AS newValues (user_id, role_id, role)
        ON authorizations.user_id = newValues.user_id
        WHEN NOT MATCHED THEN INSERT (user_id, role_id, role)
                                VALUES (newValues.user_id, newValues.role_id, newValues.role)

MERGE INTO depot_users
    USING (VALUES ('Grace', 'Kibambe', 'GraceKibambe', 'grace', 'gracykib@yahoo.fr', '+27767897061', true))
            AS newValues (first_name, last_name, username, password, email, phone_number, active_flag)
            ON depot_users.username = newValues.username
    WHEN NOT MATCHED THEN INSERT (first_name, last_name, username, password, email, phone_number, active_flag)
                          VALUES (newValues.first_name, newValues.last_name, newValues.username, newValues.password, newValues.email,
                          newValues.phone_number, newValues.active_flag);

MERGE INTO authorizations
        USING (VALUES (2, 2, 'user'))
        AS newValues (user_id, role_id, role)
        ON authorizations.user_id = newValues.user_id
        WHEN NOT MATCHED THEN INSERT (user_id, role_id, role)
                                VALUES (newValues.user_id, newValues.role_id, newValues.role)

