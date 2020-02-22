package mira.dbproject.carrental.controller;


import java.security.Principal;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import mira.dbproject.carrental.domain.entity.Rental;
import mira.dbproject.carrental.domain.entity.RentalDetails;
import mira.dbproject.carrental.domain.view.CarViewUser;
import mira.dbproject.carrental.domain.view.RentalViewForAdmin;
import mira.dbproject.carrental.domain.view.RentalViewForUser;
import mira.dbproject.carrental.service.entityservice.RentalDetailService;
import mira.dbproject.carrental.service.entityservice.RentalService;
import mira.dbproject.carrental.service.viewservice.CarViewUserService;
import mira.dbproject.carrental.service.viewservice.RentalViewAdminService;
import mira.dbproject.carrental.service.viewservice.RentalViewUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/rent-car")
public class RentalController {

  private final CarViewUserService carViewUserService;
  private final RentalService rentalService;
  private final RentalViewUserService rentalViewUserService;
  private final RentalViewAdminService rentalViewAdminService;
  private final RentalDetailService rentalDetailService;

  public RentalController(
      final CarViewUserService carViewUserService,
      final RentalService rentalService,
      final RentalViewUserService rentalViewService,
      final RentalViewAdminService rentalViewAdminService,
      final RentalDetailService rentalDetailService) {
    this.carViewUserService = carViewUserService;
    this.rentalService = rentalService;
    this.rentalViewUserService = rentalViewService;
    this.rentalViewAdminService = rentalViewAdminService;
    this.rentalDetailService = rentalDetailService;
  }

  @RequestMapping(path = "/{id}", method = {RequestMethod.POST, RequestMethod.GET})
  public String rentFormById(@PathVariable("id") Long id, HttpServletRequest servletRequest) {
    Principal principal = servletRequest.getUserPrincipal();
    rentalService.createRental(id, principal.getName());
    return "redirect:/rent-car/my-rent";
  }

  @RequestMapping(value = {"/my-rent", "/my-rent/{sort},{direction}"})
  public String getMyRent(@PathVariable(name = "sort", required = false) Optional<String> sortParam,
      @PathVariable(name = "direction", required = false) Optional<String> directionParam,
      Model model) {
    List<RentalViewForUser> rentals;

    if (sortParam.isPresent() && directionParam.isPresent()) {
      rentals = rentalViewUserService
          .findAllAndSortByParam(sortParam.get(), directionParam.get());
    } else {
      rentals = rentalViewUserService.findAll();
    }

    model.addAttribute("rentals", rentalViewUserService.findAll());
    return "myRentals";
  }

  @RequestMapping(path = "/cancel/{id}", method = {RequestMethod.POST, RequestMethod.GET})
  public String cancelRent(@PathVariable("id") Long id) {
    if (rentalService.findById(id).isPresent()) {
      Rental rental = rentalService.findById(id).get();
      RentalDetails rentalDetails = rental.getRentalDetails();

      rentalDetailService.updateDate(rentalDetails.getId());
      rentalService.updateStatus(id);

      //rentalService.save(rental);
    }
    return "redirect:/rent-car/my-rent";
  }

  @RequestMapping(value = {"/all-rent", "/all-rent/{sort},{direction}"}, method = RequestMethod.GET)
  public String getAllRental(
      @PathVariable(name = "sort", required = false) Optional<String> sortParam,
      @PathVariable(name = "direction", required = false) Optional<String> directionParam,
      Model model) {

    List<RentalViewForAdmin> rentals;

    if (sortParam.isPresent() && directionParam.isPresent()) {
      rentals = rentalViewAdminService
          .findAllAndSortByParam(sortParam.get(), directionParam.get());
    } else {
      rentals = rentalViewAdminService.findAll();
    }

    model.addAttribute("rentalsAdmin", rentals);
    return "fleetForUser";
  }


}