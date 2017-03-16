package com.emgg.utils;

import com.emgg.exceptions.NotFoundNumberException;
import com.emgg.constants.LcdRepresentation;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;



/**
 * Created by erik.giraldo on 14/03/17.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(SegmentUtil.class)
public class SegmentUtilTest {

    @Test
    public void testSegmentForNumber() throws NotFoundNumberException {
        int one = 1;
        String[] expectedSegments = new String[]{LcdRepresentation.NONE,
                LcdRepresentation.RIGHT, LcdRepresentation.RIGHT};
        PowerMockito.mockStatic(SegmentUtil.class);
        Mockito.when(SegmentUtil.getSegmentForNumber(one)).thenReturn(new String[]{LcdRepresentation.NONE,
                LcdRepresentation.RIGHT, LcdRepresentation.RIGHT});

        Assert.assertArrayEquals(expectedSegments, SegmentUtil.getSegmentForNumber(one));
    }
}
