package mira.dbproject.carrental.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import mira.dbproject.carrental.domain.view.CarViewAdmin;
import mira.dbproject.carrental.domain.view.CarViewUser;
import mira.dbproject.carrental.service.viewservice.CarViewAdminService;
import mira.dbproject.carrental.service.viewservice.CarViewUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

  @RequestMapping(value = {"/our-fleet",
      "/our-fleet/{sort},{direction}"}, method = RequestMethod.GET)
  public String getAllCars(
      @PathVariable(name = "sort", required = false) Optional<String> sortParam,
      @PathVariable(name = "direction", required = false) Optional<String> directionParam,
      Model model) {
    List<CarViewAdmin> detailsFleet;

    if (sortParam.isPresent() && directionParam.isPresent()) {
      detailsFleet = carViewAdminService
          .findAllAndSortByParam(sortParam.get(), directionParam.get());
    } else {
      detailsFleet = carViewAdminService.findAll();
    }

    model.addAttribute("detailsFleet", detailsFleet);
    return "fleetViewForAdmin";
  }

  @RequestMapping(value = {"/", "/{sort},{direction}"}, method = RequestMethod.GET)
  private String getAllCarsForUser(
      @PathVariable(name = "sort", required = false) Optional<String> sortParam,
      @PathVariable(name = "direction", required = false) Optional<String> directionParam,
      Model model) {
    List<CarViewUser> carsForUser;
    if (sortParam.isPresent() && directionParam.isPresent()) {
      carsForUser = carViewUserService
          .findAllAndSortByParam(sortParam.get(), directionParam.get());
    } else {
      carsForUser = carViewUserService.findAll();
    }

    model.addAttribute("carsForUser", carsForUser);
    return "fleetForUser";
  }

  @RequestMapping(path = {"/available",
      "available/sorting/{sort},{direction}"}, method = RequestMethod.GET)
  private String getAllAvailableCars(@PathVariable("sort") String sortParam,
      @PathVariable("direction") String directionParam, Model model) {
    model.addAttribute("carsForUser", carViewUserService.findAllAvailable());
    return "fleetForUser";
  }
}