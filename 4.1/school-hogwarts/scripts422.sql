CREATE TABLE people (
    person_id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    age INT NOT NULL,
    has_license BOOLEAN NOT NULL
);

CREATE TABLE cars (
    car_id SERIAL PRIMARY KEY,
    brand VARCHAR(100) NOT NULL,
    model VARCHAR(100) NOT NULL,
    price DECIMAL(10,2) NOT NULL
);

CREATE TABLE person_car (
    person_id INT,
    car_id INT,
    FOREIGN KEY (person_id) REFERENCES people (person_id),
    FOREIGN KEY (car_id) REFERENCES cars (car_id),
    PRIMARY KEY (person_id, car_id)
);