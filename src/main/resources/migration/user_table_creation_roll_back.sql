DELETE CASCADE from account WHERE id = 1;
DELETE CASCADE from account WHERE id = 2;
DELETE CASCADE from account_role where account_id = 1;
DELETE CASCADE from account_role where account_id = 2;
DELETE CASCADE from role where id = 1;
DELETE CASCADE from role where id = 2;

DROP TABLE IF EXISTS account CASCADE;
DROP TABLE IF EXISTS account_role CASCADE;
DROP TABLE IF EXISTS role CASCADE;
