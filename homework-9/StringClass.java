package com.kdu.AOP;

import org.springframework.stereotype.Component;

@Component
public class StringClass {
    public boolean comparingStrings(String string1, String string2) {
        return string1.equals(string2);
    }
}
