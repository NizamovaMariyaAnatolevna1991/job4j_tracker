package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] mleft = left.split("\\.", 2);
        String[] mright = right.split("\\.", 2);
        int lnumber = Integer.parseInt(mleft[0]);
        int rnumber = Integer.parseInt(mright[0]);
        return Integer.compare(lnumber, rnumber);
    }
}