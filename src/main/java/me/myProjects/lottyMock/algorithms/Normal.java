package me.myProjects.lottyMock.algorithms;

import me.myProjects.lottyMock.bean.LottyNumber;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by chendong on 2017/2/16.
 * <p>
 * normal algorithm
 */
public class Normal {

    public static List<LottyNumber> getPositive6(LottyNumber[] numbers) {
        return Arrays.stream(numbers)
                .sorted(Comparator.comparing(LottyNumber::getClose))
                .collect(Collectors.toList())
                .subList(0, 5);
    }



}
