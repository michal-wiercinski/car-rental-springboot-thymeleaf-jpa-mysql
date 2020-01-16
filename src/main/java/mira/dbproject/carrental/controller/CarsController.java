package mira.dbproject.carrental.controller;

import lombok.extern.slf4j.Slf4j;
import mira.dbproject.carrental.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/cars")
public class CarsController {

  @Autowired
  private CarService carService;

/*
  @GetMapping("/our-fleet")
  public String getAllCars(){

  }
*/

}
