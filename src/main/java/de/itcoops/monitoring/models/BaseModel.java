package de.itcoops.monitoring.models;

import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;
import java.time.ZonedDateTime;


import javax.persistence.*;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseModel implements Comparable<BaseModel>, Serializable {

  private static final long serialVersionUID = 0L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;
  
  @Column(nullable = false)
    private ZonedDateTime createdAt;

    @Column(nullable = false)
    private ZonedDateTime updatedAt;

    @PrePersist
    public void prePersist() {
      createdAt = updatedAt = ZonedDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
      updatedAt = ZonedDateTime.now();
    }

    @Override
    public int compareTo(BaseModel o) {
      return this.getId().compareTo(o.getId());
    }

    public boolean equals(Object other) {
      if (other == null || other.getClass() != this.getClass()) {
        return false;
      }

      return this.getId().equals(((BaseModel) other).getId());
    }

    public int hashCode() {
      return new HashCodeBuilder().append(getId()).toHashCode();
    }

    public Long getId() {
      return id;
    }

    public void setId(Long _id) {
        id = _id;
    }

    public ZonedDateTime getCreatedAt() {
      return createdAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
      this.createdAt = createdAt;
    }

    public ZonedDateTime getUpdatedAt() {
      return updatedAt;
    }

    public void setUpdatedAt(ZonedDateTime updatedAt) {
      this.updatedAt = updatedAt;
    }
}