DROP PROCEDURE IF EXISTS get_brand_name ^;
DROP PROCEDURE IF EXISTS create_address ^;
DROP FUNCTION IF EXISTS car_distance ^;
DROP FUNCTION IF EXISTS get_daily_rate_by_rental__details_id ^;
DROP FUNCTION IF EXISTS get_status_by_rental_dt ^;
DROP TRIGGER IF EXISTS total_income ^;
DROP TRIGGER IF EXISTS add_current_time_to_rental ^;
DROP TRIGGER IF EXISTS after_update_rental_cost ^;
DROP TRIGGER IF EXISTS add_status_to_rental ^;
DROP TRIGGER IF EXISTS set_date_end ^;
DROP TRIGGER IF EXISTS after_update_rental_cost ^;
DROP TRIGGER IF EXISTS add_current_time_to_rental ^;
DROP PROCEDURE IF EXISTS update_end_date_by_pk ^;
DROP PROCEDURE IF EXISTS update_rental_status_by_pk ^;
DROP FUNCTION IF EXISTS get_pk_car_param_by_pk_rental ^;
DROP TRIGGER IF EXISTS update_car_status_after_update ^;
DROP TRIGGER IF EXISTS update_car_status_after_insert ^;

CREATE PROCEDURE update_end_date_by_pk(IN p_pk_rental_details BIGINT)
BEGIN
    UPDATE rental_details
    SET date_end = CURRENT_TIMESTAMP
    WHERE PK_rental_details = p_pk_rental_details;
END ^;

CREATE PROCEDURE update_rental_status_by_pk(IN p_pk_rental BIGINT)
BEGIN
    UPDATE rental
    SET FK_status = 1
    WHERE PK_rental = p_pk_rental;
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

CREATE FUNCTION car_distance(date_from TIMESTAMP, date_end TIMESTAMP)
    RETURNS INT
    DETERMINISTIC
BEGIN
    DECLARE diff INT;
    SET diff = TIMESTAMPDIFF(SECOND, date_from, date_end);
    RETURN (RAND(1) * 10) * diff;
END ^;

CREATE TRIGGER update_car_status_after_insert
    AFTER INSERT
    ON rental
    FOR EACH ROW
BEGIN
    UPDATE car_parameter
    SET FK_car_status = 'UAV'
    WHERE PK_car_parameter = get_pk_car_param_by_pk_rental(NEW.PK_rental);
end ^;


CREATE TRIGGER update_car_status_after_update
    AFTER UPDATE
    ON rental
    FOR EACH ROW
BEGIN
    UPDATE car_parameter
    SET FK_car_status = 'AVI'
    WHERE PK_car_parameter = get_pk_car_param_by_pk_rental(OLD.PK_rental);
END ^;


CREATE FUNCTION get_pk_car_param_by_pk_rental(p_pk_rental BIGINT)
    RETURNS BIGINT
    DETERMINISTIC
BEGIN
    RETURN (SELECT FK_car_parameter
            FROM car AS c
                     JOIN rental AS r ON c.PK_car = r.FK_car
            WHERE r.PK_rental = p_pk_rental);
END ^;


CREATE TRIGGER after_update_rental_cost
    BEFORE UPDATE
    ON rental_details
    FOR EACH ROW
BEGIN
    DECLARE v_diff_date INT;
    DECLARE v_daily_rate INT;

    SET v_diff_date = TIMESTAMPDIFF(SECOND, OLD.date_from, NEW.date_end);
    SET v_daily_rate =
                v_diff_date * get_daily_rate_by_rental__details_id(OLD.PK_rental_details);
    SET NEW.rental_cost = v_diff_date * v_daily_rate;
    SET NEW.distance = car_distance(OLD.date_from, NEW.date_end);
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

DROP PROCEDURE IF EXISTS change_to_available_if_not_rented ^;
CREATE PROCEDURE change_to_available_if_not_rented(IN p_pk_car BIGINT, IN p_pk_car_status VARCHAR(3))
BEGIN

    UPDATE car_parameter
    SET FK_car_status = p_pk_car_status
    WHERE PK_car_parameter = (SELECT FK_car_parameter FROM car WHERE PK_car = p_pk_car);

    /*(SELECT FK_car_parameter
     FROM car as c
              join rental as r
                   on c.PK_car = r.FK_car
     WHERE c.PK_car = p_pk_car
       AND r.FK_status = 1)*/
end ^;

/*DROP TRIGGER IF EXISTS  add_role_to_new_user ^;
CREATE TRIGGER add_role_to_new_user
    AFTER INSERT
    ON
        user
    FOR EACH ROW
BEGIN
    INSERT INTO user_roles (FK_user, FK_role)
    VALUES (NEW.PK_user, (SELECT PK_role
                          FROM role
                          WHERE PK_role = 3));
END ^;*/


