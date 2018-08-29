package de.itcoops.monitoring.support.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class ViewHelper {
  private String applicationEnv;

  @Autowired
  public ViewHelper() {
    log.debug("ViewHelper autwired...");
  }

  public String getApplicationEnv() {
    return applicationEnv;
  }

  public void setApplicationEnv(String applicationEnv) {
    log.debug("ViewHelper setApplicationEvn called...");
    this.applicationEnv = applicationEnv;
  }

}