package io.one.assignment.task.service;

import io.one.assignment.task.model.FizzBuzz;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FizzBuzzService {

    public String validateInput(String input) {
        if (input == null || input.replace(" ", "").equals("")) {
            return "Please, make a valid input";
        } else if (input.replace(" ", "").matches(".*[^,0-9].*|.*,,.*")) {
            return "Please, input number/s";
        } else {
            return "";
        }
    }

    public List<FizzBuzz> makeFizzBuzzList(List<Integer> inputList) {
        List<FizzBuzz> toReturn = inputList.stream().map(this::mapFizzBuzz).collect(Collectors.toList());
        return toReturn;
    }

    private FizzBuzz mapFizzBuzz(Integer input) {
        FizzBuzz toReturn = new FizzBuzz(input);
        return toReturn;
    }
}
