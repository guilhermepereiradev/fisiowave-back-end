
    create table appointment (
        time timestamp(6) with time zone,
        id uuid not null,
        patient_id uuid,
        physiotherapist_id uuid,
        primary key (id)
    );

    create table city (
        id uuid not null,
        state_id uuid not null,
        name varchar(100) not null,
        primary key (id)
    );

    create table patient (
        birth_date date not null,
        address_number varchar(8),
        address_zip_code varchar(8),
        created_at timestamp not null,
        update_at timestamp not null,
        phone_number varchar(14) not null,
        address_city_id uuid,
        id uuid not null,
        address_complement varchar(125),
        address_neighborhood varchar(125),
        address_street varchar(125),
        primary key (id)
    );

    create table physiotherapist (
        id uuid not null,
        primary key (id)
    );

    create table state (
        acronym varchar(4) not null,
        id uuid not null,
        name varchar(100) not null,
        primary key (id)
    );

    create table user_ (
        id uuid not null,
        email varchar(100) not null unique,
        name varchar(255) not null,
        password varchar(255) not null,
        primary key (id)
    );

    alter table if exists appointment 
       add constraint FK4apif2ewfyf14077ichee8g06 
       foreign key (patient_id) 
       references patient;

    alter table if exists appointment 
       add constraint FKqo3jccppys93cg7a5iim3gxm9 
       foreign key (physiotherapist_id) 
       references physiotherapist;

    alter table if exists city 
       add constraint FK6p2u50v8fg2y0js6djc6xanit 
       foreign key (state_id) 
       references state;

    alter table if exists patient 
       add constraint FKa534r18svos58eiqu79hdh4ph 
       foreign key (address_city_id) 
       references city;

    alter table if exists patient 
       add constraint FKe9jpt1s1hdwupn2lcetxu0u5b 
       foreign key (id) 
       references user_;

    alter table if exists physiotherapist 
       add constraint FKq1r3cv8898w1lswllkrkn6m4x 
       foreign key (id) 
       references user_;

    create table appointment (
        time timestamp(6) with time zone,
        id uuid not null,
        patient_id uuid,
        physiotherapist_id uuid,
        primary key (id)
    );

    create table city (
        id uuid not null,
        state_id uuid not null,
        name varchar(100) not null,
        primary key (id)
    );

    create table patient (
        birth_date date not null,
        address_number varchar(8),
        address_zip_code varchar(8),
        created_at timestamp not null,
        update_at timestamp not null,
        phone_number varchar(14) not null,
        address_city_id uuid,
        id uuid not null,
        address_complement varchar(125),
        address_neighborhood varchar(125),
        address_street varchar(125),
        primary key (id)
    );

    create table physiotherapist (
        id uuid not null,
        primary key (id)
    );

    create table state (
        acronym varchar(4) not null,
        id uuid not null,
        name varchar(100) not null,
        primary key (id)
    );

    create table user_ (
        id uuid not null,
        email varchar(100) not null unique,
        name varchar(255) not null,
        password varchar(255) not null,
        primary key (id)
    );

    alter table if exists appointment 
       add constraint FK4apif2ewfyf14077ichee8g06 
       foreign key (patient_id) 
       references patient;

    alter table if exists appointment 
       add constraint FKqo3jccppys93cg7a5iim3gxm9 
       foreign key (physiotherapist_id) 
       references physiotherapist;

    alter table if exists city 
       add constraint FK6p2u50v8fg2y0js6djc6xanit 
       foreign key (state_id) 
       references state;

    alter table if exists patient 
       add constraint FKa534r18svos58eiqu79hdh4ph 
       foreign key (address_city_id) 
       references city;

    alter table if exists patient 
       add constraint FKe9jpt1s1hdwupn2lcetxu0u5b 
       foreign key (id) 
       references user_;

    alter table if exists physiotherapist 
       add constraint FKq1r3cv8898w1lswllkrkn6m4x 
       foreign key (id) 
       references user_;

    create table appointment (
        time timestamp(6) with time zone,
        id uuid not null,
        patient_id uuid,
        physiotherapist_id uuid,
        primary key (id)
    );

    create table city (
        id uuid not null,
        state_id uuid not null,
        name varchar(100) not null,
        primary key (id)
    );

    create table patient (
        birth_date date not null,
        address_number varchar(8),
        address_zip_code varchar(8),
        created_at timestamp not null,
        update_at timestamp not null,
        phone_number varchar(14) not null,
        address_city_id uuid,
        id uuid not null,
        address_complement varchar(125),
        address_neighborhood varchar(125),
        address_street varchar(125),
        primary key (id)
    );

    create table physiotherapist (
        id uuid not null,
        primary key (id)
    );

    create table state (
        acronym varchar(4) not null,
        id uuid not null,
        name varchar(100) not null,
        primary key (id)
    );

    create table user_ (
        id uuid not null,
        email varchar(100) not null unique,
        name varchar(255) not null,
        password varchar(255) not null,
        primary key (id)
    );

    alter table if exists appointment 
       add constraint FK4apif2ewfyf14077ichee8g06 
       foreign key (patient_id) 
       references patient;

    alter table if exists appointment 
       add constraint FKqo3jccppys93cg7a5iim3gxm9 
       foreign key (physiotherapist_id) 
       references physiotherapist;

    alter table if exists city 
       add constraint FK6p2u50v8fg2y0js6djc6xanit 
       foreign key (state_id) 
       references state;

    alter table if exists patient 
       add constraint FKa534r18svos58eiqu79hdh4ph 
       foreign key (address_city_id) 
       references city;

    alter table if exists patient 
       add constraint FKe9jpt1s1hdwupn2lcetxu0u5b 
       foreign key (id) 
       references user_;

    alter table if exists physiotherapist 
       add constraint FKq1r3cv8898w1lswllkrkn6m4x 
       foreign key (id) 
       references user_;

    create table appointment (
        time timestamp(6) with time zone,
        id uuid not null,
        patient_id uuid,
        physiotherapist_id uuid,
        primary key (id)
    );

    create table city (
        id uuid not null,
        state_id uuid not null,
        name varchar(100) not null,
        primary key (id)
    );

    create table patient (
        birth_date date not null,
        address_number varchar(8),
        address_zip_code varchar(8),
        created_at timestamp not null,
        update_at timestamp not null,
        phone_number varchar(14) not null,
        address_city_id uuid,
        id uuid not null,
        address_complement varchar(125),
        address_neighborhood varchar(125),
        address_street varchar(125),
        primary key (id)
    );

    create table physiotherapist (
        id uuid not null,
        primary key (id)
    );

    create table state (
        acronym varchar(4) not null,
        id uuid not null,
        name varchar(100) not null,
        primary key (id)
    );

    create table user_ (
        id uuid not null,
        email varchar(100) not null unique,
        name varchar(255) not null,
        password varchar(255) not null,
        primary key (id)
    );

    alter table if exists appointment 
       add constraint FK4apif2ewfyf14077ichee8g06 
       foreign key (patient_id) 
       references patient;

    alter table if exists appointment 
       add constraint FKqo3jccppys93cg7a5iim3gxm9 
       foreign key (physiotherapist_id) 
       references physiotherapist;

    alter table if exists city 
       add constraint FK6p2u50v8fg2y0js6djc6xanit 
       foreign key (state_id) 
       references state;

    alter table if exists patient 
       add constraint FKa534r18svos58eiqu79hdh4ph 
       foreign key (address_city_id) 
       references city;

    alter table if exists patient 
       add constraint FKe9jpt1s1hdwupn2lcetxu0u5b 
       foreign key (id) 
       references user_;

    alter table if exists physiotherapist 
       add constraint FKq1r3cv8898w1lswllkrkn6m4x 
       foreign key (id) 
       references user_;
