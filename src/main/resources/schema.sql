create table if not exists legal_entities
(
    id bigserial primary key,
    short_name varchar(20) not null,
    code bigint,
    telephone varchar(20),
    email varchar(254) not null unique,
    physical_address varchar(254),
    comment varchar(254),
    public_access boolean not null
);