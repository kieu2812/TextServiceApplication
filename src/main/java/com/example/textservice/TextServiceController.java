package com.example.textservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TextServiceController {
    @GetMapping("/camelize")
    public String getCamelize(@RequestParam(required = true) String original,
                              @RequestParam(required = false) boolean initialCap){
       StringBuilder resultString = new StringBuilder();
       String[] words= original.split("_");
        for(String temp:words){
            resultString.append(Character.toUpperCase(temp.charAt(0)) + temp.substring(1));
        }
        if(!initialCap){
            resultString.setCharAt(0,Character.toLowerCase(resultString.charAt(0)));
        }
        return resultString.toString();
    }

}
