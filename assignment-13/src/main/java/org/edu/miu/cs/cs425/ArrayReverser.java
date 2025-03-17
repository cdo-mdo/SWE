package org.edu.miu.cs.cs425;

import java.util.stream.IntStream;

public class ArrayReverser {
    ArrayFlatterner arrayFlatterner;

    public ArrayReverser(ArrayFlatterner arrayFlatterner) {
        this.arrayFlatterner = arrayFlatterner;
    }

    public int[] reverseArray(int[][] array) {
        ArrayFlatterner arrayFlatterner = new ArrayFlatterner();
        int[] result = arrayFlatterner.flattenArray(array);
        return IntStream.range(0, result.length)   // Create an index stream
                .map(i -> result[result.length - 1 - i]) // Map index to reversed position
                .toArray();
    }
}
