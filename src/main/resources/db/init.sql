DO
$$
    BEGIN

        CREATE TYPE user_roles AS ENUM ('client', 'employee.sql', 'admin');
        CREATE TYPE order_state AS ENUM ('created', 'accepted', 'started', 'finished', 'closed', 'failed');

        CREATE CAST (varchar AS user_roles) WITH INOUT AS IMPLICIT;
        CREATE CAST (varchar AS order_state) WITH INOUT AS IMPLICIT;
    EXCEPTION

        WHEN duplicate_object THEN null;
    END
$$;

CREATE TABLE IF NOT EXISTS users
(
    id SERIAL NOT NULL PRIMARY KEY,
    role user_roles,
    name VARCHAR,
    surname VARCHAR,
    email VARCHAR,
    phone VARCHAR,
    password VARCHAR,
    blocked BOOLEAN
);

CREATE TABLE IF NOT EXISTS car_brands
(
    id
        SERIAL
        NOT
            NULL
        PRIMARY
            KEY,
    name
        VARCHAR
);
CREATE TABLE IF NOT EXISTS car_models
(
    id
        SERIAL
        NOT
            NULL
        PRIMARY
            KEY,
    name
        VARCHAR,
    brand_id
        INTEGER
        NOT
            NULL
        CONSTRAINT
            model_brand_fk
            REFERENCES
                car_brands
);

CREATE TABLE IF NOT EXISTS cars
(
    id
        SERIAL
        NOT
            NULL
        PRIMARY
            KEY,
    vin
        VARCHAR,
    model_id
        INTEGER
        NOT
            NULL
        CONSTRAINT
            car_car_model_fk
            REFERENCES
                car_models,
    owner_id
        INTEGER
        NOT
            NULL
        CONSTRAINT
            car_owner_fk
            REFERENCES
                users,
    manufacture_year
        INTEGER
);

CREATE TABLE IF NOT EXISTS services
(
    id
        SERIAL
        NOT
            NULL
        PRIMARY
            KEY,
    name
        VARCHAR,
    duration_days
        INTEGER,
    car_model_id
        INTEGER
        NOT
            NULL
        CONSTRAINT
            service_car_model_fk
            REFERENCES
                car_models,
    price
        INTEGER
);

CREATE TABLE IF NOT EXISTS orders
(
    id
        SERIAL
        NOT
            NULL
        PRIMARY
            KEY,
    client_id
        INTEGER
        NOT
            NULL
        CONSTRAINT
            order_client_fk
            REFERENCES
                users,
    car_id
        INTEGER
        NOT
            NULL
        CONSTRAINT
            order_car_fk
            REFERENCES
                cars,
    state
        order_state,
    creation_date
        DATE,
    finished_date
        DATE
);

CREATE TABLE IF NOT EXISTS orders_services
(
    id
        SERIAL
        NOT
            NULL
        PRIMARY
            KEY,
    service_id
        INTEGER
        NOT
            NULL
        CONSTRAINT
            orders_services_service_fk
            REFERENCES
                services,
    order_id
        INTEGER
        NOT
            NULL
        CONSTRAINT
            orders_services_order_fk
            REFERENCES
                orders
)