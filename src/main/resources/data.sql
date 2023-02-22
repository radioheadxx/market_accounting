insert into legal_entities(code, comment, email, physical_address, public_access, short_name, telephone)
values (101, 'We have four branches near the metro', 'tutryaadom@mail.ru', null, true, 'Tutryadom', '8-499-387-11-12'),
       (102, null, 'zvezdaa1@gmail.com', 'Moscow, Lesovaya, 10', false, 'Zvezda', '8-954-895-55-20'),
       (103, 'additional number - 8-499-145-98-61', 'kaaromovoleg67@yandex.ru', null, true, 'Oleg Karomov', '8-999-120-40-30'),
       (104, 'Use email to communicate', 'kitchenaaccess@mail.ru', 'Moscow, Dorozhnaya, 128', true, 'Kitch', null),
       (105, null, '89999999999a@mail.ru', null, true, 'Elka', '8-999-999-99-99');

INSERT INTO currencies(is_accounting, short_name, full_name, digital_code, letter_code, exchange_rate)
VALUES (FALSE, 'евро', 'Евро', '978', 'EUR', '60.65'),
       (FALSE, 'доллар', 'Доллар США', '840', 'USD', '61.02'),
       (FALSE, 'юань', 'Китайский юань', '156', 'CNY', '8.76'),
       (FALSE, 'фунт', 'Фунт стерлингов', '826', 'GBR', '69.84'),
       (TRUE, 'рубль', 'Российский рубль', '643', 'RUB', '1');
