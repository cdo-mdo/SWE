package org.edu.miu.cs425.customercrmcmdapp;

import org.edu.miu.cs.cs425.customercrmcmdapp.util.ArithmeticOpsUtil;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.assertEquals;

public class ArithmeticOpsUtilTest {
    private ArithmeticOpsUtil arithmeticOpsUtil = new ArithmeticOpsUtil();

    @BeforeEach
    public void setUp() {

    }

    @AfterEach
    public void tearDown() {

    }

    @Test
    public void testAdd() {
        assertEquals(arithmeticOpsUtil.add(1, 2), 3);
    }

}
