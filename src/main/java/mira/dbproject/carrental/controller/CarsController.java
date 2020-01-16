package mira.dbproject.carrental.controller;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import mira.dbproject.carrental.domain.CarView;
import mira.dbproject.carrental.service.CarViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/cars")
public class CarsController {

  @Autowired
  private CarViewService carViewService;


  @GetMapping("/our-fleet")
  public String getAllCars(Model model) {
    List<CarView> detailsFleet = carViewService.findAll();
  //  log.info("Get view, size: {}", detailsFleet.size());
    model.addAttribute("detailsFleet", detailsFleet);
    return "fleetView";
  }


}
