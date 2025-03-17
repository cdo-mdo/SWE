package org.edu.miu.cs.cs425;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class ArrayReverserTest {
    ArrayReverser arrayReverser;

    @Mock
    private ArrayFlatterner arrayFlattenerMock;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize mocks
        arrayReverser = new ArrayReverser(arrayFlattenerMock);
    }

    @Test
    void testReverseArray() {
        int[][] inputArray = {
                {1, 2, 3},
                {4, 5},
                {6, 7, 8, 9}
        };
        int[] mockedFlattenedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] expectedReversedArray = {9, 8, 7, 6, 5, 4, 3, 2, 1};

        when(arrayFlattenerMock.flattenArray(inputArray)).thenReturn(mockedFlattenedArray);

        int[] result = arrayReverser.reverseArray(inputArray);

        assertArrayEquals(expectedReversedArray, result);
    }

    @Test
    void testReverseEmptyArray() {
        int[][] inputArray = new int[0][0];
        int[] mockedFlattenedArray = new int[0];
        int[] expectedReversedArray = new int[0];

        when(arrayFlattenerMock.flattenArray(inputArray)).thenReturn(mockedFlattenedArray);

        int[] result = arrayReverser.reverseArray(inputArray);

        assertArrayEquals(expectedReversedArray, result);
    }

}