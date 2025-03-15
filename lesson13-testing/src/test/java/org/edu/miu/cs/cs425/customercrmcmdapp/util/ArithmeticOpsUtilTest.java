package org.edu.miu.cs.cs425.customercrmcmdapp.util;

import org.hamcrest.MatcherAssert;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class ArithmeticOpsUtilTest {
    ArithmeticOpsUtil util = new ArithmeticOpsUtil();

    @Test
    public void testSumArray() {
        assertEquals(util.add(1, 4), 5);
        assertThat(util.add(1, 4), equals(5));
        MatcherAssert.assertThat(util.add(1, 4), equals(5));
    }
}