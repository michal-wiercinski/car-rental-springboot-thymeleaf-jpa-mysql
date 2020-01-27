package mira.dbproject.carrental.domain.view;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries(
    @NamedQuery(
        name = "CarViewUser.FindAllWhereAvailable",
        query = "SELECT c FROM CarViewUser c WHERE c.carStatus = :status"
    ))
@Entity
@Table(name = "details_fleet_for_user")
public class CarViewUser extends CarView {

}
