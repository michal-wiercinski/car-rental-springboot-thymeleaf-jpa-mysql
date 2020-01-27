package mira.dbproject.carrental.controller;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import mira.dbproject.carrental.domain.view.CarViewAdmin;
import mira.dbproject.carrental.domain.view.CarViewUser;
import mira.dbproject.carrental.service.viewservice.CarViewAdminService;
import mira.dbproject.carrental.service.viewservice.CarViewUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/cars")
public class CarsController {

  private final CarViewAdminService carViewAdminService;
  private final CarViewUserService carViewUserService;

  public CarsController(
      final CarViewAdminService carViewAdminService,
      final CarViewUserService carViewUserService) {
    this.carViewAdminService = carViewAdminService;
    this.carViewUserService = carViewUserService;
  }

  @GetMapping("/our-fleet")
  public String getAllCars(Model model) {
    List<CarViewAdmin> detailsFleet = carViewAdminService.findAll();

    model.addAttribute("detailsFleet", detailsFleet);
    return "fleetViewForAdmin";
  }

  @GetMapping("/")
  private String getAllCarsForUser(Model model) {
    List<CarViewUser> carsForUser = carViewUserService.findAll();

    model.addAttribute("carsForUser", carsForUser);
    return "fleetForUser";
  }

  @GetMapping("/available")
  private String getAllAvailableCars(Model model) {
    model.addAttribute("carsForUser", carViewUserService.findAllAvailable());
    return "fleetForUser";
  }
}