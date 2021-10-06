package nl.novi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionController {

    private static String[] questions = {
            "Wat is de hoofdstad van Nederland?",
            "Wat is de hoofdstad van Frankrijk?",
            "Wat is de hoofdstad van Engeland?"
    };

    private static String[] answers = {
            "Amsterdam",
            "Parijs",
            "London"
    };

    @GetMapping(value = "/questions/{id}")
    public String getQuestion(@PathVariable int id) {
        return questions[id];
    }

    @GetMapping(value = "/questions/{id}/answer")
    public String getAnswer(@PathVariable int id) {
        return answers[id];
    }

}
