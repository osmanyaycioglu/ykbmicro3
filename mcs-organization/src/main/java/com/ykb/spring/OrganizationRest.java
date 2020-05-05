package com.ykb.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@RestController
@RequestMapping("/organization")
public class OrganizationRest {

    @Autowired
    private RestTemplate restTemp;

    @Autowired
    private EurekaClient ec;

    @PostMapping("/create_employee")
    public String createEmployee() {
        String forObjectLoc = this.restTemp.getForObject("http://EMPLOYEE/employee/greet",
                                                         String.class);
        return forObjectLoc;
    }

    @PostMapping("/create_employee2")
    public String createEmployee2() {
        List<InstanceInfo> instancesLoc = this.ec.getApplication("EMPLOYEE")
                                                 .getInstances();
        for (InstanceInfo instanceInfoLoc : instancesLoc) {
            System.out.println(instanceInfoLoc);
        }

        InstanceInfo niLoc = this.ec.getNextServerFromEureka("EMPLOYEE",
                                                             false);

        RestTemplate restTemplateLoc = new RestTemplate();
        String forObjectLoc = restTemplateLoc.getForObject("http://"
                                                           + niLoc.getIPAddr()
                                                           + ":"
                                                           + niLoc.getPort()
                                                           + "/employee/greet",
                                                           String.class);
        return forObjectLoc;
    }

}
