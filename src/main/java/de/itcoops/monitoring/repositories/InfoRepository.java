package de.itcoops.monitoring.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import de.itcoops.monitoring.models.Info;

public interface InfoRepository extends JpaRepository<Info, Long> {
  Collection<Info> findByHeader(@Param("header") String header);
}