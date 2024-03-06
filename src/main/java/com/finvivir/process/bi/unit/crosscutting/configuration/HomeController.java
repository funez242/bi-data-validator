package com.finvivir.process.bi.unit.crosscutting.configuration;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Home redirection to swagger api documentation
 * Description: Redirect root URL to Swagger
 */
@Controller
public class HomeController {
    /**
     * Index string.
     *
     * @return the string
     */
    @RequestMapping(value = "/")
    public String index() {
        return "redirect:/swagger-ui/";
    }
}
