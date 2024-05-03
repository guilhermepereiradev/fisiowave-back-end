create table appointment (
                             time timestamp(6) with time zone,
                             id uuid not null,
                             patient_id uuid,
                             physiotherapist_id uuid,
                             primary key (id)
);

alter table if exists appointment
    add constraint fk_appointment_patient
        foreign key (patient_id)
            references patient;

alter table if exists appointment
    add constraint fk_appointment_physiotherapist
        foreign key (physiotherapist_id)
            references physiotherapist;