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

CREATE TABLE IF NOT EXISTS market.currencies
(
    id BIGSERIAL PRIMARY KEY ,
    is_accounting BOOLEAN,
    short_name VARCHAR(15) NOT NULL ,
    full_name VARCHAR(45) NOT NULL ,
    digital_code VARCHAR(4) NOT NULL,
    letter_code VARCHAR(4) NOT NULL,
    exchange_rate VARCHAR(15) NOT NULL
);