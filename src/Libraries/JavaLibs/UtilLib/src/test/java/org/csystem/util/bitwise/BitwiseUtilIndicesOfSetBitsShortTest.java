package org.csystem.util.bitwise;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;

@RunWith(Parameterized.class)
public class BitwiseUtilIndicesOfSetBitsShortTest {
    private final DataInfo m_dataInfo;

    private static class DataInfo {
        short value;
        int [] expected;

        public DataInfo(short value, int[] expected)
        {
            this.value = value;
            this.expected = expected;
        }
    }

    @Parameterized.Parameters
    public static Collection<DataInfo> provideData()
    {
        return Arrays.asList(
                new DataInfo((short)10, new int[] {1, 3}),
                new DataInfo((short)11, new int [] {0, 1, 3}),
                new DataInfo(Short.MAX_VALUE, new int [] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14}),
                new DataInfo(Short.MIN_VALUE, new int[] {15}),
                new DataInfo((short)0, new int[0]),
                new DataInfo((short)1, new int[] {0}),
                new DataInfo((short)-1, new int[] {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15}));

    }

    public BitwiseUtilIndicesOfSetBitsShortTest(DataInfo dataInfo)
    {
        m_dataInfo = dataInfo;
    }

    @Test
    public void givenValue_whenValueIsShort_thenReturnNumberOfSetBits()
    {
        assertArrayEquals(m_dataInfo.expected, BitwiseUtil.indicesOfSetBits(m_dataInfo.value));
    }
}
