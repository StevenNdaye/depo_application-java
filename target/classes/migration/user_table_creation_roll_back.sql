DELETE CASCADE from depot_users WHERE user_id = 1;
DELETE CASCADE from depot_users WHERE user_id = 2;
DROP TABLE IF EXISTS authorizations CASCADE;
DROP TABLE IF EXISTS depot_users CASCADE;
