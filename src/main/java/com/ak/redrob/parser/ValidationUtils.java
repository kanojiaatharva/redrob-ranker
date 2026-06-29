package com.ak.redrob.parser;

public final class ValidationUtils {

    private ValidationUtils(){}

    public static boolean isBlank(String value){
        return value == null || value.isBlank();
    }

}