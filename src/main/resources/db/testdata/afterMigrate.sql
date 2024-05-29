set session_replication_role = 'replica';

delete from user_;
delete from patient;
delete from physiotherapist;
delete from city;
delete from state;
delete from appointment;
delete from anamnesis;

set session_replication_role = 'origin';

insert into state (id, name, acronym) values
                                           ('f47ac10b-58cc-4372-a567-0e02b2c3d479', 'Acre', 'AC'),
                                           ('1dd7d110-85eb-4c1e-bd42-1b3c5f5a0b3e', 'Alagoas', 'AL'),
                                           ('0e2a6e6b-d0b0-41d8-9250-62ac7a3a1f23', 'Amapá', 'AP'),
                                           ('d24a595c-4575-4a03-91de-3e8fd1f75467', 'Amazonas', 'AM'),
                                           ('a93e6c47-1834-4fb1-910c-84e74c63d4b3', 'Bahia', 'BA'),
                                           ('264d2b1b-37f2-4e54-9796-60c7d582bcb5', 'Ceará', 'CE'),
                                           ('50e09f9b-4cc5-4d6e-98d7-7583ae2f9053', 'Distrito Federal', 'DF'),
                                           ('b6282d70-57a5-4f19-8d43-ae85fd019d2f', 'Espírito Santo', 'ES'),
                                           ('68584d20-3ff5-4634-b6f9-978b13c6b265', 'Goiás', 'GO'),
                                           ('53947c7e-4e8f-4f92-b32b-88ee4c49e92f', 'Maranhão', 'MA'),
                                           ('baf41d91-51c5-41e8-b9e1-8ecb8b11d3bd', 'Mato Grosso', 'MT'),
                                           ('e12ee6a3-9b44-4717-b15d-d7a5d87f32d7', 'Mato Grosso do Sul', 'MS'),
                                           ('293f9d45-8ed8-45d7-92d3-ffbdd68aef8b', 'Minas Gerais', 'MG');

insert into city (id, name, state_id) values ('2b51c96e-6a54-497f-9cf3-1e68b0cd7314', 'Sete Lagoas', '293f9d45-8ed8-45d7-92d3-ffbdd68aef8b');
insert into city (id, name, state_id) values ('1fdb652b-c20e-45c6-9ec1-bf91eb87635f', 'Belo Horizonte', '293f9d45-8ed8-45d7-92d3-ffbdd68aef8b');

insert into user_ (id, email, name, password) values ('e12ee6a3-9b44-4717-b15d-d7a5d87f32d7', 'john.physio@email.com', 'John Physiotherapist', '$2a$10$5MEfMYgA0d.//KjAQcxxUe3NMfcrU8G2EyEfq8.72dsrctKlBb4Za');
insert into physiotherapist (id) values ('e12ee6a3-9b44-4717-b15d-d7a5d87f32d7');

insert into user_ (id, email, name, password) values ('b6282d70-57a5-4f19-8d43-ae85fd019d2f', 'john.patient@email.com', 'John Patient', '$2a$10$5MEfMYgA0d.//KjAQcxxUe3NMfcrU8G2EyEfq8.72dsrctKlBb4Za');
insert into patient (id, phone_number, birth_date) values ('b6282d70-57a5-4f19-8d43-ae85fd019d2f', '31999999999', '2000-01-01');