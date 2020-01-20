package mira.dbproject.carrental.controller;


import mira.dbproject.carrental.domain.entity.Rental;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rent-car")
public class RentalController {

  @GetMapping("/")
  public String rentForm(Model model){
    model.addAttribute("rental", new Rental());

    return "rentalForm";
  }

}
