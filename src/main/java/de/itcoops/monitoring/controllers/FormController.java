package de.itcoops.monitoring.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import de.itcoops.monitoring.forms.PersonForm;


@Controller
public class FormController {

  private SimpMessageSendingOperations messagingTemplate;

  @Autowired
  FormController(
      SimpMessageSendingOperations messagingTemplate
    ) {
    
    this.messagingTemplate = messagingTemplate;
  }

  @GetMapping("/form")
  public String greetingForm(PersonForm personForm) {
    //model.addAttribute("form", new Form());
    return "form/index";
  }

}