package com.userapp.example.demo.Models;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public  class UserValidator {

    public static boolean validatePassword(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasDigit = false;

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            }

            if (hasUpperCase && hasLowerCase && hasDigit) {
                return true;
            }
        }
        return false;
    }
    public static boolean validateName(String name){
        return (name.length() >=2);
    }
    public static boolean validateEmail(String email){

        String regex = "^[\\w\\.-]+@[\\w\\.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }
    public static boolean validateBirthday(String birthday){
            try {
                LocalDate.parse(birthday, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
                return true;
            } catch (DateTimeParseException e) {
                return false;
            }    }
    public static boolean validate(User user){
        if (
                validateName(user.getFirstName()) &&
                        validateName(user.getLastName()) &&
                        validateEmail(user.getEmail()) &&
                        validateBirthday(user.getBirthday()) &&
                        validatePassword(user.getPassword())
        ) return true;
        else return false;
    }
}
