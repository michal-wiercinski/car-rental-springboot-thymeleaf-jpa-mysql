package mira.dbproject.carrental.controller;

import mira.dbproject.carrental.domain.entity.RentalDetails;
import mira.dbproject.carrental.repository.dao.AddressDao;
import mira.dbproject.carrental.repository.dao.BrandDao;
import mira.dbproject.carrental.service.entityservice.CarStatusService;
import mira.dbproject.carrental.service.entityservice.RentalDetailService;
import mira.dbproject.carrental.service.viewservice.CarViewUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class IndexController {

  @Autowired
  BrandDao brandDao;

  @Autowired
  AddressDao addressDao;

  @Autowired
  CarViewUserService carViewUserService;

  @Autowired
  CarStatusService carStatusService;

  @Autowired
  RentalDetailService rentalDetailService;


  @GetMapping("/")
  public String getWelcomePageWithStatus(Model model) {
    rentalDetailService.save(new RentalDetails());
    model.addAttribute("carsForUser", carViewUserService.findAllAvailable());
    return "index";
  }
}