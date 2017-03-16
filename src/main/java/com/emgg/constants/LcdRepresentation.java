package com.emgg.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by erik.giraldo on 14/03/17.
 */
public class LcdRepresentation {

    public static final String RIGHT = "  |";
    public static final String MIDDLE = "_";
    public static final String MIDDLE_RIGHT = " _|";
    public static final String MIDDLE_LEFT = "|_ ";
    public static final String FULL = "|_|";
    public static final String RIGHT_LEFT = "| |";

    public static final String NONE = "  ";

    public static final String VERTICAL_LINE = "|";
    public static final String HORIZONTAL_LINE = "_";

    /**
     * Represents segments or symbol representation for numbers
     */
    public static final Map<Integer, String[]> LCD_NUMBERS_REPRESENTANTION = new HashMap<Integer, String[]>(){
        {
            put(new Integer(1), new String[]{NONE, RIGHT, RIGHT});
            put(new Integer(2), new String[]{MIDDLE, MIDDLE_RIGHT, MIDDLE_LEFT});
            put(new Integer(3), new String[]{MIDDLE, MIDDLE_RIGHT, MIDDLE_RIGHT});
            put(new Integer(4), new String[]{NONE, FULL, RIGHT});
            put(new Integer(5), new String[]{MIDDLE, MIDDLE_LEFT, MIDDLE_RIGHT});
            put(new Integer(6), new String[]{MIDDLE, MIDDLE_LEFT, FULL});
            put(new Integer(7), new String[]{MIDDLE, RIGHT, RIGHT});
            put(new Integer(8), new String[]{MIDDLE, FULL, FULL});
            put(new Integer(9), new String[]{MIDDLE, FULL, MIDDLE_RIGHT});
            put(new Integer(0), new String[]{MIDDLE, RIGHT_LEFT, FULL});
        }
    };
}
