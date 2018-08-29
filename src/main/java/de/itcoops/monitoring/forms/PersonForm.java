package de.itcoops.monitoring.forms;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonForm {

  @NotNull(message="{validate.name}")
  @Size(min=2, max=30, message="{validation.Blank.message}")
  private String name;

  @NotNull
  @Min(18)
  private Integer age;

  public String toString() {
    return "Person(Name: " + this.name + ", Age: " + this.age + ")";
  }
}