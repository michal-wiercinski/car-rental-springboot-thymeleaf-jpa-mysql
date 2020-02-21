package mira.dbproject.carrental.controller;


import java.security.Principal;
import java.sql.DatabaseMetaData;
import java.sql.Timestamp;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import mira.dbproject.carrental.domain.entity.Rental;
import mira.dbproject.carrental.domain.entity.RentalDetails;
import mira.dbproject.carrental.domain.entity.User;
import mira.dbproject.carrental.security.MyUserPrincipal;
import mira.dbproject.carrental.service.entityservice.RentalDetailService;
import mira.dbproject.carrental.service.entityservice.RentalService;
import mira.dbproject.carrental.service.entityservice.RentalStatusService;
import mira.dbproject.carrental.service.viewservice.CarViewUserService;
import mira.dbproject.carrental.service.viewservice.RentalViewService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
  private final RentalViewService rentalViewService;
  private final RentalStatusService rentalStatusService;
  private final RentalDetailService rentalDetailService;

  public RentalController(
      final CarViewUserService carViewUserService,
      final RentalService rentalService,
      final RentalViewService rentalViewService,
      final RentalStatusService rentalStatusService,
      RentalDetailService rentalDetailService) {
    this.carViewUserService = carViewUserService;
    this.rentalService = rentalService;
    this.rentalViewService = rentalViewService;
    this.rentalStatusService = rentalStatusService;
    this.rentalDetailService = rentalDetailService;
  }

  @RequestMapping(path = "/{id}", method = {RequestMethod.POST, RequestMethod.GET})
  public String rentFormById(@PathVariable("id") Long id, HttpServletRequest servletRequest) {
    Principal principal = servletRequest.getUserPrincipal();
    rentalService.createRental(id, principal.getName());
    return "redirect:/rent-car/my-rent";
  }

  @GetMapping("/my-rent")
  public String getMyRent(Model model) {
    model.addAttribute("rentals", rentalViewService.findAll());
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
}