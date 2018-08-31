package de.itcoops.monitoring.rest;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class ValidationResponse {
  private String status;
  private List errorMessageList;
}