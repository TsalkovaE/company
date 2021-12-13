package com.example.demo.validators;

public class Validator {
    public boolean validateName(String input){
        return input.matches("[a-zA-Z]+");
    }
}
