package io.one.assignment.task.controller;

import io.one.assignment.task.service.FizzBuzzService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class FizzBuzzController {

    private static final Logger logger = LoggerFactory.getLogger(FizzBuzzController.class);

    @Autowired
    FizzBuzzService service;

    @GetMapping(value = "/")
    public String index() {
        return "index";
    }

    @GetMapping(value = "/input")
    public String input(Model model) {
        model.addAttribute("errorText", "");
        model.addAttribute("inputText", "For example: 1, 2, 3...");
        return "input";
    }

    @PostMapping("/process")
    public String process(Model model, @RequestParam(value = "input") String input) {
        String errorMessage = "";
        errorMessage = service.validateInput(input);
        if (errorMessage.equals("")) {
            String[] inputArray = input.replace(" ", "").split(",");
            List<Integer> integerList = new ArrayList<>(Arrays.asList(inputArray).stream().map(Integer::valueOf).collect(Collectors.toList()));
            model.addAttribute("list", service.makeFizzBuzzList(integerList));
            model.addAttribute("finalText", input);
            return "output";
        } else {
            model.addAttribute("inputText", "Input: " + input + " - is incorrect!");
            model.addAttribute("errorText", errorMessage);
            return "input";
        }
    }
}
