create table patient (
                         id uuid not null,
                         name varchar(255) not null,
                         phone_number varchar(14) not null,
                         birth_date date not null,
                         email varchar(100) not null unique,

                         address_zip_code varchar(8),
                         address_street varchar(125),
                         address_number varchar(8),
                         address_complement varchar(125),
                         address_neighborhood varchar(125),
                         address_city_id uuid,

                         primary key (id)
);

alter table if exists patient
    add constraint fk_patient_address_city
    foreign key (address_city_id)
    references city;
