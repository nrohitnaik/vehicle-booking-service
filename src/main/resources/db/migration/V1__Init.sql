CREATE SCHEMA IF NOT EXISTS `car_db`;

-- ************************************** "user"

CREATE TABLE `car_db`.`user`
(
    `id`        INT          NOT NULL AUTO_INCREMENT,
    `email`     VARCHAR(255) NOT NULL UNIQUE,
    `birthday`  TIMESTAMP         NULL,
    `first_name` VARCHAR(255) NOT NULL,
    `last_name`  VARCHAR(255) NOT NULL,
    PRIMARY KEY (`id`)
);

-- ************************************** "vehicle"

CREATE TABLE `car_db`.`vehicle`
(
    `id`           BINARY        NOT NULL AUTO_INCREMENT,
    `license_plate` VARCHAR(100)  NOT NULL UNIQUE,
    `vin`          VARCHAR(100),
    `model`        VARCHAR(100),
    `active`       BOOLEAN(100)  NOT NULL,
    `color`        VARCHAR(100)  NOT NULL,
    `valid_till`    TIMESTAMP NOT NULL,
    PRIMARY KEY (`id`)
);

-- ************************************** "booking"

CREATE TABLE `car_db`.`booking`
(
    `id`            INT          NOT NULL AUTO_INCREMENT,
    `user`          INT          NOT NULL,
    `vehicle`       INT          NOT NULL,
    `booking_status` VARCHAR(255) NOT NULL,
    `start_date`     TIMESTAMP     NOT NULL,
    `end_date`       TIMESTAMP     NOT NULL,
    PRIMARY KEY (`id`)
);

ALTER TABLE `car_db`.`booking`
    ADD CONSTRAINT `booking_fk0` FOREIGN KEY (`user`) REFERENCES `car_db`.`user` (`id`);

ALTER TABLE `car_db`.`booking`
    ADD CONSTRAINT `booking_fk1` FOREIGN KEY (`vehicle`) REFERENCES `car_db`.`vehicle` (`id`);

-- *************** Initial-Data ****************;



INSERT into `car_db`.`user`
values ( 1, 'xxx@gmail.com',  DATE '2011-05-16'  , 'rohit', 'naik');





