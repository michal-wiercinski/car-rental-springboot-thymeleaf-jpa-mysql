package mira.dbproject.carrental.controller;


import mira.dbproject.carrental.domain.entity.Rental;
import mira.dbproject.carrental.service.entityservice.RentalService;
import mira.dbproject.carrental.service.entityservice.RentalStatusService;
import mira.dbproject.carrental.service.viewservice.CarViewUserService;
import mira.dbproject.carrental.service.viewservice.RentalViewService;
import org.springframework.beans.factory.annotation.Autowired;
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

  public RentalController(
      final CarViewUserService carViewUserService,
      final RentalService rentalService,
      final RentalViewService rentalViewService,
      final RentalStatusService rentalStatusService) {
    this.carViewUserService = carViewUserService;
    this.rentalService = rentalService;
    this.rentalViewService = rentalViewService;
    this.rentalStatusService = rentalStatusService;
  }

  @RequestMapping(path = "/{id}", method = {RequestMethod.POST, RequestMethod.GET})
  public String rentFormById(@PathVariable("id") Long id) {
    rentalService.createRental(id);
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
      rental.setRentalStatus(rentalStatusService.findById(1L).get());
      rentalService.save(rental);
    }
    return "redirect:/rent-car/my-rent";
  }
}