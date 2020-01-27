package mira.dbproject.carrental.controller;

import mira.dbproject.carrental.domain.entity.RentalDetails;
import mira.dbproject.carrental.service.entityservice.RentalDetailService;
import mira.dbproject.carrental.service.viewservice.CarViewUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {

  private final CarViewUserService carViewUserService;
  private final RentalDetailService rentalDetailService;

  public IndexController(
      final CarViewUserService carViewUserService,
      final RentalDetailService rentalDetailService) {
    this.carViewUserService = carViewUserService;
    this.rentalDetailService = rentalDetailService;
  }

  @GetMapping("/")
  public String getWelcomePageWithStatus(Model model) {
    rentalDetailService.save(new RentalDetails());
    model.addAttribute("carsForUser", carViewUserService.findAllAvailable());
    return "index";
  }
}