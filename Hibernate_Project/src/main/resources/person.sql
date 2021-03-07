DROP TABLE IF EXISTS person2;

CREATE TABLE person2(
    person_id SERIAL,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    PRIMARY KEY (person_id)
);