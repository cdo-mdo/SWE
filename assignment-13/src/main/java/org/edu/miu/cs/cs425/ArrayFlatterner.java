package org.edu.miu.cs.cs425;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ArrayFlatterner {
    public int[] flattenArray(int[][] array) {
        if (array == null || array.length == 0) {
            return new int[0];
        }
        return Arrays.stream(array)   // Convert 2D array to Stream<int[]>
                .flatMapToInt(Arrays::stream) // Flatten it to IntStream
                .toArray();

    }
}
