package com.sda.javaee9spring.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class FirstController {

// the same as @Slf4j
// private static final Logger log = LoggerFactory.getLogger(FirstController.class);


    @GetMapping({"/my-first-page", "/"})
    public String firstPage() {
        log.info("firstPage() method called!!!");
        // looking for html page inside resources/templates
        // Spring please use page: resources/templates/home-page.html
        return "home-page";
    }

    @GetMapping("/my-second-page")
    public String secondPage() {
        log.info("secondPage() method called!!!");
// looking for html page inside resources/templates
return "about";
    }

//    @GetMapping("/third-page")
//    @GetMapping(value = "/third-page")
//    @GetMapping(value = {"/third-page"},params = {})
    @GetMapping (value = { "/third-page", "/third-too", "/abcd"})
    public String thirdPage() {
        log.info("thirdPage() method was called!!!");
        return "pages/third-page";
    }

    // /my-name?name=tanel&surname=korvel
    // name param with value tanel
    // surname param with value korvel
    @GetMapping("/my-name")
    public String myName(@RequestParam(value = "name", defaultValue = "Jaan") String myName,
                         @RequestParam(value = "surname", defaultValue = "Tamm") String mySurname) {
        log.info("myName () method was called!!!");
        log.info("my name is: [{}] and my surname is:[{}]", myName, mySurname);
        log.info(String.format("my name is: [%] and my surname is:[%]", myName, mySurname));

        return "";
    }
}
