create table user_ (
                       id uuid not null,
                       email varchar(100) not null unique,
                       name varchar(255) not null,
                       password varchar(255) not null default '',
                       primary key (id)
);

insert into user_ (id, email, name) select id, email, name from patient;

alter table patient drop column email;
alter table patient drop column name;

alter table if exists patient
    add constraint fk_patient_user_
        foreign key (id)
            references user_;
