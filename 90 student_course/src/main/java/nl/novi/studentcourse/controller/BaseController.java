package nl.novi.studentcourse.controller;

import nl.novi.studentcourse.model.Info;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class BaseController {

    @GetMapping(value = "/")
    public String hello() {
        return "Demo for many-to-many RESTful webservice";
    }

    @GetMapping(value = "/info", produces = { "application/json" })
        public String info() {
            return Info.getInfo();
        }

}
