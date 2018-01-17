package com.siemens.mindsphere.web.rest;

import ch.qos.logback.classic.LoggerContext;
import com.codahale.metrics.annotation.Timed;
import com.siemens.mindsphere.web.rest.vm.LoggerVM;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class SystemInfoResource {

    @GetMapping("/sys-info")
    @Timed

    public SysInfo getSysInfo() {

        Properties sysProperty=System.getProperties();
        SysInfo info =new SysInfo();

        info.setOs_name(sysProperty.getProperty("os.name"));
        info.setOs_version(sysProperty.getProperty("os.version"));
        return info;
    }

}

 class SysInfo{

    private String os_name;
    private String os_version;

     public String getOs_version() {
         return os_version;
     }

     public void setOs_version(String os_version) {
         this.os_version = os_version;
     }

     public String getOs_name() {
         return os_name;
     }

     public void setOs_name(String os_name) {
         this.os_name = os_name;
     }


 }
