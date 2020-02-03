package mira.dbproject.carrental.controller;

import mira.dbproject.carrental.domain.UserDto;
import mira.dbproject.carrental.security.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

  private final UserService userService;

  public RegistrationController(final UserService userService) {
    this.userService = userService;
  }

  @GetMapping
  public String registerForm(Model model) {
    model.addAttribute("user", new UserDto());
    return "registration";
  }

  @PostMapping
  public String processRegistration(@ModelAttribute("user") UserDto userDto) {
    userService.registrationNewUser(userDto);
    return "redirect:/";
  }

}
