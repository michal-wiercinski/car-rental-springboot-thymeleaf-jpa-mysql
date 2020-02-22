package mira.dbproject.carrental.controller;


import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import mira.dbproject.carrental.domain.entity.Rental;
import mira.dbproject.carrental.domain.entity.RentalDetails;
import mira.dbproject.carrental.domain.view.RentalView;
import mira.dbproject.carrental.service.entityservice.RentalDetailService;
import mira.dbproject.carrental.service.entityservice.RentalService;
import mira.dbproject.carrental.service.viewservice.CarViewUserService;
import mira.dbproject.carrental.service.viewservice.RentalViewService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/rent-car")
public class RentalController {

  private final CarViewUserService carViewUserService;
  private final RentalService rentalService;
  private final RentalViewService rentalViewService;
  private final RentalDetailService rentalDetailService;

  public RentalController(
      final CarViewUserService carViewUserService,
      final RentalService rentalService,
      final RentalViewService rentalViewService,
      final RentalDetailService rentalDetailService) {
    this.carViewUserService = carViewUserService;
    this.rentalService = rentalService;
    this.rentalViewService = rentalViewService;
    this.rentalDetailService = rentalDetailService;
  }

  @RequestMapping(value = {"/my-rent", "/my-rent/{sort},{direction}"})
  public String getMyRent(@PathVariable(name = "sort", required = false) Optional<String> sortParam,
      @PathVariable(name = "direction", required = false) Optional<String> directionParam,
      HttpServletRequest httpServletRequest, Model model) {
    List<RentalView> rentals;
    Principal principal = httpServletRequest.getUserPrincipal();
    if (principal != null) {
      if (sortParam.isPresent() && directionParam.isPresent()) {
        rentals = rentalViewService
            .findAllByEmailAndSortByParam(httpServletRequest.getUserPrincipal().getName(),
                sortParam.get(), directionParam.get());
      } else {
        rentals = rentalViewService.findByEmail(principal.getName());
      }
      model.addAttribute("rentals", rentals);
      return "myRentals";
    }
    return "loginPage";
  }

  @RequestMapping(value = {"/all-rent", "/all-rent/{sort},{direction}"}, method = RequestMethod.GET)
  public String getAllRental(
      @PathVariable(name = "sort", required = false) Optional<String> sortParam,
      @PathVariable(name = "direction", required = false) Optional<String> directionParam,
      Model model) {

    List<RentalView> rentals;

    if (sortParam.isPresent() && directionParam.isPresent()) {
      rentals = rentalViewService
          .findAllAndSortByParam(sortParam.get(), directionParam.get());
    } else {
      rentals = rentalViewService.findAll();
    }

    model.addAttribute("rentals", rentals);
    return "myRentals";
  }


  @RequestMapping(path = "/{id}", method = {RequestMethod.POST, RequestMethod.GET})
  public String rentFormById(@PathVariable("id") Long id, HttpServletRequest servletRequest) {
    Principal principal = servletRequest.getUserPrincipal();
    rentalService.createRental(id, principal.getName());
    return "redirect:/rent-car/my-rent";
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


}