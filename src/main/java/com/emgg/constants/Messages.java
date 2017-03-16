package com.emgg.constants;

/**
 * Created by erik.giraldo on 14/03/17.
 */
public enum Messages {

    NUMBER_NOT_FOUND("Segment not found for number");

    private String value;

    Messages(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }
}
