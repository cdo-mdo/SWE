package org.edu.miu.cs.cs425;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArrayFlatternerTest {
    ArrayFlatterner arrayFlatterner = new ArrayFlatterner();

    @Test
    void testNullArray() {
        int[] expected = new int[0];  // Expected result: empty 1D array
        assertArrayEquals(expected, arrayFlatterner.flattenArray(null));
    }

    @Test
    void testEmptyArray() {
        int[][] emptyArray = new int[0][0];  // Empty 2D array
        int[] expected = new int[0];  // Expected result: empty 1D array
        assertArrayEquals(expected, arrayFlatterner.flattenArray(emptyArray));
    }

    @Test
    void testNonEmptyArray() {
        int[][] inputArray = {
                {1, 2, 3},
                {4, 5},
                {6, 7, 8, 9}
        };
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertArrayEquals(expected, arrayFlatterner.flattenArray(inputArray));
    }

    @Test
    void testSingleRowArray() {
        int[][] inputArray = {{10, 20, 30}};
        int[] expected = {10, 20, 30};
        assertArrayEquals(expected, arrayFlatterner.flattenArray(inputArray));
    }

    @Test
    void testSingleColumnArray() {
        int[][] inputArray = {{1}, {2}, {3}, {4}};
        int[] expected = {1, 2, 3, 4};
        assertArrayEquals(expected, arrayFlatterner.flattenArray(inputArray));
    }

    @Test
    void testArrayWithEmptyRows() {
        int[][] inputArray = {
                {},
                {1, 2},
                {},
                {3, 4, 5},
                {}
        };
        int[] expected = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, arrayFlatterner.flattenArray(inputArray));
    }
}