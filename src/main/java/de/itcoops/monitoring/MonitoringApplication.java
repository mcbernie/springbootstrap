package de.itcoops.monitoring;

import javax.annotation.PostConstruct;

import com.google.common.collect.ImmutableMap;

import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import de.itcoops.monitoring.services.AppSetting;
//import de.itcoops.monitoring.services.SettingService;
import de.itcoops.monitoring.support.web.ViewHelper;

import static de.itcoops.monitoring.Constants.ENV_CONTAINER;
import static de.itcoops.monitoring.Constants.ENV_PRODUCTION;
import static de.itcoops.monitoring.Constants.ENV_DEVELOPMENT;

@SpringBootApplication
@Configuration
public class MonitoringApplication extends SpringBootServletInitializer  {
  
  @Autowired
  private ViewHelper viewHelper;

  @Autowired
  private  Environment env;

  public static void main(String[] args) {
    SpringApplication app = new SpringApplication(MonitoringApplication.class);
    app.setDefaultProperties(ImmutableMap.of("spring.profiles.default", Constants.ENV_DEVELOPMENT));
    app.run(args);
  }

  @PostConstruct
  public void registerViewHelper() {
    viewHelper.setApplicationEnv(this.getApplicationEnv());
  }

  @Bean(name="AppSetting")
  public AppSetting appSettings() {
    return new AppSetting();
  }

  public String getApplicationEnv() {
    return this.env.acceptsProfiles(ENV_PRODUCTION) ? ENV_PRODUCTION : this.env.acceptsProfiles(ENV_DEVELOPMENT) ? ENV_DEVELOPMENT : ENV_CONTAINER;
    //return this.env.acceptsProfiles(ENV_PRODUCTION) ? ENV_PRODUCTION : ENV_DEVELOPMENT;
}
}