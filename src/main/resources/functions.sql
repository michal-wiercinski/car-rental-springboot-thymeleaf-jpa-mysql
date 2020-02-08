DROP PROCEDURE IF EXISTS get_brand_name ^;
DROP PROCEDURE IF EXISTS create_address ^;
DROP FUNCTION IF EXISTS car_distance ^;
DROP FUNCTION IF EXISTS get_daily_rate_by_rental__details_id ^;
DROP FUNCTION IF EXISTS get_status_by_rental_dt ^;
DROP TRIGGER IF EXISTS total_income ^;
DROP TRIGGER IF EXISTS add_current_time_to_rental ^;
DROP TRIGGER IF EXISTS after_update_rental_cost ^;
DROP TRIGGER IF EXISTS add_status_to_rental ^;


CREATE PROCEDURE get_brand_name(IN in_id INT(10),
                                OUT brd_name VARCHAR(20))
BEGIN
    SELECT brand_name
    INTO brd_name
    FROM brand
    where PK_brand = in_id;
END ^;

CREATE
    PROCEDURE create_address(IN p_city VARCHAR(30),
                             IN p_street VARCHAR(40),
                             IN p_house_number VARCHAR(20),
                             IN p_zip_code VARCHAR(6),
                             OUT id BIGINT)
BEGIN
    INSERT INTO address (city, street, house_number, zip_code)
    VALUES (p_city, p_street, p_house_number, p_zip_code);
END ^;

CREATE FUNCTION get_daily_rate_by_rental__details_id(p_pk_rental_details BIGINT)
    RETURNS BIGINT
    DETERMINISTIC
BEGIN
    DECLARE result INT;
    SET result = (SELECT cp.daily_rate
                  FROM car_parameter AS cp
                           JOIN car AS c
                                ON cp.PK_car_parameter = c.FK_car_parameter
                           JOIN rental r on c.PK_car = r.FK_car
                           JOIN rental_details rd on r.FK_rental_details = rd.PK_rental_details
                  WHERE rd.PK_rental_details = p_pk_rental_details);
    RETURN result;
END ^;

CREATE FUNCTION get_status_by_rental_dtl(p_pk_rd BIGINT)
    RETURNS BIGINT
    DETERMINISTIC
BEGIN
    DECLARE result BIGINT;
    SET result = (SELECT r.fk_status
                  from rental AS r
                           JOIN rental_details AS rd ON r.FK_rental_details = rd.PK_rental_details
                  WHERE PK_rental_details = p_pk_rd);
    RETURN result;

END ^;

CREATE FUNCTION car_distance(date_from TIMESTAMP)
    RETURNS INT
    DETERMINISTIC
BEGIN
    DECLARE diff INT;
    SET diff = TIMESTAMPDIFF(MINUTE, date_from, CURRENT_TIMESTAMP);
    RETURN (RAND(1) * 100) * diff;
END ^;


CREATE TRIGGER after_update_rental_cost
    AFTER UPDATE
    ON rental_details
    FOR EACH ROW
BEGIN
    DECLARE v_diff_date INT;
    DECLARE v_daily_rate INT;
    IF (get_status_by_rental_dtl(OLD.PK_rental_details) = 1)
    THEN
        SET v_diff_date = TIMESTAMPDIFF(MINUTE, OLD.date_from, NEW.date_end);
        SET v_daily_rate =
                    v_diff_date * get_daily_rate_by_rental__details_id(NEW.PK_rental_details);

        UPDATE rental_details
        SET rental_cost = v_diff_date * v_daily_rate
        WHERE PK_rental_details = NEW.PK_rental_details;
    END IF;

    /* UPDATE rental_details
     SET distance = car_distance(OLD.date_from, NEW.date_end)
     WHERE PK_rental_details = NEW.PK_rental_details;*/

END ^;

CREATE TRIGGER add_status_to_rental
    BEFORE INSERT
    ON rental
    FOR EACH ROW
BEGIN
    SET NEW.FK_status = 2;
END ^;

CREATE TRIGGER add_current_time_to_rental
    BEFORE INSERT
    ON
        rental_details
    FOR EACH ROW
BEGIN
    SET NEW.date_from = CURRENT_TIMESTAMP;
END ^;

