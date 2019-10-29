package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/")
public class SignCounterController {

    Pattern normalLetter = Pattern.compile("[a-z]");
    Pattern capitalLetter = Pattern.compile("[A-Z]");
    Pattern digit = Pattern.compile("\\d");

    @GetMapping("stringInformation/{value}")
    public String reverseString(@PathVariable String value){

        System.out.println(value);

        int normalLetterCounter = 0;
        int capitalLetterCounter = 0;
        int digitCounter = 0;
        int specialCounter = 0;

        for(int i=0; i<value.length(); i++){
            if(normalLetter.matcher(String.valueOf(value.charAt(i))).matches()){
                normalLetterCounter++;
            } else if(capitalLetter.matcher(String.valueOf(value.charAt(i))).matches()){
                capitalLetterCounter++;
            } else if(digit.matcher(String.valueOf(value.charAt(i))).matches()){
                digitCounter++;
            } else {
                specialCounter++;
            }
        }

        return "String contains: \nNormal letters: " + normalLetterCounter +"\nCapital letters: "
                + capitalLetterCounter + "\nDigits: " + digitCounter + "\nSpecial letters: " +
                specialCounter;
    }
}