package de.itcoops.monitoring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AppSetting {
  
  public static final String SITE_NAME = "site_name";
  public static final String SITE_SLOGAN = "site_slogan";
  public static final String PAGE_SIZE = "page_site";

  @Autowired
  private SettingService settingService;

  private String siteName = "Name Einer Seite";
  private String siteSlogan = "An interesting place to discover";
  private Integer pageSize = 5;

  public String getSiteName() {
    return (String) settingService.get(SITE_NAME, siteName);
  }

  public void setSiteName(String siteName) {
    this.siteName = siteName;
    settingService.put(SITE_NAME, siteName);
  }

  public Integer getPageSize() {
    return (Integer) settingService.get(PAGE_SIZE, pageSize);
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
    settingService.put(PAGE_SIZE, pageSize);
  }

  public String getSiteSlogan() {
    return (String) settingService.get(SITE_SLOGAN, siteSlogan);
  }

  public void setSiteSlogan(String siteSlogan) {
    this.siteSlogan = siteSlogan;
    settingService.put(SITE_SLOGAN, siteSlogan);
  }
}