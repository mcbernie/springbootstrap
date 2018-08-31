package de.itcoops.monitoring.rest;

import java.util.Collection;

//import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
//import org.springframework.http.MediaType;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ResponseBody;

import de.itcoops.monitoring.forms.PersonForm;
import de.itcoops.monitoring.models.Info;
import de.itcoops.monitoring.repositories.InfoRepository;
import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping(value = "/api/form")
@Slf4j
public class FormRestController {

  private SimpMessageSendingOperations messagingTemplate;

  private InfoRepository infoRepository;
  
  @Autowired
  FormRestController(
    InfoRepository infoRepository,
    SimpMessageSendingOperations messagingTemplate) {
      this.messagingTemplate = messagingTemplate;
      this.infoRepository = infoRepository;
  }


  @RequestMapping(method = RequestMethod.GET)
  Collection<Info> all() {
    return this.infoRepository.findAll( new Sort(Sort.Direction.ASC, "createdAt") );
  }

  @RequestMapping(method = RequestMethod.POST)
  ModelAndView submit(@Valid @ModelAttribute("personForm") PersonForm personForm, BindingResult result) {

    messagingTemplate.convertAndSend("/topic/formSubmitEvents", personForm);

    log.info("Called Submit inf FormRestController");
    if (result.hasErrors()) {
      return new ModelAndView("form/index :: info-form");
    } 

    return new ModelAndView("form/result :: content");
      
  }


}