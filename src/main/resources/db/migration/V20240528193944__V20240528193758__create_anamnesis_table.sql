create table anamnesis (
                           id uuid not null,
                           gender smallint check (gender between 0 and 2),
                           observation varchar(1000),
                           chief_complaint varchar(255),
                           current_medications varchar(255),
                           height numeric(5, 2),
                           past_medical_history varchar(255),
                           profession varchar(255),
                           weight numeric(5, 2),
                           primary key (id)
);

alter table if exists patient add column anamnesis_id uuid unique;

alter table if exists patient
    add constraint fk_patient_anamnesis_id
        foreign key (anamnesis_id)
            references anamnesis;