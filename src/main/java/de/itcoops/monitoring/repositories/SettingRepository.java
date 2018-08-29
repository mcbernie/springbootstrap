package de.itcoops.monitoring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.itcoops.monitoring.models.Setting;

@Repository
public interface SettingRepository extends JpaRepository<Setting, Long> {
  Setting findByKey(String key);
}