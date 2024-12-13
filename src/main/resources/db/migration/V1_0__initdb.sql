CREATE TABLE sports_inventory
(
    id integer generated always as identity,
    name    VARCHAR(50)  NOT NULL,
    parameters     VARCHAR(300),
    age   VARCHAR(100),
    storage_conditions        VARCHAR(200),
    CONSTRAINT id_pk PRIMARY KEY (id)
);