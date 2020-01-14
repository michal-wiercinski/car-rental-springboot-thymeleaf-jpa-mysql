package mira.dbproject.carrental.controller;

import java.util.List;
import javax.validation.Valid;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import mira.dbproject.carrental.domain.dto.CarDto;
import mira.dbproject.carrental.domain.entity.BodyType;
import mira.dbproject.carrental.domain.entity.CarModel;
import mira.dbproject.carrental.domain.entity.CarStatus;
import mira.dbproject.carrental.domain.entity.Location;
import mira.dbproject.carrental.service.BodyTypeService;
import mira.dbproject.carrental.service.CarModelService;
import mira.dbproject.carrental.service.CarService;
import mira.dbproject.carrental.service.CarStatusService;
import mira.dbproject.carrental.service.LocationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manage")
public class ManageController {

  private Logger logger = LoggerFactory.getLogger(getClass().getName());

  @Autowired
  BodyTypeService bodyTypeService;

  @Autowired
  CarModelService carModelService;

  @Autowired
  LocationService locationService;

  @Autowired
  CarService carService;

  @Autowired
  CarStatusService carStatusService;

  @GetMapping("/new-car")
  public String newCarForm(Model model) {
    CarDto newCar = new CarDto();
    List<BodyType> bodyTypes = bodyTypeService.findAll();
    List<CarModel> carModels = carModelService.findAll();
    List<Location> locations = locationService.findAll();
    List<CarStatus> carStatuses = carStatusService.findAll();

    model.addAttribute("car", newCar);
    model.addAttribute("bodyTypes", bodyTypes);
    model.addAttribute("carModels", carModels);
    model.addAttribute("locations", locations);
    model.addAttribute("carStatuses", carStatuses);

    return "carForm";
  }

  @PostMapping("/add-car")
  public String createCar(@Valid @ModelAttribute("car") CarDto car, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {

      System.out.println("there were errors");
      bindingResult.getAllErrors().forEach(error -> {
        String errorObjectName = error.getObjectName();
        logger.warn("Validation failed - Object '{}': {}",
            errorObjectName.substring(0, 1).toUpperCase() + errorObjectName.substring(1),
            error.getDefaultMessage());
      });
      return "carForm";
    }

    carService.createNewCar(car);
    return "index";
  }
}
