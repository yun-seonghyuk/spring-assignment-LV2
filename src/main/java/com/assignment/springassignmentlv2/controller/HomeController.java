package com.assignment.springassignmentlv2.controller;

import com.assignment.springassignmentlv2.security.UserDetailsImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class HomeController {

  public String home(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails){
      model.addAttribute("username", userDetails.getUsername());
      return "index";
  }
}
