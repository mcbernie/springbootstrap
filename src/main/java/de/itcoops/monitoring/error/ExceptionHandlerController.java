package de.itcoops.monitoring.error;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

//import lombok.extern.slf4j.Slf4j;


@ControllerAdvice
class ExceptionHandlerController {

  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler(NotFoundException.class)
  public ModelAndView notFoundErrorHandler(HttpServletRequest req, NotFoundException e) throws Exception {
    String uri = req.getRequestURI();

    //log.error("Request page: {} raised NotFoundException {}", uri, exception);
    System.out.println("BFFFFFFFFFFFIJfij ------------------------------------------->");
    ModelAndView model = new ModelAndView();
    model.addObject("exception", e);
    model.addObject("url", uri);
    model.setViewName("error/general");

    return model;
  }

  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ExceptionHandler(Exception.class)
  public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
    String uri = req.getRequestURI();

    //log.error("Request page: {} raised NotFoundException {}", uri, exception);
    System.out.println("BFFFFFFFFFFFIJfij ------------------------------------------->");
    ModelAndView model = new ModelAndView();
    model.addObject("exception", e);
    model.addObject("url", uri);
    model.setViewName("error/general");

    return model;
  }
}