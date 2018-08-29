package de.itcoops.monitoring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;

import de.itcoops.monitoring.services.AppSetting;
import lombok.extern.slf4j.Slf4j;

/**
 * HomeController Class Root View 
 * 
 * @author: Nico
 * @version: 0.1
 */
@Controller
@Slf4j
public class HomeController {

  private AppSetting appSetting;

  @Autowired
  private HomeController(AppSetting appSetting) {
    this.appSetting = appSetting;
  }

  @GetMapping(value="")
  public String index(Model model) {

    log.error("Hallo Index");
    log.info("ich bin total toll und so!");
    /* Simple Overwrite DB Settings test */
    
    //appSetting.setSiteName("Was Geht ab du seite du...");    
    model.addAttribute("placeholdertext", "<b>M</b>ein Name ist Nicolas");

    return "home/index";
  }
}