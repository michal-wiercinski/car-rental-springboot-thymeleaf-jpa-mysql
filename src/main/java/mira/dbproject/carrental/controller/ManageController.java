package mira.dbproject.carrental.controller;

import java.util.List;
import javax.validation.Valid;
import mira.dbproject.carrental.domain.dto.CarDto;
import mira.dbproject.carrental.domain.entity.BodyType;
import mira.dbproject.carrental.domain.entity.Car;
import mira.dbproject.carrental.domain.entity.CarModel;
import mira.dbproject.carrental.domain.entity.Location;
import mira.dbproject.carrental.service.BodyTypeService;
import mira.dbproject.carrental.service.CarModelService;
import mira.dbproject.carrental.service.CarService;
import mira.dbproject.carrental.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/manage")
public class ManageController {

  @Autowired
  BodyTypeService bodyTypeService;

  @Autowired
  CarModelService carModelService;

  @Autowired
  LocationService locationService;

  @Autowired
  CarService carService;

  @GetMapping("/new-car")
  public String newCarForm(Model model) {
    CarDto newCar = new CarDto();
    List<BodyType> bodyTypes = bodyTypeService.findAll();
    List<CarModel> carModels = carModelService.findAll();
    List<Location> locations = locationService.findAll();

    model.addAttribute("car", newCar);
    model.addAttribute("bodyTypes", bodyTypes);
    model.addAttribute("carModels", carModels);
    model.addAttribute("locations", locations);
    return "carForm";
  }

  @PostMapping("/add-car")
  public String createCar(@Valid CarDto newCar, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      System.out.println("there were errors");
      bindingResult.getAllErrors().forEach(error -> {
        System.out.println(error.getObjectName() + " " + error.getDefaultMessage());
      });
      return "carForm";
    }

    carService.createNewCar(newCar);
    return "index";
  }

}
