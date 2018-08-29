package de.itcoops.monitoring;

import com.google.common.collect.ImmutableMap;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import de.itcoops.monitoring.services.AppSetting;
//import de.itcoops.monitoring.services.SettingService;

@SpringBootApplication
@Configuration
public class MonitoringApplication extends SpringBootServletInitializer  {
  
  public static void main(String[] args) {
    SpringApplication app = new SpringApplication(MonitoringApplication.class);
    app.setDefaultProperties(ImmutableMap.of("spring.profiles.default", Constants.ENV_DEVELOPMENT));
    app.run(args);
  }

  @Bean(name="AppSetting")
  public AppSetting appSettings() {
    return new AppSetting();
  }
}