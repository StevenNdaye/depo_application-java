CREATE TABLE IF NOT EXISTS account
(
    account_id SERIAL primary key,
    first_name character varying(100) not null,
    last_name character varying(100) not null,
    accountname character varying(100) not null,
    password character varying(100) not null,
    email character varying(100) not null,
    phone_number character varying(100) not null,
    active_flag boolean not null
);

CREATE TABLE IF NOT EXISTS role
(
    account_id integer REFERENCES account(account_id),
    role_id integer not null,
    role character varying(100)
);

MERGE INTO account
    USING (VALUES ('Steven', 'Ndaye', 'StevenNdaye', 'Heloise@87', 'stevenndaye@gmail.com', '+555192281996', true))
            AS newValues (first_name, last_name, accountname, password, email, phone_number, active_flag)
            ON account.accountname = newValues.accountname
    WHEN NOT MATCHED THEN INSERT (first_name, last_name, accountname, password, email, phone_number, active_flag)
                          VALUES (newValues.first_name, newValues.last_name, newValues.accountname, newValues.password, newValues.email,
                          newValues.phone_number, newValues.active_flag);

MERGE INTO role
        USING (VALUES (1, 1, 'admin'))
        AS newValues (account_id, role_id, role)
        ON role.account_id = newValues.account_id
        WHEN NOT MATCHED THEN INSERT (account_id, role_id, role)
                                VALUES (newValues.account_id, newValues.role_id, newValues.role)

MERGE INTO account
    USING (VALUES ('Grace', 'Kibambe', 'GraceKibambe', 'grace', 'gracykib@yahoo.fr', '+27767897061', true))
            AS newValues (first_name, last_name, accountname, password, email, phone_number, active_flag)
            ON account.accountname = newValues.accountname
    WHEN NOT MATCHED THEN INSERT (first_name, last_name, accountname, password, email, phone_number, active_flag)
                          VALUES (newValues.first_name, newValues.last_name, newValues.accountname, newValues.password, newValues.email,
                          newValues.phone_number, newValues.active_flag);

MERGE INTO role
        USING (VALUES (2, 2, 'account'))
        AS newValues (account_id, role_id, role)
        ON role.account_id = newValues.account_id
        WHEN NOT MATCHED THEN INSERT (account_id, role_id, role)
                                VALUES (newValues.account_id, newValues.role_id, newValues.role)

