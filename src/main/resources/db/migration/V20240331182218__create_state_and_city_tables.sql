create table state (
                       id uuid not null,
                       name varchar(100) not null,
                       acronym varchar(4) not null,
                       primary key (id)
);

create table city (
                      id uuid not null,
                      name varchar(100) not null,
                      state_id uuid not null,
                      primary key (id)
);

alter table if exists city
    add constraint fk_city_state
    foreign key (state_id)
    references state;