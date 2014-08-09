create table if not exists feedback
(
  id SERIAL primary key ,
  full_name character varying (100) not null ,
  email character varying (100) not null ,
  comments character varying (4000) not null ,
  date_created timestamp
);