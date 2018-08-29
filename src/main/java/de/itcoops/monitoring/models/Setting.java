package de.itcoops.monitoring.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "settings")
public class Setting extends BaseModel {

  private static final long serialVersionUID = 0L;

  @Getter
  @Setter
  @Column(name = "_key", unique = true, nullable = false)
  private String key;

  public void setKey(String key) {
    this.key = key;
  }

  @Getter
  @Setter
  @Lob
  @Column(name = "_value")
  private Serializable value;

  public Serializable getValue() {
    return value;
  }
  public void setValue(Serializable value) {
    this.value = value;
  }

}