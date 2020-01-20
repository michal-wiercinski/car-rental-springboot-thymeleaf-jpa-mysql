drop trigger if exists total_income;
drop function if exists car_distance;

create trigger total_income
    before insert
    on rental_details
    for each row set @sum = @sum + NEW.rental_cost;


CREATE FUNCTION car_distance(numb_days int)
    RETURNS int
    deterministic
    RETURN (RAND(1) * 100) * numb_days;



DELIMITER //

DROP PROCEDURE IF EXISTS get_brand_name //

CREATE PROCEDURE get_brand_name(IN in_id INTEGER,
                                            OUT brd_name VARCHAR(20))
BEGIN
    SELECT brand_name
    INTO brd_name
    FROM brand
    where PK_brand = in_id;
END //

DELIMITER ;

