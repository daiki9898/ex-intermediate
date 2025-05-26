package com.example.validation;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class HotelPriceValidator implements ConstraintValidator<HotelPrice, String> {
    @Override
    public boolean isValid(String number, ConstraintValidatorContext context) {
        if (number == null || number.isBlank()) {
            return true;
        } else {
            return number.matches("^[0-9]+$") && Integer.parseInt(number) >= 1000;
        }
    }
}
