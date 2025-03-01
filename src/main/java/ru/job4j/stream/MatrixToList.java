package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MatrixToList {
    public static List<Integer> convert(Integer[][] matrix) {
        return Arrays.stream(matrix).flatMap(i -> Arrays.stream(i))
                .collect(Collectors.toList());
    }
}
