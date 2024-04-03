set session_replication_role = 'replica';

delete from city;
delete from patient;
delete from state;

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
                                           ('293f9d45-8ed8-45d7-92d3-ffbdd68aef8b', 'Minas Gerais', 'MG'),
                                           ('54ed1970-935f-4cbb-bd6c-8fbc2a7e8f9e', 'Pará', 'PA'),
                                           ('37d43642-287b-42b5-84ec-2638d293a167', 'Paraíba', 'PB'),
                                           ('1dcf1699-61d2-4765-b747-2410d1a5001d', 'Paraná', 'PR'),
                                           ('51d5f837-2d17-4601-9e77-015f79375b7e', 'Pernambuco', 'PE'),
                                           ('e7e33f71-d144-44e3-8e94-28fc9711410f', 'Piauí', 'PI'),
                                           ('e2ee7d29-7471-4bc3-a9cc-0faa99b159b0', 'Rio de Janeiro', 'RJ'),
                                           ('17a72b94-6e5e-46a7-9a10-ae9c8f9d7fc6', 'Rio Grande do Norte', 'RN'),
                                           ('80b5ef82-dff3-4219-94fb-11d3cf0dbd36', 'Rio Grande do Sul', 'RS'),
                                           ('aebd4f10-f56b-4e7a-b5f7-5a3e54e99b1e', 'Rondônia', 'RO'),
                                           ('2b91c93c-3cb8-462f-86cf-4cb1a23d3e77', 'Roraima', 'RR'),
                                           ('6b83b637-2f71-4b5b-b76d-63c7f91eb0f4', 'Santa Catarina', 'SC'),
                                           ('5eeb04f1-2c3c-4b62-99d1-8d03150d4d5f', 'São Paulo', 'SP'),
                                           ('c9c11cf0-c02c-40e5-85d1-77b485efc7d7', 'Sergipe', 'SE'),
                                           ('d9f13550-6e47-4b09-b15d-13a71809d639', 'Tocantins', 'TO');

insert into city (id, name, state_id) values ('2b51c96e-6a54-497f-9cf3-1e68b0cd7314', 'Sete Lagoas', '293f9d45-8ed8-45d7-92d3-ffbdd68aef8b');
insert into city (id, name, state_id) values ('1fdb652b-c20e-45c6-9ec1-bf91eb87635f', 'Belo Horizonte', '293f9d45-8ed8-45d7-92d3-ffbdd68aef8b');
