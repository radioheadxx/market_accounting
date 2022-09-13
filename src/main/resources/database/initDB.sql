CREATE TABLE IF NOT EXISTS currencies
(
    id BIGSERIAL PRIMARY KEY ,
    is_accounting BOOLEAN,
    short_name VARCHAR(15) NOT NULL ,
    full_name VARCHAR(45) NOT NULL ,
    digital_code VARCHAR(4) NOT NULL,
    letter_code VARCHAR(4) NOT NULL,
    exchange_rate VARCHAR(15) NOT NULL
);