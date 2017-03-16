package com.emgg.utils;

import com.emgg.NotFoundNumberException;
import com.emgg.constants.LcdRepresentation;
import com.emgg.constants.Messages;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by erik.giraldo on 14/03/17.
 */
public class SegmentUtil {

    public static String[] getSegmentForNumber(int number) throws NotFoundNumberException {
        String[] segment = LcdRepresentation.LCD_NUMBERS_REPRESENTANTION.get(number);
        if (segment == null) {
            throw new NotFoundNumberException(Messages.NUMBER_NOT_FOUND + ": " + Messages.NUMBER_NOT_FOUND.getValue());
        }
        return segment;
    }

    public static String[] getSegmentForNumber(int number, int size) throws NotFoundNumberException {
        List<String> segments = new ArrayList<>();
        String[] segment = new String[10];//LcdRepresentation.LCD_NUMBERS_REPRESENTANTION.get(number);
        switch(number) {
            case 2:
                segments.addAll(getSegmentsForSize(LcdRepresentation.MIDDLE, size, true, false, false));
                segments.addAll(getSegmentsForSize(LcdRepresentation.VERTICAL_LINE, size, false, true, true));
                segments.addAll(getSegmentsForSize(LcdRepresentation.MIDDLE, size, true, false, false));
                segments.addAll(getSegmentsForSize(LcdRepresentation.VERTICAL_LINE, size, false, true, false));
                segments.addAll(getSegmentsForSize(LcdRepresentation.MIDDLE, size, true, false, false));
                segment = segments.toArray(new String[segments.size()]);
                break;

        }

        if (segment == null) {
            throw new NotFoundNumberException(Messages.NUMBER_NOT_FOUND + ": " + Messages.NUMBER_NOT_FOUND.getValue());
        }
        return segment;
    }

    public static List<String> getSegmentsForSize(String segment, int size, boolean union, boolean space, boolean preAppend){
        List<String> toReturn = new ArrayList<>();
        if(union) {
            String result = "";
            for (int i = 0; i < size; i++) {
                result += segment;
            }
            toReturn.add(space == Boolean.TRUE ? determinateSpace(space, preAppend, result, size): result);
        }else{
            for (int i = 0; i < size; i++) {
                toReturn.add(space == Boolean.TRUE ? determinateSpace(space, preAppend, segment, size): segment);
            }
        }
        return toReturn;
    }

    private static String determinateSpace(boolean space, boolean preAppend, String result, int size){

        if(preAppend){
            return String.format("%"+size*4+"s", result);
        }else{
            return String.format("%-"+size*4+"s", result);
        }
    }

    public static String[][] getSegmentsForAllNumbers(int number) throws NotFoundNumberException {
        String digits = Integer.toString(number);
        String[][] result = new String[digits.length()][];
        for (int digitIndex = 0; digitIndex < digits.length(); digitIndex++) {
            result[digitIndex] = getSegmentForNumber(
                    Integer.parseInt(Character.toString(digits.charAt(digitIndex))));
        }
        return result;
    }

}
