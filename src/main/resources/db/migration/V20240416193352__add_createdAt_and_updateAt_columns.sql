alter table patient add column created_at timestamp not null default now();
alter table patient add column update_at timestamp not null default now();
