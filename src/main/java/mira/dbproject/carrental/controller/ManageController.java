package mira.dbproject.carrental.controller;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import mira.dbproject.carrental.domain.dto.CarDto;
import mira.dbproject.carrental.domain.entity.BodyType;
import mira.dbproject.carrental.domain.entity.CarModel;
import mira.dbproject.carrental.domain.entity.CarStatus;
import mira.dbproject.carrental.domain.entity.Location;
import mira.dbproject.carrental.domain.view.CarViewAdmin;
import mira.dbproject.carrental.service.entityservice.BodyTypeService;
import mira.dbproject.carrental.service.entityservice.CarModelService;
import mira.dbproject.carrental.service.entityservice.CarService;
import mira.dbproject.carrental.service.entityservice.CarStatusService;
import mira.dbproject.carrental.service.entityservice.LocationService;
import mira.dbproject.carrental.service.viewservice.CarViewAdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/manage")
public class ManageController {

  private Logger logger = LoggerFactory.getLogger(getClass().getName());

  private List<BodyType> bodyTypes;
  private List<CarModel> carModels;
  private List<Location> locations;
  private List<CarStatus> carStatuses;

  private final BodyTypeService bodyTypeService;
  private final CarModelService carModelService;
  private final LocationService locationService;
  private final CarService carService;
  private final CarStatusService carStatusService;
  private final CarViewAdminService carViewAdminService;

  public ManageController(
      final BodyTypeService bodyTypeService,
      final CarModelService carModelService,
      final LocationService locationService,
      final CarService carService,
      final CarStatusService carStatusService,
      final CarViewAdminService carViewAdminService) {
    this.bodyTypeService = bodyTypeService;
    this.carModelService = carModelService;
    this.locationService = locationService;
    this.carService = carService;
    this.carStatusService = carStatusService;
    this.carViewAdminService = carViewAdminService;
  }

  @GetMapping("/new-car")
  public String newCarForm(Model model) {
    CarDto newCar = new CarDto();
    bodyTypes = bodyTypeService.findAll();
    carModels = carModelService.findAll();
    locations = locationService.findAll();
    carStatuses = carStatusService.findAll();

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

  @GetMapping("/edit-form/{id}")
  public String editCarForm(Model model, @PathVariable("id") Optional<Long> id) {
    if (id.isPresent()) {
      Long idl = id.get();
      if (carViewAdminService.findById(idl).isPresent()) {
        CarViewAdmin car = carViewAdminService.findById(idl).get();
        bodyTypes = bodyTypeService.findAll();
        carModels = carModelService.findAll();
        locations = locationService.findAll();
        carStatuses = carStatusService.findAll();
        model.addAttribute("editCar", car);
        model.addAttribute("carDto", new CarDto());
        model.addAttribute("bodyTypes", bodyTypes);
        model.addAttribute("carModels", carModels);
        model.addAttribute("locations", locations);
        model.addAttribute("carStatuses", carStatuses);
        return "editCarForm";
      } else {
        return "redirect:/";
      }
    } else {
      return "redirect:/";
    }
  }

  @PostMapping("/edit-car")
  public String editCar(@Valid @ModelAttribute CarDto carDto, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      System.out.println("there were errors");
      bindingResult.getAllErrors().forEach(error -> {
        String errorObjectName = error.getObjectName();
        logger.warn("Validation failed - Object '{}': {}",
            errorObjectName.substring(0, 1).toUpperCase() + errorObjectName.substring(1),
            error.getDefaultMessage());
      });
      return "editCarForm";
    }
    carService.createNewCar(carDto);
    return "index";
  }

  @RequestMapping(path = "/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
  public String deleteCarById(@PathVariable("id") Long id) {
    carService.deleteById(id);
    return "redirect:/cars/our-fleet";
  }
}