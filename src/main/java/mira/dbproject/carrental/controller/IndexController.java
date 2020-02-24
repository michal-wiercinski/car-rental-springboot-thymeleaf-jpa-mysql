package mira.dbproject.carrental.controller;

import mira.dbproject.carrental.service.viewservice.CarViewUserService;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {

  private final CarViewUserService carViewUserService;

  public IndexController(
      final CarViewUserService carViewUserService) {
    this.carViewUserService = carViewUserService;
  }

  @GetMapping("/")
  public String getWelcomePageWithStatus(Model model) {
    System.out.println(Direction.ASC.toString());
    model.addAttribute("carsForUser", carViewUserService.findAllAvailable());
    return "index";
  }
}