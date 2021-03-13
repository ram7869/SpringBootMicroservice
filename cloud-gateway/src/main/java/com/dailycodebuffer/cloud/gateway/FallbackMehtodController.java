package com.dailycodebuffer.cloud.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackMehtodController {

    @GetMapping("/userFallback")
    public String getUserFallbackMethod(){
        return "User Service is taking more time than expected"+
                " Please call later";
    }

    @GetMapping("/depFallback")
    public String getDepFallbackMethod(){
        return "Department Service is taking more time than expected"+
                " Please call later";
    }

}
