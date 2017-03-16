package com.emgg.service;

import com.emgg.exceptions.NotFoundNumberException;
import com.emgg.utils.ArrangeUtil;
import com.emgg.utils.SegmentUtil;

/**
 * Created by erik.giraldo on 14/03/17.
 */
public class LcdService {

    public String showLcd(int number){
        String result = "";
        try {
            String[][] segments = SegmentUtil.getSegmentsForAllNumbers(4);
            String[] segmentsSize = SegmentUtil.getSegmentForNumber(number, 2);
            String[] arrabgeResult = ArrangeUtil.arrangeHorizontally(segments);
            System.out.println(ArrangeUtil.join(segmentsSize, '\n'));
            result = ArrangeUtil.join(arrabgeResult, '\n');
        }catch(NotFoundNumberException ex){

        }
        return result;
    }

    public static void main(String[] args){
        LcdService service = new LcdService();
        System.out.println(service.showLcd(2));
    }
}
