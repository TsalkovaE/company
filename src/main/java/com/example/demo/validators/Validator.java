package com.example.demo.validators;

public class Validator {
    public boolean validate(String input){
        return input.matches(("[a-zA-Z]"));
    }
}
