package com.emgg.utils;

import com.emgg.exceptions.NotFoundNumberException;
import com.emgg.constants.LcdRepresentation;
import com.emgg.constants.Messages;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by erik.giraldo on 14/03/17.
 *
 * Utilitary class for managing numbers segments and operations
 * @version 1.0.0
 */
public class SegmentUtil {

    /**
     * Gets the segments for an specific number. This method doesn't have in mind
     * the specific size
     * @param number
     * @return String[] Segments
     * @throws NotFoundNumberException
     */
    public static String[] getSegmentForNumber(int number) throws NotFoundNumberException {
        String[] segment = LcdRepresentation.LCD_NUMBERS_REPRESENTANTION.get(number);
        if (segment == null) {
            throw new NotFoundNumberException(Messages.NUMBER_NOT_FOUND + ": " + Messages.NUMBER_NOT_FOUND.getValue());
        }
        return segment;
    }

    /**
     * Gets the segments for an specific numbers. This method keeps in consideration the size
     *
     * @param number
     * @param size
     * @return
     * @throws NotFoundNumberException
     */
    public static String[] getSegmentForNumber(int number, int size) throws NotFoundNumberException {
        List<String> segments = new ArrayList<>();
        String[] segment = new String[10];//LcdRepresentation.LCD_NUMBERS_REPRESENTANTION.get(number);
        //TODO: Generate method for numbers that can not be formeds only by basic strusctures
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

    /**
     * Generates the corresponding segments based on the size, if they must be sequentially and
     * where to append white padding
     *
     * @param segment {@link String} to be evaluated
     * @param size {@link Integer} that indicates the size
     * @param union {@link Boolean} if it is sequentially or not
     * @param space {@link String} indicating the space
     * @param preAppend {@link Boolean} to validate where to append a space
     * @return
     */
    public static List<String> getSegmentsForSize(String segment, int size, boolean union, boolean space, boolean preAppend){
        List<String> toReturn = new ArrayList<>();
        if(union) {
            String result = "";
            for (int i = 0; i < size; i++) {
                result += segment;
            }
            toReturn.add(space == Boolean.TRUE ? determinateSpace(preAppend, result, size): result);
        }else{
            for (int i = 0; i < size; i++) {
                toReturn.add(space == Boolean.TRUE ? determinateSpace(preAppend, segment, size): segment);
            }
        }
        return toReturn;
    }

    /**
     * Generates an space before or after a String
     * @param preAppend {@link Boolean} indicating if it's before or after
     * @param result {@link String} to be manipulated
     * @param size
     * @return
     */
    private static String determinateSpace(boolean preAppend, String result, int size){

        if(preAppend){
            return String.format("%"+size*4+"s", result);
        }else{
            return String.format("%-"+size*4+"s", result);
        }
    }

    /**
     * Parse all the digits of a number and gets them all
     * @param number
     * @return
     * @throws NotFoundNumberException
     */
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
