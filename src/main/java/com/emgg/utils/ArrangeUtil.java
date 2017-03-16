package com.emgg.utils;

/**
 * Created by erik.giraldo on 14/03/17.
 */
public class ArrangeUtil {

    /**
     * Arranges items horizontally for being shown
     * @param data
     * @return
     */
    public static String[] arrangeHorizontally(String[][] data) {

        String[] result = data[0].clone();
        for (int row = 1; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++)
                result[col] += data[row][col];
        }
        return result;
    }

    /**
     * Manually joins different Strings in an array with
     * a predefined delimiter
     * @param strings
     * @param delim
     * @return
     */
    public static String join(String[] strings, char delim) {
        StringBuffer sb = new StringBuffer();
        for (String string : strings) {
            if (sb.length() > 0)
                sb.append(delim);
            sb.append(string);
        }
        return sb.toString();
    }

    /**
     * Generates a String padding space based on
     * the size
     * @param size
     * @return
     */
    public static String getSpace(int size){
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < size*8; i++){
            str.append(" ");
        }
        return str.toString();
    }

}
