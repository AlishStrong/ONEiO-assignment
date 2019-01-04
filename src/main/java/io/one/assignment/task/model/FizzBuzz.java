package io.one.assignment.task.model;

public class FizzBuzz {
    private Integer original;
    private String fizzBuzzed;

    public FizzBuzz(Integer original) {
        this.original = original;
        setFizzBuzzed(original);
    }

    public Integer getOriginal() {
        return original;
    }

    public String getFizzBuzzed() {
        return fizzBuzzed;
    }

    private void setFizzBuzzed(Integer input) {
        if (input % 3 == 0 && input % 5 == 0) {
            this.fizzBuzzed = "fizz buzz";
        } else if (input % 5 == 0) {
            this.fizzBuzzed = "buzz";
        } else if (input % 3 == 0) {
            this.fizzBuzzed = "fizz";
        } else {
            this.fizzBuzzed = String.valueOf(input);
        }
    }


}
