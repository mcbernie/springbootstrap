package de.itcoops.monitoring.models;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Info extends BaseModel  {

  private String message;
  private String header;
  
}