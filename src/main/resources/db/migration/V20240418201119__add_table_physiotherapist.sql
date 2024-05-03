create table physiotherapist (
                                 id uuid not null,
                                 primary key (id)
);

alter table if exists physiotherapist
    add constraint fk_physiotherapist_user_
        foreign key (id)
            references user_;
