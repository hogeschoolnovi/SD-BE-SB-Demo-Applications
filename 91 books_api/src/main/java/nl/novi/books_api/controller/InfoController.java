package nl.novi.books_api.controller;

import nl.novi.books_api.model.Info;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@CrossOrigin
@RequestMapping("/info")
public class InfoController {

    @GetMapping(value = "", produces = { "application/json" })
    public String info() {
        return Info.getInfo();
    }

}
